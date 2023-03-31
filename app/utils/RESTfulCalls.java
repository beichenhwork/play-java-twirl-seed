package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.Config;
import play.Logger;
import play.api.Play;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @description: RESTful call functions
 * @author:  Beichen Hu
 * @create: 2023-03-30
 */
public class RESTfulCalls {
    private static final WSClient WS;
    static {
        WS = Play.current().injector().instanceOf(WSClient.class);
    }

    /**
     * Response Type
     */
    public static enum ResponseType{
        SUCCESS, GENERALERROR, GETERROR, SAVEERROR, DELETEERROR, RESOLVEERROR, TIMEOUT, CONVERSIONERROR, UNKNOWN
    }


    /**
     * Create a backend url that can be passed on the API method calls, using path.
     *
     * @param config project config setting in application.conf
     * @param path the relative path to generate the full path from
     * @return the absolute backend path of the REST API to be called
     */
    public static String getBackendAPIUrl(Config config, String path){
        String protocol = config.getString("system.backend.rest-protocol");
        String host = config.getString("system.backend.rest-host");
        String port = config.getString("system.backend.rest-port");

        // build proper url
        StringBuilder url = new StringBuilder(protocol + "://");
        url.append(host);
        if(port!= null && port!=""){
            url.append(":" + port);

        }else{
            url.append(Constants.SMU_FRONTEND_PORT);
        }
        url.append(path);
        return url.toString();
    }

    /**
     * This method intends to post an API call and generate a response json.
     *
     * @param apiString absolute path of the REST API to be called
     * @return
     */
    public static JsonNode getAPI(String apiString){
        if(WS==null){
            Logger.info("error");
        }
        try{
            // get API call
            CompletionStage<WSResponse> responsePromise = WS.url(apiString)
                    .setRequestTimeout(Duration.of(50000, ChronoUnit.MILLIS))
                    .get();
            final CompletionStage<JsonNode> bodyPromise = responsePromise.thenApplyAsync(
                    new Function<WSResponse, JsonNode>() {
                        public JsonNode apply(WSResponse response) {
                            if ((response.getStatus() == 201 || response.getStatus() == 200)) {
                                try {
                                    return response.asJson();
                                } catch (Exception e) {
                                    // if response is in Json format, return as json otherwise return plain success
                                    return createResponse(ResponseType.SUCCESS);
                                }
                            } else {
                                // no response from server
                                return createResponse(ResponseType.GETERROR);
                            }
                        }
                    }
            );

            CompletableFuture<JsonNode> future = bodyPromise.toCompletableFuture();
            return future.get(30, TimeUnit.SECONDS);
        } catch (Exception e){
            Logger.debug("RESTfulCalls.getAPI(): API Exception: " + e);
            return createResponse(ResponseType.TIMEOUT);
        }
    }

    /**
     * This method intends to post an API call and generate a response json.
     *
     * @param apiString absolute path of the REST API to be called
     * @param jsonData data passed through json format
     * @return
     */
    public static JsonNode postAPI(String apiString, JsonNode jsonData){
        if(WS==null){
            Logger.info("error");
        }
        try{
            // post API call
            CompletionStage<WSResponse> responsePromise = WS.url(apiString)
                    .setRequestTimeout(Duration.of(50000, ChronoUnit.MILLIS))
                    .post(jsonData);
            final CompletionStage<JsonNode> bodyPromise = responsePromise.thenApplyAsync(
                new Function<WSResponse, JsonNode>() {
                    public JsonNode apply(WSResponse response) {
                        if ((response.getStatus() == 201 || response.getStatus() == 200)) {
                            try {
                                return response.asJson();
                            } catch (Exception e) {
                                // if response is in Json format, return as json otherwise return plain success
                                return createResponse(ResponseType.SUCCESS);
                            }
                        } else {
                            return createResponse(ResponseType.SAVEERROR);
                        }
                    }
                }
            );
            CompletableFuture<JsonNode> future = bodyPromise.toCompletableFuture();
            return future.get(30, TimeUnit.SECONDS);
        } catch (Exception e){
            Logger.debug("RESTfulCalls.postAPI(): API Exception: " + e);
            return createResponse(ResponseType.TIMEOUT);
        }
    }

    /**
     * This method intends to create an internal response object in json node as response from RESTful call
     * @param type error type
     * @return error message in json
     */
    public static JsonNode createResponse(ResponseType type){
        ObjectNode jsonData = Json.newObject();
        switch (type){
            case SUCCESS:
                jsonData.put("success", "Success!");
                break;
            case GETERROR:
                jsonData.put("error", "Cannot get data from server!");
                break;
            case GENERALERROR:
                jsonData.put("error", "Generate error!");
                break;
            case SAVEERROR:
                jsonData.put("error", "Cannot be saved. The data must be invalid!");
                break;
            case RESOLVEERROR:
                jsonData.put("error", "Cannot be resolved on server!");
                break;
            case TIMEOUT:
                jsonData.put("error", "No response/Timeout from server!");
                break;
            case CONVERSIONERROR:
                jsonData.put("error", "Conversion error!");
                break;
            case DELETEERROR:
                jsonData.put("error", "Cannot be deleted on server");
            default:
                jsonData.put("error", "Unknown error!");
                break;
        }
        return jsonData;
    }
}
