package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flightapp.entity.Admin;
import com.flightapp.entity.AuthRequest;
import com.flightapp.entity.JwtResponse;
import com.flightapp.entity.Response;
import com.flightapp.service.AdminService;
import com.flightapp.service.CustomUserDetailsService;
import com.flightapp.util.JwtUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@GetMapping("/")
	public Response test() {
		return new Response("Welcome to Admin Service");
	}

	@PostMapping("/register")
	public Long createAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invaid username or Password");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());
		String token = jwtUtil.generateToken(userDetails);
		// converting token to json
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
