package com.auth.model.dto;

import com.auth.model.Host;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HostDto {
    private int hostId;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String password;

    public static HostDto of(Host host) {
        return HostDto.builder()
                .hostId(host.getHostId())
                .firstName(host.getFirstName())
                .lastName(host.getLastName())
                .email(host.getEmail())
                .dateOfBirth(host.getDateOfBirth())
                .password(host.getPassword())
                .build();
    }
}
