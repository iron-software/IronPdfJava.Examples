package com.ironsoftware.ironpdfjava.examples.example.pdfSignatures;

import java.io.IOException;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.signature.Signature;
import com.ironsoftware.ironpdf.signature.SignatureManager;
import java.awt.Rectangle;
import java.io.File;
import java.nio.file.Files;

public class Program {
    public static void main(String[] args) throws IOException {
            // Step 1. Create a PDF
            PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Testing 2048 bit digital security</h1>");
            
            // Step 2. Create a Signature.
            // You may create a .pfx or .p12 PDF signing certificate using Adobe Acrobat Reader.
            // Read: https://helpx.adobe.com/acrobat/using/digital-ids.html
            Signature signature = new Signature("Iron.pfx", "123456");
            
            // Step 3. Optional signing options and a handwritten signature graphic
            signature.setSigningContact("support@ironsoftware.com");
            signature.setSigningLocation("Chicago, USA");
            signature.setSigningReason("To show how to sign a PDF");
            File imageFile = new File("handwriting.png");
            byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
            signature.setSignatureImage(imageBytes, new Rectangle(100, 200, 250, 100));
            
            // Step 4. Sign the PDF with the PdfSignature. Multiple signing certificates may be used
            SignatureManager signatureManager = pdf.getSignature();
            signatureManager.SignPdfWithSignature(signature);
            
            // Step 5. The PDF is not signed until saved to file, stream or byte array.
            pdf.saveAs("signed.pdf");
    }
}
