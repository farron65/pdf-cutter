
public class Main {
    public static void main(String[] args) {
        CliParser cli = new CliParser();
        cli.readPdfPath();
        try {
            String pagesToCut = cli.getPageRange();
            PDFDocument pdf = new PDFDocument(cli.getPdfPath(), pagesToCut, cli);
            System.out.println();
            System.out.println(cli.getPdfPath()+ ", " + pagesToCut);
            System.out.println("Number of pages: " + pdf.numPages);

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