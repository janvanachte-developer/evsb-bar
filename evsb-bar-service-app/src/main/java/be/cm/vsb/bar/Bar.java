package be.cm.vsb.bar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
//import javax.persistence.Id;
import org.springframework.data.annotation.Id;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonDeserialize(builder = Bar.BarBuilder.class)
//@Entity
@Document(collection = "bars")
@RestResource
public class Bar {

    @Id
    String identifier;
    String name;
    BarStatus status;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    public enum BarStatus {
        INITIAL,
        STARTED,
        ENDED,
        ARCHIVED;
    }

    Long parent;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class BarBuilder {
    }
}
