package com.hidden_treasure_season2.treasure.model.response;

import com.hidden_treasure_season2.treasure.domain.Treasure;
import com.hidden_treasure_season2.user.domain.User;
import lombok.Getter;

@Getter
public class TreasureFindResponse {

    private final Long userId;

    private final Long treasureId;

    public TreasureFindResponse(final User user, final Treasure treasure) {
        this.userId = user.getId();
        this.treasureId = treasure.getId();
    }
}
