package com.helloworld.HW.admin.config.repository;

import com.helloworld.HW.admin.config.entity.Configs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Configs, String> {

}
