package sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
    public static final String ID = "id";
    public static final String SEQUENCE = "sequence";
    public static final int AUTO_INCREMENT_BY_1 = 1;
    public static final long DEFAULT_ID = 1L;

    private final MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String sequenceId) {
        Query query = new Query(Criteria.where(ID).is(sequenceId));
        Update update = new Update();
        update.inc(SEQUENCE, AUTO_INCREMENT_BY_1);
        Sequence sequence = mongoOperations.findAndModify(
                query,
                update,
                options().returnNew(true).upsert(true),
                Sequence.class
        );

        return Objects.isNull(sequence) ? DEFAULT_ID : sequence.getSequence();
    }
}
