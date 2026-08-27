package com.ironsoftware.ironpdfjava.examples.howTo.createForms;

import java.io.IOException;

import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;

public class Section3 {
    public static void run() throws IOException {
            // Set the license key for IronPDF
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            // Define the HTML content with radio button form fields
            String htmlContent = """
            <html>
                <body>
                    <h2>Editable PDF Form</h2>
                    Choose your preferred travel type: <br>
                    <input type='radio' name='traveltype' value='Bike'> Bike <br>
                    <input type='radio' name='traveltype' value='Car'> Car <br>
                    <input type='radio' name='traveltype' value='Airplane'> Airplane
                </body>
            </html>
            """;
            
            // Generate a PDF document from the HTML content
            PdfDocument pdfDoc = PdfDocument.renderHtmlAsPdf(htmlContent);
            
            // Save the generated PDF to a file
            pdfDoc.saveAs("radioButtonForm.pdf");
    }
}
