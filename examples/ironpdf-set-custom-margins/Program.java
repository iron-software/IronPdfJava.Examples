package ironpdfjava.IronpdfSetCustomMargins;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Set Margins (in millimeters)  
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
            renderOptions.setMarginTop(40);  
            renderOptions.setMarginLeft(20);  
            renderOptions.setMarginRight(20);  
            renderOptions.setMarginBottom(40);  
              
            PdfDocument.renderHtmlFileAsPdf("assets/wikipedia.html", renderOptions).saveAs(Paths.get("assets/MyContent.pdf"));
    }
}
