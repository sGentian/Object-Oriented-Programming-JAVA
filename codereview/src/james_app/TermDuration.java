package james_app;

import java.time.LocalDate;

public enum TermDuration {
    MONTH,
    HALF_YEAR,
    YEAR;
    public static LocalDate getDateAfterDuration(TermDuration termDuration) {
        LocalDate today = LocalDate.now();

        switch (termDuration) {
            case MONTH:
                return today.plusMonths(1);
            case HALF_YEAR:
                return today.plusMonths(6);
            case YEAR:
                return today.plusYears(1);
            default:
                return today;
        }
    }

}

