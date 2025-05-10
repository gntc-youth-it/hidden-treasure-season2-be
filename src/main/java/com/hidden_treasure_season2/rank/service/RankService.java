package com.hidden_treasure_season2.rank.service;

import com.hidden_treasure_season2.rank.model.UserRankResponse;
import com.hidden_treasure_season2.user.domain.User;
import com.hidden_treasure_season2.user.repository.UserRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RankService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserRankResponse> getAllRanks() {
        List<User> allUsers = userRepository.findAll();


        return allUsers.stream()
                .filter(User::hasName)
                .map(user -> new UserRankResponse(
                        user.getId(),
                        user.getName(),
                        user.getScore(),
                        user.getScannedTreasure().size()))
                .sorted(Comparator.comparing(UserRankResponse::getScore).reversed()) // 점수 기준 내림차순
                .collect(Collectors.toList());
    }
}
