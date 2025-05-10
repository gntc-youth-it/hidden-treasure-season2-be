package com.hidden_treasure_season2.user.model.response;

import com.hidden_treasure_season2.user.domain.User;
import lombok.Getter;

@Getter
public class UserNamingResponse {

    private final Long userId;

    private final String name;

    public UserNamingResponse(final User user) {
        this.userId = user.getId();
        this.name = user.getName();
    }
}
