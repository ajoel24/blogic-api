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
public class Comment extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 8078708065184612044L;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    @JoinTable(name = "comment_replies")
    private Set<Comment> replies;
}
