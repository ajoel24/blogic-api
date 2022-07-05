package org.blogic.core.services;

import org.blogic.core.dto.RegisterUserRequestDto;
import org.blogic.core.exceptions.BlogicException;
import org.blogic.core.models.enums.ApiResponseType;
import org.blogic.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public Response registerUser(final RegisterUserRequestDto dto) {
        final var existingUser = userRepository.findByUsername(dto.username());

        if (existingUser.isPresent()) {
            throw new BlogicException(ApiResponseType.USER_ALREADY_EXISTS);
        }

        return Response.ok().build();
    }
}
