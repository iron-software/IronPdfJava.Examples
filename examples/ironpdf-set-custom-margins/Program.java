
import com.ironsoftware.ironpdf.PdfDocument;  
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;  
import java.io.IOException;  
import java.nio.file.Paths;

// Set Margins (in millimeters)  
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
renderOptions.setMarginTop(40);  
renderOptions.setMarginLeft(20);  
renderOptions.setMarginRight(20);  
renderOptions.setMarginBottom(40);  
  
PdfDocument.renderHtmlFileAsPdf("assets/wikipedia.html", renderOptions).saveAs(Paths.get("assets/MyContent.pdf"));