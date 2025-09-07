package org.arcsoft;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner init(UserService userService) {
        return args -> {
            log.info("Creating users...");
            var userId1 = userService.createUser("Mary Sue").getId();
            var userId2 = userService.createUser("John Doe").getId();

            log.info("All created users: {}", userService.getAllUsers());

            log.info("Updating user with id = {}. Result: {}", userId1, userService.updateUser(userId1, "Marty Sue"));
            log.info("Updating user with id = {}. Result: {}", userId2, userService.updateUser(userId2, "Jane Doe"));

            log.info("Updated user with id = {}: {}", userId1, userService.getUserById(userId1));
            log.info("Updated user with id = {}: {}", userId2, userService.getUserById(userId2));

            log.info("Deleting user with id = {}. Result: {}", userId1, userService.deleteUser(userId1));

            log.info("All users after deletion: {}", userService.getAllUsers());

            log.info("Deleting user with id = {}. Result: {}", userId2, userService.deleteUser(userId2));

            try {
                log.info("Trying to find user with id = {}", userId2);
                userService.getUserById(userId2);
            } catch (Exception e) {
                log.error("Error finding user with id = {}.", userId2, e);
            }

            log.info("All users after last deletion: {}", userService.getAllUsers());
        };
    }
}