package com.argos.argos.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class HistoricoTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "idTag", referencedColumnName = "id")
    private Tag tag;

    public HistoricoTag() {}

    public HistoricoTag(Tag tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
