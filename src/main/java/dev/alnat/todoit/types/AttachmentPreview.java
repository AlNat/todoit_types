package dev.alnat.todoit.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO-версия описания вложения (без самого вложения)
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
@Schema(description = "Метаданные по вложению к задаче", required = true)
public class AttachmentPreview implements Serializable {

    @Schema(description = "Идентификатор вложения", required = true, example = "123")
    @JsonProperty(value = "id", required = true)
    private Long id;

    @NotBlank
    @Schema(description = "Имя вложения", required = true, example = "image.png")
    @JsonProperty(value = "name", required = true)
    private String name;

    @NotNull
    @Schema(description = "Размер вложения", required = true, example = "1024")
    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "created", required = true)
    @Schema(description = "Дата создания вложения", required = true, example = "2000-01-01 12:00:00")
    private LocalDateTime created;

}
