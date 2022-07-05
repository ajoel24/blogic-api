package org.blogic.core.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    AUTHOR,
    EDITOR,
    COMMENTER;

    @Override
    public String getAuthority() {
        return toString();
    }
}
