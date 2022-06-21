package com.indien.indien_backend.controller;

import com.indien.indien_backend.controller.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OauthController
{
    @GetMapping("/login/{provider}")
    public ResponseEntity<LoginResponse> loginProvider(@PathVariable String provider, @RequestParam String code){
        System.out.println(code);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCode(code);
        return ResponseEntity.ok(loginResponse);
    }
}
