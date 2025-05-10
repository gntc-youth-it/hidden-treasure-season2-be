package com.hidden_treasure_season2.treasure.service;

import com.hidden_treasure_season2.common.exception.EntityNotFoundException;
import com.hidden_treasure_season2.common.exception.model.ExceptionCode;
import com.hidden_treasure_season2.treasure.domain.Treasure;
import com.hidden_treasure_season2.treasure.model.TreasureCreationResponse;
import com.hidden_treasure_season2.treasure.model.TreasureQRResponse;
import com.hidden_treasure_season2.treasure.repository.TreasureRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TreasureService {

    private final TreasureRepository treasureRepository;

    @Transactional(readOnly = true)
    public TreasureQRResponse getTreasureQR(Long treasureId) {
        Treasure treasure = treasureRepository.findById(treasureId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.TREASURE_NOT_FOUND));
        return new TreasureQRResponse(treasure);
    }

    @Transactional
    public TreasureCreationResponse createTreasures(Integer treasureCount) {
        List<Treasure> treasures = new ArrayList<>();
        for (int i = 0; i < treasureCount; i++) {
            treasures.add(Treasure.createTreasure());
        }
        treasureRepository.saveAll(treasures);
        return new TreasureCreationResponse();
    }
}
