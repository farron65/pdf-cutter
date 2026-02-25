
public class Main {
    public static void main(String[] args) {
        CliParser cli = new CliParser();
        cli.readPdfPath();
        try {
            String p = cli.getPageRange();
            PDFDocument pdf = new PDFDocument(cli.getPdfPath(), p);
            System.out.print(cli.getPdfPath()+ ", " + p);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
