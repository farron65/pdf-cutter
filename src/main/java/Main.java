import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CliParser cli = new CliParser();
        cli.readPdfPath();

        PDFDocument pdf = new PDFDocument(cli.getPdfPath(), cli);
        String pagesToCut = cli.getPageRange(pdf.getNumPages());

        if (!pdf.removePages(pagesToCut)) {
            cli.errorPagesOutOfBounce(pagesToCut);
        }
        else {
            pdf.saveUpdatedPdf(cli.getNewFileName());
        }
    }
}