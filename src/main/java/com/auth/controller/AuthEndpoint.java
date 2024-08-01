package com.auth.controller;

import com.auth.model.dto.HostDto;
import com.auth.model.dto.LoginRequestDto;
import com.auth.model.dto.LoginResponseDto;
import com.auth.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/rest/v1")
@Tag(name = "Auth")
public class AuthEndpoint {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<HostDto> signupHost(@RequestBody HostDto hostDto){
        return ResponseEntity.ok(authService.signup(hostDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}
