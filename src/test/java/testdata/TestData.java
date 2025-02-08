package testdata;

import models.User;

public class TestData {
    public static final User DEFAULT_USER = User.builder()
            .username("username")
            .firstName("firstName")
            .lastName("lastName")
            .email("email")
            .phone("password")
            .userStatus(0)
            .build();

    public static final User INVALID_USER = User.builder().build();
}
