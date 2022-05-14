package com.blog.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.entities.Role;
import com.blog.entities.User;
import com.blog.payloads.UserDto;
import com.blog.repositories.RoleRepository;
import com.blog.repositories.UserRepository;
import com.blog.services.UserService;
import com.blog.utils.CommonMethodsUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		
		Set<Role> set = userDto.getRoles().stream().map(role->this.roleRepository.save(role)).collect(Collectors.toSet());
		userDto.setRoles(set);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(CommonMethodsUtils.resourceNotFound("User", "id", userId.toString()));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepository.save(user);
		
		UserDto dto = this.userToDto(updatedUser);
		
		return dto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(CommonMethodsUtils.resourceNotFound("User", "id", userId.toString()));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers = this.userRepository.findAll();
		List<UserDto> userDtos = allUsers.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
			.orElseThrow(CommonMethodsUtils.resourceNotFound("User", "id", userId.toString()));
		this.userRepository.delete(user);
	}
	
	private User dtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		User user = this.modelMapper.map(userDto, User.class);
		
		return user;
	}
	
	private UserDto userToDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return userDto;
	}

}
