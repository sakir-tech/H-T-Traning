package com.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long> {

	Admin findByUserName(String username);

}
