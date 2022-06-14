package org.blogic.core.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UserDto(
        @NotNull(message = "Username is required")
        @NotBlank(message = "Please enter a valid username")
        String username,

        @NotNull(message = "Password is required")
        @NotBlank(message = "Please enter a valid password")
        String password,

        @NotNull(message = "Email is required")
        @NotBlank(message = "Please enter a valid email")
        String email
) {
}
