package com.hidden_treasure_season2.treasure.model;

import com.hidden_treasure_season2.treasure.domain.Treasure;
import lombok.Getter;

@Getter
public class TreasureQRResponse {

    private final Long id;

    private final String image;

    public TreasureQRResponse(final Treasure treasure) {
        this.id = treasure.getId();
        this.image = treasure.getQRImage();
    }
}
