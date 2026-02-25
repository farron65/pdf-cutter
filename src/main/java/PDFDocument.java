
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.Loader;
import java.io.File;
import java.io.IOException;

public class PDFDocument {

    PDFDocument(String filePath, String pagesToCut) throws IOException {
        this.pdfFile = Loader.loadPDF(new File(filePath));
        this.pagesToCut = pagesToCut;
    }
    
    private PDDocument pdfFile;
    public String pagesToCut;

}
