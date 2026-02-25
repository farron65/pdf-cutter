import java.io.IOException;
import java.util.Scanner;

public class CliParser {
    private Scanner scanner = new Scanner(System.in);
    private String pdfPath;

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public void readPdfPath() {
        System.out.print("PDF Path: ");
        setPdfPath(scanner.nextLine());
    }

    public String getPageRange() throws IOException {
        System.out.print("What page to cut: ");
        return scanner.next();
    }
}

