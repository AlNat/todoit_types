package dev.alnat.todoit.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Список сортировок в фильтре
 *
 * Created by @author AlNat on 23.01.2022.
 * Licensed by Apache License, Version 2.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sorting implements Serializable {

    @Schema(description = "Поле сортировки")
    private String sortBy;

    @Schema(description = "Тип сортировки")
    private SortOrder sortOrder;

    /**
     * Тип сортировки
     */
    public enum SortOrder {
        ASC, DESC;
    }

}

