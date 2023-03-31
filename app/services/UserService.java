package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.Config;
import models.User;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * @description: user services class, you can put some other external services for user at here.
 * For example: set up Recaptcha Key, send email to reset password...
 *
 * @author: Beichen Hu
 * @create: 2023-03-30
 */
public class UserService {
    @Inject
    Config config;
    /**
     * Deserializes the json to a User.
     *
     * @param json the json to convert from.
     * @return the dataset object.
     */
    public static User deserialize(JsonNode json){
        if (json == null) {
            throw new NullPointerException("User node should not be null to be serialized.");
        }
        User oneUser = Json.fromJson(json, User.class);

        // oneUser.setProjectZone(Project.deserialize(json.findPath("project")));
        return oneUser;
    }

}
