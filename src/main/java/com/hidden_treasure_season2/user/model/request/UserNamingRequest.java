package com.hidden_treasure_season2.user.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class UserNamingRequest {

    private final Long userId;

    private final String name;

    @JsonCreator
    public UserNamingRequest(final Long userId, final String name) {
        this.userId = userId;
        this.name = name;
    }
}
