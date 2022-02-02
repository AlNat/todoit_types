package dev.alnat.todoit.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.alnat.todoit.common.PaginalResult;
import dev.alnat.todoit.types.TaskDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * DTO представляющее результат поиска
 *
 * Created by @author AlNat on 23.01.2022.
 * Licensed by Apache License, Version 2.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Результат поиска по задачам")
public class TaskSearchResponse extends PaginalResult<TaskSearchRequest, TaskDTO> implements Serializable {

}
