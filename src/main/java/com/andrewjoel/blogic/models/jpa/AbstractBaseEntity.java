package com.andrewjoel.blogic.models.jpa;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -2313432625968445331L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @CreatedBy
    private User createdBy;

    @LastModifiedBy
    private User lastModifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(final LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(final User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
