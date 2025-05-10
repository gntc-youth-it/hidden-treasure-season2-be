package com.hidden_treasure_season2.user.service;

import com.hidden_treasure_season2.common.exception.EntityNotFoundException;
import com.hidden_treasure_season2.common.exception.model.ExceptionCode;
import com.hidden_treasure_season2.qr.domain.QRCode;
import com.hidden_treasure_season2.user.domain.User;
import com.hidden_treasure_season2.user.model.UserCreationResponse;
import com.hidden_treasure_season2.user.model.UserQRResponse;
import com.hidden_treasure_season2.user.model.UserResponse;
import com.hidden_treasure_season2.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getUser(String userCode) {
        User user = userRepository.findByQrCode(new QRCode(userCode))
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.USER_NOT_FOUND));
        return new UserResponse(user);
    }

    @Transactional(readOnly = true)
    public UserQRResponse getUserQR(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.USER_NOT_FOUND));
        return new UserQRResponse(user);
    }

    @Transactional
    public UserCreationResponse createUsers(Integer userCount) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userCount; i++) {
            users.add(User.createEmptyUser());
        }
        userRepository.saveAll(users);
        return new UserCreationResponse();
    }


}
