package org.example.user.dto;

import lombok.Data;
import org.example.user.roles.Role;

@Data
public class UserDto {
    String name;
    String email;
    String password;
    Role role;

    public UserDto(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
