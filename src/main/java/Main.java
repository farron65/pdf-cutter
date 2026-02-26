
public class Main {
    public static void main(String[] args) {
        CliParser cli = new CliParser();
        cli.readPdfPath();
        try {
            PDFDocument pdf = new PDFDocument(cli.getPdfPath(), cli);
            String pagesToCut = cli.getPageRange(pdf.numPages);

            if (!pdf.removePages(pagesToCut)) {
                cli.errorPagesOutOfBounce(pagesToCut);
            }
            else {
                pdf.saveUpdatedPdf(cli.getNewFileName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}