package com.ironsoftware.ironpdfjava.examples.mergePdfs;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            List<PdfDocument> pdfs = new ArrayList<>();
            pdfs.add(pdfA);
            pdfs.add(pdfB);
            pdfs.add(pdfC);
            pdfs.add(pdfD);
            PdfDocument merged = PdfDocument.merge(pdfs);
    }
}
