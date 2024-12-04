package ironpdfjava.FileToPdf;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Apply your license key
            License.setLicenseKey("YOUR-LICENSE-KEY");
            
            // Set a log path
            Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
            
            // Render the HTML as a PDF. Stored in myPdf as type PdfDocument;
            PdfDocument myPdf = PdfDocument.renderHtmlFileAsPdf("example.html");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("html_file_saved.pdf"));
    }
}
