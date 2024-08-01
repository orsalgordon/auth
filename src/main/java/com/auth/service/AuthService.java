package com.auth.service;

import com.auth.exception.InternalServerException;
import com.auth.model.Host;
import com.auth.model.dto.HostDto;
import com.auth.model.dto.LoginRequestDto;
import com.auth.model.dto.LoginResponseDto;
import com.auth.repository.HostRepository;
import com.auth.util.DTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private HostRepository hostRepository;
    private PasswordEncoder passwordEncoder;

    public HostDto signup(HostDto hostDto) {
        String email = hostDto.getEmail();
        Host existingHost = hostRepository.findByEmail(email);
        if (existingHost != null) {
            throw new InternalServerException("Email already exists");
        }

        Host host = DTOMapper.map(hostDto);
        host.setPassword(passwordEncoder.encode(hostDto.getPassword()));
        Host response = hostRepository.save(host);
        return Optional.of(response)
                .map(HostDto::of)
                .orElseThrow(() -> new InternalServerException("There's an error creating the host"));
    }

    public LoginResponseDto login(LoginRequestDto request) {
        String email = request.getEmail();
        String password = request.getPassword();

        try {
            Host host = hostRepository.findByEmail(email);
            if (host != null) {
                boolean isSame = passwordEncoder.matches(password, host.getPassword());
                if (isSame) {
                    return LoginResponseDto.builder()
                            .message(String.valueOf(host.getHostId()))
                            .status(true)
                            .build();
                }
            }
            return LoginResponseDto.builder()
                    .message("Invalid email or password")
                    .status(false)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
