package org.incois.backend.config;

import org.incois.backend.repository.UserRepository;
import org.incois.backend.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class TestUserInitializer {

    @Bean
    public CommandLineRunner initTestUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Define the test user credentials
            final String TEST_USERNAME = "testuser";
            final String TEST_PASSWORD = "password123";

            // Encode the password that we want to save
            String encodedPassword = passwordEncoder.encode(TEST_PASSWORD);

            // 1. Try to find the user
            Optional<User> existingUserOpt = userRepository.findByUsername(TEST_USERNAME);

            User user;
            if (existingUserOpt.isEmpty()) {
                // If user doesn't exist, create a new User object
                user = new User();
                user.setUsername(TEST_USERNAME);
                System.out.println(">>> Creating new test user: " + TEST_USERNAME);
            } else {
                // If user exists, use the existing object
                user = existingUserOpt.get();
                System.out.println(">>> Updating password for existing user: " + TEST_USERNAME);
            }

            // 2. Set the guaranteed encoded password and save
            user.setPassword(encodedPassword);
            userRepository.save(user);

            System.out.println(">>> Test user 'testuser' is ready for login with password 'password123'.");
        };
    }
}