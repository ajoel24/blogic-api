package org.blogic.core.models.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4039585268498060419L;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "auth_id", referencedColumnName = "id")
    private Auth auth;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @ManyToMany
    private Set<Post> posts;
}
