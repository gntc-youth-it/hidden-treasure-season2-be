package com.hidden_treasure_season2.rank.model;

import lombok.Getter;

@Getter
public class UserRankResponse {
    private final Long id;
    private final String name;
    private final int score;
    private final int treasureCount;

    public UserRankResponse(Long id, String name, int score, int treasureCount) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.treasureCount = treasureCount;
    }
}
