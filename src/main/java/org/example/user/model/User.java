package org.example.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.user.roles.Role;

@Entity(name="users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 20)
    String name;
    @Column(length = 30)
    String email;
    @Column(length = 60)
    String password;
    @Enumerated(EnumType.STRING)
    Role role;

    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
