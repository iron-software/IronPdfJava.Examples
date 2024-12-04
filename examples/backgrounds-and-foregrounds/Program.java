package ironpdfjava.BackgroundsAndForegrounds;

import com.ironsoftware.ironpdf.*;  
import java.io.IOException;  
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) {

        // Load background and foreground PDFs from the filesystem (or create them programmatically)  
        PdfDocument backgroundPdf = PdfDocument.fromFile(Paths.get("assets/MyBackground.pdf"));  
        PdfDocument foregroundPdf = PdfDocument.fromFile(Paths.get("assets/MyForeground.pdf"));  
            
        // Render content (HTML, URL, etc) as a PDF Document  
        PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://www.nuget.org/packages/IronPdf");  
            
        // Add the background and foreground PDFs to the newly-rendered document.  
        pdf.addBackgroundPdf(backgroundPdf);  
        pdf.addForegroundPdf(foregroundPdf);  
            
        pdf.saveAs(Paths.get("assets/BackgroundForegroundPdf.pdf"));
    }
}
