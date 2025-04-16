package com.ironsoftware.ironpdfjava.examples.howTo.createForms;

import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf;

public class Section2 {
    public static void run() {
            License.setLicenseKey("IRONPDF-MYLICENSE-KEY-1EF01");
            
            String htmlContent = """
            <html>
                <body>
                    <h2>Editable PDF Form</h2>
                    <h2>Task Completed</h2>
                    <label>
                        <input type='checkbox' id='taskCompleted' name='taskCompleted'> Mark task as completed
                    </label>
                    <h2>Select Priority</h2>
                    <label for='priority'>Choose priority level:</label>
                    <select id='priority' name='priority'>
                        <option value='high'>High</option>
                        <option value='medium'>Medium</option>
                        <option value='low'>Low</option>
                    </select>
                </body>
            </html>
            """;
            
            PdfDocument pdfDoc = PdfDocument.renderHtmlAsPdf(htmlContent);
            pdfDoc.saveAs("checkboxAndComboboxForm.pdf");
    }
}
