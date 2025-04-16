package com.ironsoftware.ironpdfjava.examples.howTo.createForms;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section1 {
    public static void run() {
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            String htmlContent = """
            <html>
                <body>
                    <h2>Editable PDF Form</h2>
                    <form>
                        First name: <br> <input type='text' name='firstname' value=''> <br>
                        Last name: <br> <input type='text' name='lastname' value=''> <br>
                        Address: <br> <textarea name='address' rows='4' cols='50'></textarea>
                    </form>
                </body>
            </html>
            """;
            
            PdfDocument pdfDoc = PdfDocument.renderHtmlAsPdf(htmlContent);
            pdfDoc.saveAs("textAreaAndInputForm.pdf");
    }
}
