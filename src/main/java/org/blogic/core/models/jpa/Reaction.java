package org.blogic.core.models.jpa;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Reaction extends AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 7463982995289833064L;

    @Column
    private String emoji;

    @OneToMany(mappedBy = "reaction")
    private Set<User> user;

    @ManyToOne
    @JoinColumn(name = "reaction_metric", nullable = false)
    private Metric metric;

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(final String emoji) {
        this.emoji = emoji;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(final Set<User> user) {
        this.user = user;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(final Metric metric) {
        this.metric = metric;
    }
}
