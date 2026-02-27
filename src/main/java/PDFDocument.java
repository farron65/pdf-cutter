import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.Loader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PDFDocument {

    PDFDocument(String filePath, PageRemovalListener listener) throws IOException {
        this.pdfFile = Loader.loadPDF(new File(filePath));

        this.listener = listener;
    }

    private PDDocument pdfFile;

    private PageRemovalListener listener;

    int getNumPages() {
        return pdfFile.getNumberOfPages();
    }

    public void saveUpdatedPdf(String newFileName) throws IOException {
        pdfFile.save(newFileName + ".pdf");
    }

    public boolean removePages(String pagesToCut) {
        PageParser s = new PageParser();
        int[] pgNum = s.parsePages(pagesToCut);
        if (pdfFile.getNumberOfPages() < Arrays.stream(pgNum).max().getAsInt()) {
            return false;
        }
        else {
            for (int i : pgNum) {
                pdfFile.removePage(i-1);
                listener.onPageRemoved(i);
            }
        }
        return true;
    }
}
