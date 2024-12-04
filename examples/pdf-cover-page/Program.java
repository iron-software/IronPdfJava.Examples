package ironpdfjava.PdfCoverPage;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Create a Sample Cover Page using RenderHtmlAsPdf
            PdfDocument coverPage = PdfDocument.renderHtmlAsPdf("<h1>This is a Cover Page</h1>");
            PdfDocument webpage = PdfDocument.renderUrlAsPdf("https://www.nuget.org/packages/IronPdf/");
            
            // Set the page number of the PDF document to be created to 2.
            HeaderFooterOptions headerFooterOptions = new HeaderFooterOptions();
            headerFooterOptions.setFirstPageNumber(1);
            TextHeaderFooter footer = new TextHeaderFooter();
            footer.setLeftText("");
            footer.setCenterText("Page {page}");
            footer.setRightText("");
            webpage.addTextFooter(footer, headerFooterOptions);
            
            // Convert a web page's content to a PDF document.
            // Merge the cover page with the web page and save the new PDF to the filesystem.
            try {
                PdfDocument.merge(coverPage, webpage).saveAs(Paths.get("assets/cover_page_pdf.pdf"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
