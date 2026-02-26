
import java.io.IOException;
import java.util.Scanner;

public class CliParser implements PageRemovalListener {
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

    public String getNewFileName() throws IOException {
        System.out.print("New file name: ");
        return scanner.next();
    }

    public void errorPagesOutOfBounce(String pagesToCut) {
        System.out.printf("ERROR: %s is out of bounce.\n", pagesToCut);
    }

   @Override
    public void onPageRemoved(int pageIdx) {
        System.out.printf("Page '%d' has been removed.\n", pageIdx+1);
   }
}

