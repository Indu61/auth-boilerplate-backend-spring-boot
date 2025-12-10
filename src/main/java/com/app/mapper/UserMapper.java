package com.app.mapper;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.dtos.UserDTO;
import com.app.entities.User;

@Component
public class UserMapper {
	
	public User dtoToEntity(UserDTO dto) {
		if (dto == null)
			return null;

		return User.builder().userId(dto.getUserId()).firstName(dto.getFirstName()).lastName(dto.getLastName())
				.email(dto.getEmail()).phoneNumber(dto.getPhoneNumber()).passwordHash(dto.getPasswordHash())
				.role(dto.getRole()).createdAt(dto.getCreatedAt())
				.isLoggedIn(dto.isLoggedIn()).build();

	}
	
	public UserDTO entityToDto(User entity) {
		if (entity == null)
			return null;

		return UserDTO.builder().userId(entity.getUserId()).firstName(entity.getFirstName())
				.lastName(entity.getLastName()).passwordHash(entity.getPasswordHash()).email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber()).role(entity.getRole()).createdAt(entity.getCreatedAt())
				.build();
	}

	public List<UserDTO> entitiesToDtos(List<User> entities) {
		if (entities == null)
			return Collections.emptyList();

		return entities.stream().map(this::entityToDto).toList();
	}

}
