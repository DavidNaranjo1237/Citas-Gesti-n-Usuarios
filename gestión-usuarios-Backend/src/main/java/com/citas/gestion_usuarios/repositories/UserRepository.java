package com.citas.gestion_usuarios.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citas.gestion_usuarios.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

    @SuppressWarnings("null")
    @Override
    Optional<User> findById(String userName);

    boolean existsByUsername(String username);

}
