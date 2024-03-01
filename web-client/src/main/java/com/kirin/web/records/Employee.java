package com.kirin.web.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Запись для хранения данных о сотруднике
 * @param id уникальный идентификатор сотрудника
 * @param firstName имя сотрудника
 * @param lastName фамилия сотрудника
 * @param middleName отчество сотрудника
 * @param phoneNumber телефон для связи с сотрудником
 * @param email электронная почта для связи с сотрудником
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Employee(
        Integer id,
        String firstName,
        String lastName,
        String middleName,
        String phoneNumber,
        String email) {
}
