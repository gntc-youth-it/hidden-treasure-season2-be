package com.hidden_treasure_season2.treasure.model.response;

import lombok.Getter;

@Getter
public class TreasureCreationResponse {

    private final boolean succeed;

    public TreasureCreationResponse() {
        this.succeed = true;
    }
}
