package Java.calculator.format;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * The Formatter class provides methods for formatting numerical values.
 * It includes functionality for formatting double values, ensuring a specific decimal pattern.
 * Additionally, it supports formatting values with one decimal place and checks whether a given string is numeric.
 *
 * @author Vitoria Oliveira
 * @since 05.12.23
 */
public class Formatter {
    /* The default decimal pattern for formatting double values. */
    private static final String DECIMAL_PATTERN = "#.##########";

    /**
     * Formats a double value using the default decimal pattern.
     * @param result The double value to be formatted.
     * @return A formatted string representation of the double value.
     */
    public static String format(double result) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN, DecimalFormatSymbols.getInstance(Locale.US));
        return decimalFormat.format(result);
    }

    /**
     * Formats a string representing a numeric value with one decimal place.
     * If the input is not a numeric value, it is returned unchanged.
     * @param input The string representing the numeric value.
     * @return A formatted string with one decimal place, or the original input if it is not numeric.
     */
    public static String formatOneDecimal(String input) {
            if ( isNumeric(input) && !(input.contains(".")) && !(input.contains(","))) {
                double value = Double.parseDouble(input);
                DecimalFormat decimalFormat = new DecimalFormat("#.0", DecimalFormatSymbols.getInstance(Locale.US));
                return decimalFormat.format(value);
            } else {
                input = input.replace(',', '.');
                return input;
            }
    }

    /**
     * Checks if a given string is numeric.
     * @param str The string to be checked.
     * @return true if the string is numeric, false otherwise.
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}