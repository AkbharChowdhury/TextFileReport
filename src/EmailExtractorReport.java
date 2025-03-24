import java.util.regex.Pattern;
import java.util.function.Supplier;

public class EmailExtractorReport extends  ExtractorReport{
    @Override
    public Pattern getPattern() {
        return  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    }
    @Override
    public String clean(String data) {
        return data.toLowerCase();
    }


    public static Supplier<String> title = () ->"r";


    @Override
    public String getReportName() {
        return "Email report";
    }
}
