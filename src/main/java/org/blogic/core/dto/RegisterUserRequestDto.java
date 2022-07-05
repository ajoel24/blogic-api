package org.blogic.core.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record RegisterUserRequestDto(
        @NotBlank(message = "Please enter a valid username")
        String username,

        @NotBlank(message = "Please enter a valid password")
        String password,

        @Email(message = "Please enter a valid email")
        String email
) {
    @Override
    public String toString() {
        return "RegisterUserRequestDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
