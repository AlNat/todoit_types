package dev.alnat.todoit.search;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import dev.alnat.todoit.common.Sorting;
import dev.alnat.todoit.enums.TaskStatus;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static dev.alnat.todoit.constants.DateFormats.DATE_TIME_PATTERN;

/**
 * DTO для формы поиска
 *
 * Created by @author AlNat on 23.01.2022.
 * Licensed by Apache License, Version 2.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskSearchRequest implements Serializable {

    @EqualsAndHashCode.Include
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    @Schema(description = "Запланированная дата выполнения c", example = "2000-01-01 12:00:00")
    private LocalDateTime plannedFrom;

    @EqualsAndHashCode.Include
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    @Schema(description = "Запланированная дата выполнения по", example = "2000-01-01 13:00:00")
    private LocalDateTime plannedTo;

    @EqualsAndHashCode.Include
    @Schema(description = "Список статусов")
    private List<TaskStatus> statusList;

    @Size(max = 5)
    @Schema(description = "Сортировка", maxLength = 5)
    @Parameter(array = @ArraySchema(schema = @Schema(implementation = Sorting.class)))
    private List<Sorting> sorting;

    @NotNull
    @Min(1) @Max(100)
    @Schema(description = "Кол-во элементов", example = "100", minimum = "1", maximum = "100")
    private Integer limit = 100;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Номер первого элемента", example = "0", minimum = "0")
    private Integer offset = 0;

}
