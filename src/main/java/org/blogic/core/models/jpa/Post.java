package org.blogic.core.models.jpa;

import lombok.Getter;
import lombok.Setter;
import org.blogic.core.models.enums.Status;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Post extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -3954025379860406935L;

    @Column
    private String title;

    @Column(unique = true)
    private String slug;

    @Column
    private String excerpt;

    @Column
    private String body;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    private Set<User> authors;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
}
