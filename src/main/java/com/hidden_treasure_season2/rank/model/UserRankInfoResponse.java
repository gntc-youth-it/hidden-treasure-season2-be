package com.hidden_treasure_season2.rank.model;

import lombok.Getter;

@Getter
public class UserRankInfoResponse {
    private final Long userId;
    private final String name;
    private final int score;
    private final int treasureCount;
    private final int rank;

    public UserRankInfoResponse(Long userId, String name, int score, int treasureCount, int rank) {
        this.userId = userId;
        this.name = name;
        this.score = score;
        this.treasureCount = treasureCount;
        this.rank = rank;
    }
}
