package com.helloworld.HW.front.member.repositories;

import com.helloworld.HW.front.member.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
