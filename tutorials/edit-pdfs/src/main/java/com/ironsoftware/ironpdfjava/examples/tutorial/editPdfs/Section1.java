package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            PdfDocument coverPagePdf = PdfDocument.renderHtmlAsPdf("<h1>Cover Page</h1><hr>");
            PDF.prependPdf(coverPagePdf);
            PDF.saveAs(Paths.get("report_with_cover.pdf"));
    }
}
