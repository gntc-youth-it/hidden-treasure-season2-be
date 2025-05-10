package com.hidden_treasure_season2.rank.controller;

import com.hidden_treasure_season2.rank.model.UserRankResponse;
import com.hidden_treasure_season2.rank.service.RankService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;

    @GetMapping
    public ResponseEntity<List<UserRankResponse>> getAllRanks() {
        return ResponseEntity.ok(rankService.getAllRanks());
    }
}
