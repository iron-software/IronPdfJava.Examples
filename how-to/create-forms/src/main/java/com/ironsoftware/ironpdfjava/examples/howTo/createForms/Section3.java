package com.ironsoftware.ironpdfjava.examples.howTo.createForms;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section3 {
    public static void run() {
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            String htmlContent = """
            <html>
                <body>
                    <h2>Editable PDF Form</h2>
                    Choose your preferred travel type: <br>
                    <input type='radio' name='traveltype' value='Bike'>
                    Bike <br>
                    <input type='radio' name='traveltype' value='Car'>
                    Car <br>
                    <input type='radio' name='traveltype' value='Airplane'>
                    Airplane
                </body>
            </html>
            """;
            
            PdfDocument pdfDoc = PdfDocument.renderHtmlAsPdf(htmlContent);
            pdfDoc.saveAs("radioButtomForm.pdf");
    }
}
