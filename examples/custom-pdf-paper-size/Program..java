
import com.ironsoftware.ironpdf.*;  
import com.ironsoftware.ironpdf.render.*;  
import java.io.IOException;  
import java.nio.file.Paths;

String html = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>";  
  
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
renderOptions.setPaperSize(PaperSize.Custom);  
  
/*  
 * Setting page sizes using different measuring units: * 1. setCustomPaperWidth( width ) / setCustomPaperHeight( height ): for inches * 2. setCustomPaperSizeInCentimeters( width, height ): for centimeters. * 3. setCustomPaperSizeInMillimeters( width, height ): for millimeters * 4. setCustomPaperSizeInPixelsOrPoints( width, height ): for pixels/points */renderOptions.setCustomPaperSizeInCentimeters(13.97, 13.97);  
  
PdfDocument.renderHtmlAsPdf(html, renderOptions).saveAs(Paths.get("assets/CustomPaperSize.pdf"));