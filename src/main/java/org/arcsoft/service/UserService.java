package org.arcsoft.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arcsoft.domain.UserMapper;
import org.arcsoft.domain.dto.CreateUserRequest;
import org.arcsoft.domain.dto.UserDto;
import org.arcsoft.domain.dto.UserShortDto;
import org.arcsoft.domain.entity.User;
import org.arcsoft.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserShortDto createUser(CreateUserRequest request) {
        return mapper.toDtoShort(repository.save(new User(request.userName())));
    }

    public UserDto getUserById(Long id) {
        return mapper.toDto(getUser(id));
    }

    public UserShortDto getUserByIdShort(final Long id) {
        return mapper.toDtoShort(getUser(id));
    }

    public List<UserDto> getAllUsers() {
        return mapper.toDto(repository.findAll());
    }

    public List<UserShortDto> getAllUsersShort() {
        return mapper.toDtoShort(repository.findAll());
    }


    public UserDto updateUser(Long id, String newUsername) {
        var user = getUser(id);

        user.setUsername(newUsername);
        return mapper.toDto(repository.save(user));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
    private User getUser(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with ID=[%s] not found", id)));
    }
}
