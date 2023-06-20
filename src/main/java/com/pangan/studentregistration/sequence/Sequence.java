package com.pangan.studentregistration.sequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class Sequence {
    @MongoId
    private String id;
    private Long sequence;

    public Sequence(String id, Long sequence) {
        this.id = id;
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
}
