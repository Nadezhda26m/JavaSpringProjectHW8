package com.kirin.web.models;

public record Employee(
        Integer id,
        String firstName,
        String lastName,
        String middleName,
        String phoneNumber,
        String email) {
}
