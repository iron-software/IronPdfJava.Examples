package com.ironsoftware.ironpdfjava.examples.quickstart.quickstart;

import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            // Import statement for IronPDF Java
            import com.ironsoftware.ironpdf.*;
            
            // Apply your license key
            License.setLicenseKey("YOUR-LICENSE-KEY");
            
            // Set a log path
            Settings.setLogPath(Paths.get("C:/tmp/IronPdfEngine.log"));
            
            // Render the HTML as a PDF. Stored in myPdf as type PdfDocument
            PdfDocument myPdf = PdfDocument.renderHtmlAsPdf("<h1> ~Hello World~ </h1> Made with IronPDF!");
            
            // Save the PdfDocument to a file
            myPdf.saveAs(Paths.get("html_saved.pdf"));
    }
}
