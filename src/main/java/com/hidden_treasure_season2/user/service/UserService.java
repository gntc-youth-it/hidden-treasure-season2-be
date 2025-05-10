package com.hidden_treasure_season2.user.service;

import com.hidden_treasure_season2.common.exception.EntityNotFoundException;
import com.hidden_treasure_season2.common.exception.model.ExceptionCode;
import com.hidden_treasure_season2.user.domain.User;
import com.hidden_treasure_season2.user.model.UserQRResponse;
import com.hidden_treasure_season2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserQRResponse getUserQR(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.USER_NOT_FOUND));
        return new UserQRResponse(user);
    }

}
