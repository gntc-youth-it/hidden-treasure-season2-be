package com.hidden_treasure_season2.treasure.controller;

import com.hidden_treasure_season2.treasure.model.TreasureCreationResponse;
import com.hidden_treasure_season2.treasure.model.TreasureQRResponse;
import com.hidden_treasure_season2.treasure.service.TreasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/treasure")
public class TreasureController {

    private final TreasureService treasureService;

    @GetMapping("/{treasureId}")
    public ResponseEntity<TreasureQRResponse> getTreasureQR(@PathVariable Long treasureId) {
        return ResponseEntity.ok(treasureService.getTreasureQR(treasureId));
    }

    @PostMapping
    public ResponseEntity<TreasureCreationResponse> createTreasures(@RequestParam Integer treasureCount) {
        return ResponseEntity.ok(treasureService.createTreasures(treasureCount));
    }
}
