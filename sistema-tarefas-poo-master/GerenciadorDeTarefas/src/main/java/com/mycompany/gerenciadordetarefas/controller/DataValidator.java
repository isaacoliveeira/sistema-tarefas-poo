package com.mycompany.gerenciadordetarefas.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataValidator {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String validarData(String data) throws DataInvalidaException {
        try {
            LocalDate date = LocalDate.parse(data, DATE_FORMATTER);

            if (date.isBefore(LocalDate.now())) {
                throw new DataInvalidaException("A data não pode ser anterior à data atual.");
            }

            return DATE_FORMATTER.format(date);
        } catch (DateTimeParseException e) {
            throw new DataInvalidaException("Formato de data inválido. Por favor, insira uma data válida, exemplo: dd/mm/aa.");
        }
    }
} 
