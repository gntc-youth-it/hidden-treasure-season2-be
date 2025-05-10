package com.hidden_treasure_season2.rank.service;

import static com.hidden_treasure_season2.common.exception.model.ExceptionCode.USER_NOT_FOUND;

import com.hidden_treasure_season2.common.exception.EntityNotFoundException;
import com.hidden_treasure_season2.rank.model.UserRankInfoResponse;
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

    @Transactional(readOnly = true)
    public UserRankInfoResponse getUserRank(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));

        int userScore = user.getScore();
        int treasureCount = user.getScannedTreasure().size();

        List<User> allUsers = userRepository.findAll();

        long rank = allUsers.stream()
                .filter(u -> u.getName() != null && !u.getName().isEmpty())
                .filter(u -> u.getScore() > userScore)
                .count() + 1;

        return new UserRankInfoResponse(
                userId,
                user.getName(),
                userScore,
                treasureCount,
                (int) rank
        );
    }
}
