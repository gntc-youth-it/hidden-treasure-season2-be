package com.hidden_treasure_season2.user.model.response;

import com.hidden_treasure_season2.user.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;

    private final String name;

    public UserResponse(final User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
