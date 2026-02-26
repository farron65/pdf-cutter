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

    public void saveUpdatedPdf(String newFileName) {
        try {
            pdfFile.save(newFileName + ".pdf");
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public boolean removePages(String pagesToCut) {
        int[] pgNum = Arrays.stream(pagesToCut.split("-")).mapToInt(num -> Integer.parseInt(num)).toArray();
        if (pdfFile.getNumberOfPages() < pgNum[pgNum.length-1]) {
            return false;
        }
        else if (pgNum.length > 1) {
            for (int i = pgNum[pgNum.length-1]-1; i >= pgNum[0]-1; i--) {
                pdfFile.removePage(i);
                listener.onPageRemoved(i);
            }
        }
        else {
            pdfFile.removePage(pgNum[0]-1);
            listener.onPageRemoved(pgNum[0]-1);
        }
        return true;
    }
}
