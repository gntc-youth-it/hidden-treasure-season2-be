package com.hidden_treasure_season2.user.controller;

import com.hidden_treasure_season2.user.model.UserQRResponse;
import com.hidden_treasure_season2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserQRResponse> getUserQR(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserQR(userId));
    }

}
