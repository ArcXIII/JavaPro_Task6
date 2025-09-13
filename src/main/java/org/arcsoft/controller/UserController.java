package org.arcsoft.controller;

import lombok.RequiredArgsConstructor;
import org.arcsoft.domain.dto.UserDto;
import org.arcsoft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public UserDto create(@RequestParam("userName") String userName) {
        return userService.createUser(userName);
    }

    @PutMapping("/{userId}")
    public UserDto update(@PathVariable Long userId, @RequestParam("userName") String userName) {
        return userService.updateUser(userId, userName);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> update(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
