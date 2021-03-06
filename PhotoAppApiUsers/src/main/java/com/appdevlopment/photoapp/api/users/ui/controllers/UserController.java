package com.appdevlopment.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdevlopment.photoapp.api.users.service.UserService;
import com.appdevlopment.photoapp.api.users.shared.UserDto;

import com.appdevlopment.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appdevlopment.photoapp.api.users.ui.model.CreateUserResponseModel;
import com.google.common.net.MediaType;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/status/check")
	public String status()
	{
		return "Working on a port no : " + env.getProperty("local.server.port");
	}
	
	@PostMapping
		public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails)
	{
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDto userDto=modelMapper.map(userDetails, UserDto.class);
	    UserDto createUser=userService.createUser(userDto);
		
		CreateUserResponseModel returnValue=modelMapper.map(createUser, CreateUserResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
}
