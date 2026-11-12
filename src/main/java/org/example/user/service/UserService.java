package org.example.user.service;

import jakarta.transaction.Transactional;
import org.example.user.dto.UserDto;
import org.example.user.model.User;
import org.example.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void save(UserDto userDto){
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User newUser = new User(userDto.getName(),
                userDto.getEmail(),
                encodedPassword,
                userDto.getRole());

        userRepository.save(newUser);
    }
}
