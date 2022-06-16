package com.indien.indien_backend.oauth.service;

import com.indien.indien_backend.controller.response.LoginResponse;
import com.indien.indien_backend.jwt.TokenProvider;
import com.indien.indien_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>
{
    public static final String BEARER_TYPE = "Bearer";
    private final InMemoryClientRegistrationRepository inMemoryRepository;
    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException
    {
        return null;
    }

    public LoginResponse login(String providerName, String code)
    {
        ClientRegistration provider = inMemoryRepository.findByRegistrationId(providerName);
    }
}
