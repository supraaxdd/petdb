package com.supra.petdb.repositories;

import com.supra.petdb.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
