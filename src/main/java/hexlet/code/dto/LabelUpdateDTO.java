package hexlet.code.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Set;

@Getter
@Setter
public class LabelUpdateDTO {
    @NotNull
    @Size(min = 3, max = 1000)
    private JsonNullable<String> name;

    private Set<JsonNullable<Long>> taskIds;
}
