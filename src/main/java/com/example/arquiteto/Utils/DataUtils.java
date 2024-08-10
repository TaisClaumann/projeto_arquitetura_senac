package com.example.arquiteto.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static String localDateToString(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
