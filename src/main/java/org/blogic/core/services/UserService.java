package org.blogic.core.services;

import org.blogic.core.dto.UserDto;
import org.blogic.core.models.enums.Role;
import org.blogic.core.models.jpa.User;
import org.blogic.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(final UserDto userDto) {
        final var user = new User();
        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        user.setEmail(userDto.email());
        user.setRole(Role.ADMIN);

        return userRepository.save(user);
    }

    public Set<User> getUsers() {
        return userRepository.findAll().stream().collect(Collectors.toUnmodifiableSet());
    }
}
