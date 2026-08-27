package com.ironsoftware.ironpdfjava.examples.howTo.javaMergePdfTutorial;

import com.ironsoftware.ironpdf.PdfDocument;

public class Section2 {
    public static void run() throws IOException {
            String htmlA = "<p> [PDF_A] </p>"
                    + "<p> [PDF_A] 1st Page </p>"
                    + "<div style='page-break-after: always;'></div>"
                    + "<p> [PDF_A] 2nd Page</p>";
            String htmlB = "<p> [PDF_B] </p>"
                    + "<p> [PDF_B] 1st Page </p>"
                    + "<div style='page-break-after: always;'></div>"
                    + "<p> [PDF_B] 2nd Page</p>";
                    
            // Create PdfDocument objects using the HTML content
            PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
            PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
            
            // Merge the two PDF documents into a single document
            PdfDocument merged = PdfDocument.merge(pdfA, pdfB);
    }
}
