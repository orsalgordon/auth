package com.auth.repository;

import com.auth.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {

    Host findByEmail(String email);
}
