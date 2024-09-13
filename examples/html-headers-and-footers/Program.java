
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.headerfooter.HtmlHeaderFooter;
import java.io.IOException;
import java.nio.file.Paths;

PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");
// Build a footer using HTML
// Merge Fields are: {page} {total-pages} {url} {date} {time} {html-title} & {pdf-title}
HtmlHeaderFooter footer = new HtmlHeaderFooter();
footer.setMaxHeight(15); // millimeters
footer.setHtmlFragment("<center><i>{page} of {total-pages}</i></center>");
footer.setDrawDividerLine(true);
pdf.addHtmlFooter(footer);
List<PdfDocument> pdfs = new ArrayList<>();

// Build a header using an image asset
// Note the use of BaseUrl to set a relative path to the assets
HtmlHeaderFooter header = new HtmlHeaderFooter();
header.setMaxHeight(20); // millimeters
header.setHtmlFragment("<img src=\"logo.png\" />");
header.setBaseUrl("./assets/");
pdf.addHtmlHeader(header);
try {
    pdf.saveAs(Paths.get("assets/html_headers_footers.pdf"));
} catch (IOException e) {
    throw new RuntimeException(e);
}