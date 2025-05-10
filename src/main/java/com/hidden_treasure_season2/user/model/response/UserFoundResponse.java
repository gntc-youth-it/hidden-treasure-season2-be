package com.hidden_treasure_season2.user.model.response;

import com.hidden_treasure_season2.user.domain.User;
import lombok.Getter;

@Getter
public class UserFoundResponse {

    private final Long id;

    private final int foundCount;

    public UserFoundResponse(final User user) {
        this.id = user.getId();
        this.foundCount = user.getCatchTimes();
    }
}
