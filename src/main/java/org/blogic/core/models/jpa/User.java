package org.blogic.core.models.jpa;

import org.blogic.core.models.enums.Role;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4039585268498060419L;

    @Column
    private String username;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @ManyToMany
    private Set<Post> posts;

    @ManyToOne
    @JoinColumn(name = "user_likes", nullable = false)
    private Metric userLikes;

    @ManyToOne
    @JoinColumn(name = "user_dislikes", nullable = false)
    private Metric userDislikes;

    @ManyToOne
    @JoinColumn(name = "user_reactions", nullable = false)
    private Reaction reaction;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(final Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(final Set<Post> posts) {
        this.posts = posts;
    }

    public Metric getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(final Metric userLikes) {
        this.userLikes = userLikes;
    }

    public Metric getUserDislikes() {
        return userDislikes;
    }

    public void setUserDislikes(final Metric userDislikes) {
        this.userDislikes = userDislikes;
    }
}
