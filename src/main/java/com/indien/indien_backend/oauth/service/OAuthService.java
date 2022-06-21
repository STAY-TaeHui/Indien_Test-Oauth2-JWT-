package com.indien.indien_backend.oauth.service;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import com.indien.indien_backend.controller.response.LoginResponse;
import com.indien.indien_backend.jwt.TokenProvider;
import com.indien.indien_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

    @Transactional
    public LoginResponse login(String providerName, String code)
    {
        ClientRegistration provider = inMemoryRepository.findByRegistrationId(providerName);
        OAuth2AccessTokenResponse tokenResponse = getToken(code,provider);
//        getUserProfile(providerName,tokenResponse,provider);
        return null;
    }
    private OAuth2AccessTokenResponse getToken(String code, ClientRegistration provider){
        return WebClient.create()
            .post()
            .uri(provider.getProviderDetails().getTokenUri())
            .headers(header -> {
                header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                header.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
            })
            .bodyValue(tokenRequest(code,provider))
            .retrieve()
            .bodyToMono(OAuth2AccessTokenResponse.class)
            .block();
    }
    private MultiValueMap<String,String> tokenRequest(String code, ClientRegistration provider){
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("code",code);
        formData.add("grant_type", "authorization_code");
        formData.add("redirect_uri",provider.getRedirectUri());
        formData.add("client_secret",provider.getClientSecret());
        formData.add("client_id",provider.getClientId());
        return formData;
    }
}
