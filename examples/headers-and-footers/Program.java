package ironpdfjava.HeadersAndFooters;

import java.io.IOException;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Initialize HeaderFooterOptions object.
            HeaderFooterOptions options = new HeaderFooterOptions();
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("http://www.google.com");
            
            // Add a header to every page easily
            // Mergeable fields are:
            // {page} {total-pages} {url} {date} {time} {html-title} & {pdf-title}
            options.setFirstPageNumber(1); // use 2 if a coverpage  will be appended
            TextHeaderFooter textHeader = new TextHeaderFooter();
            textHeader.setDrawDividerLine(true);
            textHeader.setCenterText("{url}");
            textHeader.setFont(FontTypes.getHelvetica());
            textHeader.setFontSize(12);
            pdf.addTextHeader(textHeader, options);
            
            // Add a footer too
            TextHeaderFooter textFooter = new TextHeaderFooter();
            textFooter.setDrawDividerLine(true);
            textFooter.setFont(FontTypes.getArial());
            textFooter.setFontSize(10);
            textFooter.setLeftText("{date} {time}");
            textFooter.setRightText("{page} of {total-pages}");
            pdf.addTextFooter(textFooter, options);
            
            try {
                pdf.saveAs(Paths.get("assets/text_headers_footers.pdf"));
            } catch (IOException e) {
                System.out.println("Failed to save PDF");
                throw new RuntimeException(e);
            }
    }
}
