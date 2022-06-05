package com.andrewjoel.blogic.models.jpa;

import com.andrewjoel.blogic.models.enums.Status;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
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

    @OneToOne
    @JoinTable(name = "post_metric",
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

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(final String slug) {
        this.slug = slug;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(final String excerpt) {
        this.excerpt = excerpt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Set<User> getAuthors() {
        return authors;
    }

    public void setAuthors(final Set<User> authors) {
        this.authors = authors;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(final Set<Comment> comments) {
        this.comments = comments;
    }

    public Metric getMetrics() {
        return metric;
    }

    public void setMetrics(final Metric metric) {
        this.metric = metric;
    }
}
