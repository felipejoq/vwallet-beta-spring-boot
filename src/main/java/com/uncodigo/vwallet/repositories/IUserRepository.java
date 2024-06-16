package com.uncodigo.vwallet.repositories;

import com.uncodigo.vwallet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

        User findByEmailIgnoreCase(String email);
}
