package com.vasylenko;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Calculation of the February day since the beginning of Russian invasion of Ukraine in 2022.
 *
 * <ul>
 * <li>EN: <a href="https://en.wikipedia.org/wiki/Russian_invasion_of_Ukraine">Russian invasion of Ukraine</a>
 * <li>FR: <a href="https://fr.wikipedia.org/wiki/Invasion_de_l%27Ukraine_par_la_Russie_depuis_2022">Invasion de l'Ukraine par la Russie depuis 2022</a>
 * <li>DE: <a href="https://de.wikipedia.org/wiki/Russischer_Überfall_auf_die_Ukraine_2022">Russischer Überfall auf die Ukraine 2022</a>
 * </ul>
 *
 * @author Dmytro Vasylenko
 * @since 1.1
 */
public class Liutyi {

    // The start date of the war
    private static final LocalDate START_WAR_DATE = LocalDate.of(2022, Month.FEBRUARY, 24);

    // Current date, until the war ends
    private static final LocalDate CURRENT_DATE = LocalDate.now();

    // Locale for Ukrainian language
    private static final Locale UKRAINIAN_LOCALE = new Locale("uk");

    /**
     * Main method to execute the program.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        long daysDiff = calculateDaysDifference();
        String formattedDate = formatDate();
        printResult(START_WAR_DATE.getDayOfMonth(), daysDiff, formattedDate);
    }

    /**
     * Calculates the number of days between the start date of the war and the current date.
     *
     * @return The number of days between START_WAR_DATE and CURRENT_DATE
     */
    private static long calculateDaysDifference() {
        return ChronoUnit.DAYS.between(START_WAR_DATE, CURRENT_DATE);
    }

    /**
     * Formats the start date of the war in a localized long date format.
     *
     * @return The formatted start date as a String
     */
    private static String formatDate() {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Liutyi.UKRAINIAN_LOCALE)
                .format(Liutyi.START_WAR_DATE);
    }

    /**
     * Prints the result in the format "dayOfMonth + daysDiff + formattedDate".
     *
     * @param dayOfMonth The day of the month of the start date
     * @param daysDiff The number of days since the start date
     * @param formattedDate The formatted start date
     */
    private static void printResult(int dayOfMonth, long daysDiff, String formattedDate) {
        System.out.println(dayOfMonth + daysDiff + formattedDate.substring(2));
    }
}
