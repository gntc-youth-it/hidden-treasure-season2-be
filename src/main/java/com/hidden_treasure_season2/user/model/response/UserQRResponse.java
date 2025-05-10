package com.hidden_treasure_season2.user.model.response;

import com.hidden_treasure_season2.user.domain.User;
import lombok.Getter;

@Getter
public class UserQRResponse {

    private final Long id;

    private final String image;

    public UserQRResponse(final User user) {
        this.id = user.getId();
        this.image = user.getQRImage();
    }
}
