package models;

import lombok.Data;

@Data
public class AddUserResponse {
    private int code;
    private String type;
    private String message;
}
