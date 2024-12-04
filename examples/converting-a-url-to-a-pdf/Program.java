package ironpdfjava.ConvertingAUrlToAPdf;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Apply your license key
            License.setLicenseKey("YOUR-LICENSE-KEY");
            
            // Set a log path
            Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
            
            // Render the HTML as a PDF. Stored in myPdf as type PdfDocument;
            PdfDocument myPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("url.pdf"));
    }
}
