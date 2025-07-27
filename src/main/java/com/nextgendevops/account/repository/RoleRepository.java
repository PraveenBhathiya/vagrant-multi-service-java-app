package com.nextgendevops.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextgendevops.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
