package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        // instanciação

        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // datas locais
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        LocalDate d04 = LocalDate.parse("2025-02-13"); // transforma String em LocalDate
        LocalDateTime d05 = LocalDateTime.parse("2025-02-13T01:30:26"); // transforma com horas e minutos

        // datas globais (londres) - mostra Z no final do timestamp
        Instant d03 = Instant.now();
        Instant d06 = Instant.parse("2025-02-13T01:30:26Z");

        // passando o timezone -3 (brasilia) para UTC 0
        Instant d07 = Instant.parse("2025-02-13T01:30:26-03:00");

        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);

        LocalDate d10 = LocalDate.of(2025, 2, 13);
        LocalDateTime d11 = LocalDateTime.of(2025, 2, 13, 1, 30);

        // quando concatenando .toString() é chamado para exibir a data, transformando em ISO 8601
        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07);
        System.out.println("d08 = " + d08);
        System.out.println("d09 = " + d09);
        System.out.println("d10 = " + d10);
        System.out.println("d11 = " + d11);

    }
}