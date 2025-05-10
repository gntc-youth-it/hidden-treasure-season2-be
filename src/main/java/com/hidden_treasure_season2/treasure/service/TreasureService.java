package com.hidden_treasure_season2.treasure.service;

import com.hidden_treasure_season2.common.exception.EntityNotFoundException;
import com.hidden_treasure_season2.common.exception.model.ExceptionCode;
import com.hidden_treasure_season2.qr.domain.QRCode;
import com.hidden_treasure_season2.treasure.domain.Treasure;
import com.hidden_treasure_season2.treasure.model.request.TreasureFindRequest;
import com.hidden_treasure_season2.treasure.model.response.TreasureCreationResponse;
import com.hidden_treasure_season2.treasure.model.response.TreasureFindResponse;
import com.hidden_treasure_season2.treasure.model.response.TreasureQRResponse;
import com.hidden_treasure_season2.treasure.repository.TreasureRepository;
import com.hidden_treasure_season2.user.domain.User;
import com.hidden_treasure_season2.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TreasureService {

    private final TreasureRepository treasureRepository;
    private final UserRepository userRepository;

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

    @Transactional
    public TreasureFindResponse findTreasure(TreasureFindRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.USER_NOT_FOUND));
        Treasure treasure = treasureRepository.findByQrCode(getFoundQRCode(request))
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.TREASURE_NOT_FOUND));
        user.findTreasure(treasure);
        userRepository.save(user);
        return new TreasureFindResponse(user, treasure);
    }

    private QRCode getFoundQRCode(TreasureFindRequest request) {
        return new QRCode(request.getTreasureCode());
    }
}
