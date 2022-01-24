package dev.alnat.todoit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Статус задачи
 *
 * Created by @author AlNat on 23.01.2022.
 * Licensed by Apache License, Version 2.0
 */
@Getter
@AllArgsConstructor
public enum TaskStatus {
    PLANNED(0, "Запланированная задача", false),
    DONE(1, "Задача выполнена", false),
    OVERDUE(2, "Задача просрочена", false),
    CANCELED(3, "Задача отмена", false),
    DELETED(4, "Задача удалена", true),
    ARCHIVED(5, "Задача архивирована", true);

    private final int value;
    private final String message;
    private final boolean isHide; // Внутренний статус

    public static TaskStatus ofValue(int value){
        return Arrays.stream(TaskStatus.values())
                .filter(s -> s.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Неизвестный код статуса!"));
    }

}
