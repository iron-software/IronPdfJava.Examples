package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import com.ironsoftware.ironpdf.signature.SignatureManager;
import com.ironsoftware.ironpdf;

public class Section16 {
    public static void run() {
            PdfDocument PDF = PdfDocument.fromFile(Paths.get("assets/sample.pdf"));
            
            File path = new File("assets/Ironpdf.pfx");
            byte [] certificate = new byte [(int)path.length()];
            
            Signature signature = new Signature(certificate,"1234");
            
            SignatureManager manager = PDF.getSignature();
            
            manager.SignPdfWithSignature(signature);
    }
}
