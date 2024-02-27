package com.kirin.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Employee(
        Integer id,
        String firstName,
        String lastName,
        String middleName,
        String phoneNumber,
        String email) {
}
