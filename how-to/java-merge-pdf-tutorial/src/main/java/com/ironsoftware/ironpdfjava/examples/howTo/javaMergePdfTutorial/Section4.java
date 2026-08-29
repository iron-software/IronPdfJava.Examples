package com.ironsoftware.ironpdfjava.examples.howTo.javaMergePdfTutorial;

import com.ironsoftware.ironpdf.PdfDocument;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Section4 {
    public static void run() throws IOException {
                String htmlA = "<p> [PDF_A] </p>"
                        + "<p> [PDF_A] 1st Page </p>"
                        + "<div style='page-break-after: always;'></div>"
                        + "<p> [PDF_A] 2nd Page</p>";
                String htmlB = "<p> [PDF_B] </p>"
                        + "<p> [PDF_B] 1st Page </p>"
                        + "<div style='page-break-after: always;'></div>"
                        + "<p> [PDF_B] 2nd Page</p>";
                String htmlC = "<p> [PDF_C] </p>"
                        + "<p> [PDF_C] 1st Page </p>"
                        + "<div style='page-break-after: always;'></div>"
                        + "<p> [PDF_C] 2nd Page</p>";
                String htmlD = "<p> [PDF_D] </p>"
                        + "<p> [PDF_D] 1st Page </p>"
                        + "<div style='page-break-after: always;'></div>"
                        + "<p> [PDF_D] 2nd Page</p>";
            
                // Creating PdfDocument objects
                PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
                PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
                PdfDocument pdfC = PdfDocument.renderHtmlAsPdf(htmlC);
                PdfDocument pdfD = PdfDocument.renderHtmlAsPdf(htmlD);
            
                // Add documents to a list
                List<PdfDocument> pdfs = new ArrayList<>();
                pdfs.add(pdfA);
                pdfs.add(pdfB);
                pdfs.add(pdfC);
                pdfs.add(pdfD);
            
                // Merge all documents into a single PDF
                PdfDocument merged = PdfDocument.merge(pdfs);
            
                // Save the merged PDF document
                merged.saveAs(Paths.get("assets/more_than_two_merged.pdf"));
    }
}
