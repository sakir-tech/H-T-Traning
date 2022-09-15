package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Admin;
import com.flightapp.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
	private AdminRepo adminRepo;
    
	public AdminServiceImpl(AdminRepo adminRepo) {
		super();
		this.adminRepo = adminRepo;
	}

	@Override
	public Long saveAdmin(Admin admin) {
		Admin saveAdmin = adminRepo.save(admin);
		return saveAdmin.getId();
	}

}
