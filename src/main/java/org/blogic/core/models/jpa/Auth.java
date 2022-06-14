package org.blogic.core.models.jpa;

import lombok.Getter;
import lombok.Setter;
import org.blogic.core.models.enums.Role;
import org.blogic.core.models.enums.UserType;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Auth extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 313381189475803680L;

    @OneToOne(mappedBy = "auth")
    private User user;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name = "last_logged_in")
    private LocalDateTime lastLoggedIn;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column
    private Integer version;

    @Column(name = "is_active")
    private boolean isActive;
}
