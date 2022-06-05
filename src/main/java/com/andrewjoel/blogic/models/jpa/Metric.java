package com.andrewjoel.blogic.models.jpa;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Metric extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -139586105925254408L;

    @OneToMany(mappedBy = "userLikes")
    private Set<User> likes;

    @OneToMany(mappedBy = "userDislikes")
    private Set<User> dislikes;

    @OneToMany(mappedBy = "metric")
    private Set<Reaction> reactions;

    @OneToOne(mappedBy = "metric")
    private Comment comment;

    @OneToOne(mappedBy = "metric")
    private Post post;

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(final Set<User> likes) {
        this.likes = likes;
    }

    public Set<User> getDislikes() {
        return dislikes;
    }

    public void setDislikes(final Set<User> dislikes) {
        this.dislikes = dislikes;
    }

    public Set<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(final Set<Reaction> reactions) {
        this.reactions = reactions;
    }
}
