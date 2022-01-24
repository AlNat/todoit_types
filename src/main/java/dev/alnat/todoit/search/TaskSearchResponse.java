package dev.alnat.todoit.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.alnat.todoit.common.PaginalResult;
import dev.alnat.todoit.types.TaskDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    @Schema(description = "Список задач, найдены по поиску")
    @Override
    public void setData(List<TaskDTO> data) {
        // Для перекрытия описания Swagger
        super.setData(data);
    }

    @Schema(description = "Запрос на поиск задач")
    @Override
    public void setRequest(TaskSearchRequest taskSearchRequest) {
        // Для перекрытия описания Swagger
        super.setRequest(taskSearchRequest);
    }

    @Schema(description = "Запрос на поиск задач")
    @Override
    public TaskSearchRequest getRequest() {
        // Для перекрытия описания Swagger
        return super.getRequest();
    }

    @Schema(description = "Список задач, найдены по поиску")
    @Override
    public List<TaskDTO> getData() {
        // Для перекрытия описания Swagger
        return super.getData();
    }

}
