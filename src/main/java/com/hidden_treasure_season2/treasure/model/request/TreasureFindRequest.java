package com.hidden_treasure_season2.treasure.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class TreasureFindRequest {

    private final Long userId;

    private final String treasureCode;

    @JsonCreator
    public TreasureFindRequest(final Long userId, final String treasureCode) {
        this.userId = userId;
        this.treasureCode = treasureCode;
    }
}
