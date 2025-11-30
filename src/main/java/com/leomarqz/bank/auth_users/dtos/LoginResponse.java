package com.leomarqz.bank.auth_users.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;
    private String roles;
}
