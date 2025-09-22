package org.arcsoft.domain;

import org.arcsoft.domain.dto.UserDto;
import org.arcsoft.domain.dto.UserShortDto;
import org.arcsoft.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {
    UserDto toDto(User userDto);

    List<UserDto> toDto(List<User> users);

    UserShortDto toDtoShort(User userDto);

    List<UserShortDto> toDtoShort(List<User> users);
}
