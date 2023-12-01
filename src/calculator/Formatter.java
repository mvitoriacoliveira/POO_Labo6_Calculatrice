package calculator;

import java.text.DecimalFormat;

/**
 * The {@code Formatter} class provides a utility method to format double results.
 * It uses DecimalFormat to format the double result based on a specified pattern.
 * Adjust the pattern in the {@code DECIMAL_PATTERN} constant as needed.
 */

public class Formatter {
    /**
     * The decimal pattern used for formatting double results.
     * Adjust this pattern as needed.
     */
    private static final String DECIMAL_PATTERN = "#.##########";

    //TODO 10 correct?
    /**
     * Formats a double result using the specified decimal pattern.
     * Up to 10 decimal places will be shown if they are present in the number.
     * If there are fewer decimal places, only the necessary ones will be displayed.
     *
     * @param result The double value to be formatted.
     * @return A formatted string representing the double result.
     */
    public static String format(double result) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        return decimalFormat.format(result);
    }
}