package com.hidden_treasure_season2.user.model;

import lombok.Getter;

@Getter
public class UserCreationResponse {

    private final boolean succeed;

    public UserCreationResponse() {
        this.succeed = true;
    }
}
