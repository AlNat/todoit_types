package dev.alnat.todoit.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Постраничный вывод результатов
 *
 * Created by @author AlNat on 24.01.2022.
 * Licensed by Apache License, Version 2.0
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Постраничный результат поиска")
public class PaginalResult<Request, ResponseElement> implements Serializable {

    @Schema(description = "Запрос поиска")
    @EqualsAndHashCode.Include
    private Request request;

    @Schema(description = "Список элементов", nullable = true)
    @EqualsAndHashCode.Include
    private List<ResponseElement> data;

    @Schema(description = "Кол-во элементов", example = "100")
    private Integer limit;

    @Schema(description = "Номер первого элемента", example = "0")
    private Integer offset;

    @Schema(description = "Есть ли еще элементы", example = "false")
    private Boolean hasMore;

}
