package com.ironsoftware.ironpdfjava.examples.example.deleteSpecificPages;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.edit.PageSelection;

public class Program {
    public static void main(String[] args) throws IOException {
            // 4-Paged HTML Document example:
            String html = "<p> Hello Iron</p>"
                + "<p> This is 1st Page </p>"
                + "<div style = 'page-break-after: always;' ></div>"
                + "<p> This is 2nd Page</p>"
                + "<div style = 'page-break-after: always;' ></div>"
                + "<p> This is 3rd Page</p>"
                + "<div style = 'page-break-after: always;' ></div>"
                + "<p> This is 4th Page</p>";
            
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);
            
            // Remove a pages 2 & 3.
            pdf.removePages(PageSelection.pageRange(1,2));
            pdf.saveAs("Page1And4.pdf");
    }
}
