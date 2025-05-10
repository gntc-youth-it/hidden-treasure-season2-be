package com.hidden_treasure_season2.user.controller;

import com.hidden_treasure_season2.user.model.request.UserNamingRequest;
import com.hidden_treasure_season2.user.model.response.UserCreationResponse;
import com.hidden_treasure_season2.user.model.response.UserNamingResponse;
import com.hidden_treasure_season2.user.model.response.UserQRResponse;
import com.hidden_treasure_season2.user.model.response.UserResponse;
import com.hidden_treasure_season2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@RequestParam String userCode) {
        return ResponseEntity.ok(userService.getUser(userCode));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserQRResponse> getUserQR(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserQR(userId));
    }

    @PostMapping
    public ResponseEntity<UserCreationResponse> createUsers(@RequestParam Integer userCount) {
        return ResponseEntity.ok(userService.createUsers(userCount));
    }

    @PostMapping("/name")
    public ResponseEntity<UserNamingResponse> nameUser(@RequestBody UserNamingRequest request) {
        return ResponseEntity.ok(userService.nameUser(request));
    }

}
