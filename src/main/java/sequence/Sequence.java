package sequence;

import org.springframework.data.annotation.Id;

public class Sequence {
    @Id
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
