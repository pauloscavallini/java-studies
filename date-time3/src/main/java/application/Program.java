package application;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

//        for (String s : ZoneId.getAvailableZoneIds()) {
//            System.out.println(s);
//        }

        // conversões de data global para local
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));

        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault()); // UTC -3
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal")); // UTC +1 PORTUGAL

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mes = " + d04.getMonthValue());
        System.out.println("d04 ano = " + d04.getYear());

        System.out.println("d05 hora = " + d05.getHour());
        System.out.println("d05 minuto = " + d05.getMinute());

        // CÁLCULOS COM DATA-HORA

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

        // ao operar com Instants, não há metodos como .minusDays() ou .plusDays()
        // por isso se deve usar .minus(unidade, ChronoUnit.[grandeza ou unidade]) ou .plus, fora outros metodos
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        // e necessario converter LocalDate para LocalDateTime
        // Duration t1 = Duration.between(pastWeekLocalDate.atTime(0,0), d04.atTime(0,0)); <- outra opção
        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay()); // 7
        Duration t2 = Duration.between(pastWeekLocalDateTime, d05); // 7

        Duration t3 = Duration.between(pastWeekInstant, d06); // comparando Temporals do tipo Instant -> saida: 7
        Duration t4 = Duration.between(d06, pastWeekInstant); // retorna o tempo negativo caso o primeiro item seja mais recente
        // -7

        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());

    }
}