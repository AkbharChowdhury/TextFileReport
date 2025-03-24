import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new NumberExtractorReport().prepareAndSendReport("src/data.txt");
        new EmailExtractorReport().prepareAndSendReport("src/data.txt");
    }
}