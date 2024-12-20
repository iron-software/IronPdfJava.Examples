package com.ironsoftware.ironpdfjava.examples.howTo.javaMergePdfTutorial;

import java.util.List;
import com.ironsoftware.ironpdf.*;

public class Section4 {
    public static void run() {
            public static void main(String [] args) throws IOException {
                String htmlA = "<p> [PDF_A] </p>"
                        + "<p> [PDF_A] 1st Page </p>"
                        + "<div style = 'page-break-after: always;' ></div>"
                        + "<p> [PDF_A] 2nd Page</p>";
                String htmlB = "<p> [PDF_B] </p>"
                        + "<p> [PDF_B] 1st Page </p>"
                        + "<div style = 'page-break-after: always;' ></div>"
                        + "<p> [PDF_B] 2nd Page</p>";
                String htmlC = "<p> [PDF_C] </p>"
                        + "<p> [PDF_C] 1st Page </p>"
                        + "<div style = 'page-break-after: always;' ></div>"
                        + "<p> [PDF_C] 2nd Page</p>";
                String htmlD = "<p> [PDF_D] </p>"
                        + "<p> [PDF_D] 1st Page </p>"
                        + "<div style = 'page-break-after: always;' ></div>"
                        + "<p> [PDF_D] 2nd Page</p>";
            
                PdfDocument pdfA = PdfDocument.renderHtmlAsPdf(htmlA);
                PdfDocument pdfB = PdfDocument.renderHtmlAsPdf(htmlB);
                PdfDocument pdfC = PdfDocument.renderHtmlAsPdf(htmlC);
                PdfDocument pdfD = PdfDocument.renderHtmlAsPdf(htmlD);
            
                List<PdfDocument> pdfs = new ArrayList<>();
                pdfs.add(pdfA);
                pdfs.add(pdfB);
                pdfs.add(pdfC);
                pdfs.add(pdfD);
            
                PdfDocument merged = PdfDocument.merge(pdfs);
            
                merged.saveAs(Paths.get("assets/more_than_two_merged.pdf"));
            }
    }
}
