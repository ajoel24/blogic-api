package com.andrewjoel.blogic.models.jpa;

import com.andrewjoel.blogic.models.enums.Status;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
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

    @OneToOne
    @JoinTable(name = "comment_metric",
            joinColumns =
                    {@JoinColumn(name = "post_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "metric_id", referencedColumnName = "id")})
    private Metric metric;

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(final Metric metric) {
        this.metric = metric;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(final Post post) {
        this.post = post;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Set<Comment> getReplies() {
        return replies;
    }

    public void setReplies(final Set<Comment> replies) {
        this.replies = replies;
    }

    public Metric getMetrics() {
        return metric;
    }

    public void setMetrics(final Metric metric) {
        this.metric = metric;
    }
}
