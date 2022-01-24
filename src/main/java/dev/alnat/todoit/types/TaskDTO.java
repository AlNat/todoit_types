package dev.alnat.todoit.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import dev.alnat.todoit.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO-версия описания задачи
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
public class TaskDTO implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Дата создания задачи", required = true, example = "2000-01-01 12:00:00")
    private LocalDateTime created;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Дата обновления", required = true, example = "2000-01-01 13:00:00")
    private LocalDateTime updated;

    @NotNull
    @EqualsAndHashCode.Include
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "planned", required = true)
    @Schema(description = "Планируемая дата задачи", required = true, example = "2000-01-02 12:00:00")
    private LocalDateTime planned;

    @EqualsAndHashCode.Include
    @NotNull
    @Schema(description = "Заголовок задачи", required = true, example = "Тестовая задачи")
    private String title;

    @Schema(description = "Текст задачи", example = "Тестовое описание задачи")
    private String description;

    @NotNull
    @Schema(description = "Статус задачи", example = "PLANNED")
    private TaskStatus status;

    @Schema(description = "Цвет задачи", example = "#FF0000")
    private String color;

}
