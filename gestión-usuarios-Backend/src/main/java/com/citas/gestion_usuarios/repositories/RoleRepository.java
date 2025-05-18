package com.citas.gestion_usuarios.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citas.gestion_usuarios.entities.Role;
import com.citas.gestion_usuarios.enums.RoleList;

@Repository

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleList roleUser);

}
