package org.arcsoft.controller;

import lombok.RequiredArgsConstructor;
import org.arcsoft.dto.users.CreateUserRequest;
import org.arcsoft.dto.users.UserDto;
import org.arcsoft.dto.users.UserShortDto;
import org.arcsoft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.isTrue;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<? extends UserShortDto> getUsers(
            @RequestParam(name = "withProducts", defaultValue = "false", required = false) Boolean withProducts) {

        if (isTrue(withProducts)) {
            return userService.getAllUsers();
        } else
            return userService.getAllUsersShort();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<? extends UserShortDto> getById(@PathVariable Long userId,
                                                          @RequestParam(name = "withProducts", defaultValue = "false", required = false) Boolean withProducts) {
        if (isTrue(withProducts))
            return ResponseEntity.ok(userService.getUserById(userId));
        else
            return ResponseEntity.ok(userService.getUserByIdShort(userId));
    }

    @PostMapping
    public UserShortDto create(@RequestBody CreateUserRequest userName) {
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
