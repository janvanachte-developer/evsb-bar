package be.cm.vsb.bar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Immutable;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

//import javax.persistence.Id;

@Getter
@Builder
@Immutable
@JsonDeserialize(builder = Bar.BarBuilder.class)
@Entity
public class Bar {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2") // uuid2 to use IETF RFC 4122 compliant UUID values
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
