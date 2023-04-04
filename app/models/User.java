package models;


import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * @description: user model. Make sure the fields are the same as backend user model.
 * @author: Junhao Shen, Beichen Hu
 * @create: 2023-03-30
 */
public class User {
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static User deserialize(JsonNode json){
        if (json == null) {
            throw new NullPointerException("User node should not be null to be serialized.");
        }
        User oneUser = Json.fromJson(json, User.class);

        // oneUser.setProjectZone(Project.deserialize(json.findPath("project")));
        return oneUser;
    }

}
