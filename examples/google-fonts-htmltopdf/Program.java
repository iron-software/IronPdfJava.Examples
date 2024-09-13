
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.render.ChromePdfRenderOptions;

import java.io.IOException;
import java.nio.file.Paths;

String htmlWithFont = "<link href=\"https://fonts.googleapis.com/css?family=Lobster\"rel=\"stylesheet\"><p style=\"font-family: 'Lobster', serif; font-size:30px;\"> Hello Google Fonts</p>";
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();
renderOptions.setWaitFor(new WaitFor(500));

PdfDocument doc = PdfDocument.renderHtmlAsPdf(htmlWithFont, renderOptions);

// Save the PDF
try {
    doc.saveAs(Paths.get("assets/font.pdf"));
} catch (IOException exception) {
    String.format("Failed to save the PDF to the filesystem: %s", exception.getMessage());
    exception.printStackTrace();
}