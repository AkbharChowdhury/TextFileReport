import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class ExtractorReport implements Cleanable {

    public abstract Pattern getPattern();
    public abstract String getReportName();

    @Override
    public String clean(String data) {
        return data;
    }


    private String parse(String filePath) throws FileNotFoundException{
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        if (!scanner.hasNextLine()) return "Empty file";
        scanner.nextLine();
        while (scanner.hasNext()){
            String nextLine = scanner.nextLine();
            Matcher matcher = getPattern().matcher(nextLine);
            boolean hasPatternMatched = matcher.matches();
            if (hasPatternMatched){
                sb.append(clean(nextLine)).append("\t");
            }
        }
        String report = sb.toString();
        return report.isBlank() ? "Empty file": report;


    }
    public void prepareAndSendReport(String filePath) throws FileNotFoundException {
        System.out.println(MessageFormat.format("Starting report {0}...", getReportName()));
        String report = parse(filePath);
        System.out.println(report);
        System.out.println("report sent");

    }

}
