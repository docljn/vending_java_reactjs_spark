import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyDisplay {



    public static String formatDollars(Integer amountInCents) {
        BigDecimal amount = BigDecimal.valueOf(amountInCents).divide(BigDecimal.valueOf(100));
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String dollars = nf.format(amount);

        return dollars;
    }

}


