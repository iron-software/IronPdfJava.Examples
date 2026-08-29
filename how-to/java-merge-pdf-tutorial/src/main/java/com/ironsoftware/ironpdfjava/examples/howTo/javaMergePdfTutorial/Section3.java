package com.ironsoftware.ironpdfjava.examples.howTo.javaMergePdfTutorial;

import java.io.IOException;

import java.nio.file.Paths;
import com.ironsoftware.ironpdf.PdfDocument;

public class Section3 {
    public static void run() throws IOException {
            // The page merges these before the snippet; merged here so the
            // section stands on its own.
            PdfDocument pdfA = PdfDocument.renderHtmlAsPdf("<p>[PDF_A]</p>");
            PdfDocument pdfB = PdfDocument.renderHtmlAsPdf("<p>[PDF_B]</p>");
            PdfDocument merged = PdfDocument.merge(pdfA, pdfB);

            merged.saveAs(Paths.get("assets/merged.pdf"));
    }
}
