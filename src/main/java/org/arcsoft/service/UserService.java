package org.arcsoft.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arcsoft.domain.UserMapper;
import org.arcsoft.domain.dto.UserDto;
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

    public UserDto createUser(String username) {
        return mapper.toDto(repository.save(new User(username)));
    }

    public UserDto getUserById(Long id) {
        return mapper.toDto(getUser(id));
    }

    public List<UserDto> getAllUsers() {
        return mapper.toDto(repository.findAll());
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
