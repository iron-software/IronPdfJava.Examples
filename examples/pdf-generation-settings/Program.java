
import com.ironsoftware.ironpdf.*;  
import com.ironsoftware.ironpdf.render.*;
import java.io.IOException;
import java.nio.file.Paths;

// Apply your license key
License.setLicenseKey("YOUR-LICENSE-KEY");

// Set a log path
Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));

// Create a new ChromePdfRenderOptions object
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();

// Set custom options for the generated PDF document (paper size, title, etc.)
renderOptions.setCustomPaperSizeInCentimeters(31.75, 50.80 );
renderOptions.setPrintHtmlBackgrounds(true);
renderOptions.setPaperOrientation(PaperOrientation.LANDSCAPE);
renderOptions.setTitle("My PDF Document Name");
renderOptions.setEnableJavaScript(true);
renderOptions.setWaitFor(new WaitFor(50)); // time in milliseconds
renderOptions.setCssMediaType(CssMediaType.SCREEN);
renderOptions.setFitToPaperMode(FitToPaperModes.None);
renderOptions.setZoom(100); // percentage
renderOptions.setCreatePdfFormsFromHtml(true);

// Customize PDF Margins by specifying sizes in millimeters
renderOptions.setMarginTop(40);
renderOptions.setMarginBottom(40);
renderOptions.setMarginLeft(20);
renderOptions.setMarginRight(20);

// Render the HTML document as a PDF using the specified rendering options.
try {
    PdfDocument pdf = PdfDocument.renderHtmlFileAsPdf("wikipedia.html", renderOptions);
    pdf.saveAs(Paths.get("assets/wikipedia.pdf"));
} catch (IOException e) {
    e.printStackTrace();
}