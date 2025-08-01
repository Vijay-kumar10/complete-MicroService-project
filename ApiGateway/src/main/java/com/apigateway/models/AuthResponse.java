package com.apigateway.models;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponse {

    private String userId;

    private String accessToken;

    private String refreshToken;

    private long expiresAt;

    private Collection<String> authorities;


}
