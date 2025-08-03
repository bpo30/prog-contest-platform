package ru.itmo.wp.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Notice {
    public static final int MIN_CONTENT_SIZE = 1;
    public static final int MAX_CONTENT_SIZE = 1000;

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @NotBlank
    @Size(min = MIN_CONTENT_SIZE, max = MAX_CONTENT_SIZE)
    private String content;

    @CreationTimestamp
    private Date creationTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
