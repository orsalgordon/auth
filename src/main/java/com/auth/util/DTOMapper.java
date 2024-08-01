package com.auth.util;

import com.auth.model.Host;
import com.auth.model.dto.HostDto;

public class DTOMapper {
    public static Host map(HostDto hostDto) {
        if (hostDto == null || hostDto.getHostId() < 0) {
            return null;
        }
        Host host = new Host();
        host.setHostId(hostDto.getHostId());
        host.setFirstName(hostDto.getFirstName());
        host.setLastName(hostDto.getLastName());
        host.setEmail(hostDto.getEmail());
        return host;
    }
}
