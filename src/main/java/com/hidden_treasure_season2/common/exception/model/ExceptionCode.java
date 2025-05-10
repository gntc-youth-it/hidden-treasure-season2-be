package com.hidden_treasure_season2.common.exception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {
    INVALID_REQUEST(1000, "올바르지 않은 요청입니다."),
    NOT_FOUND(1001, "요청된 내용을 찾을 수 없습니다"),

    USER_NOT_FOUND(2001, "해당 사용자를 찾을 수 없습니다."),

    TREASURE_NOT_FOUND(7001, "해당 보물을 찾을 수 없습니다."),
    TREASURE_ALREADY_FOUND(7101, "이미 발견한 보물 입니다."),

    TEAM_NOT_FOUND(8001, "해당 팀을 찾을 수 없습니다."),

    INTERNAL_SERVER_ERROR(9999, "서버 에러가 발생했습니다.");

    private final int code;
    private final String message;
}
