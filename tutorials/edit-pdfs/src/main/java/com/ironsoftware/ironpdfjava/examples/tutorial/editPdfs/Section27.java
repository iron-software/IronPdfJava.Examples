package com.ironsoftware.ironpdfjava.examples.tutorials.editPdfs;

import java.nio.file.*;
import com.ironsoftware.ironpdf;

public class Section27 {
    public static void run() {
            // #1 Use Case: Create a PDF Form from HTML Form Markup  
            Path outputLocation = Paths.get("assets/BasicForm.pdf");  
            String formHTML = "<html>"  
              + "<body>"  
              + "<h2>Editable PDF  Form</h2>"  
              + "<form>"  
              + "First name: <br> <input type='text' name='firstname' value=''> <br>"  
              + "Last name: <br> <input type='text' name='lastname' value=''>"  
              + "</form>"  
              + "</body>"  
              + "</html>";  
              
            ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
            renderOptions.setCreatePdfFormsFromHtml(true);  
            PdfDocument.renderHtmlAsPdf(formHTML, renderOptions).saveAs(outputLocation);  
              
            // #2 UseCase: Writing Values to the PDF Form  
            PdfDocument form = PdfDocument.fromFile(outputLocation);  
              
            // Set the value of the firstname input field.  
            form.getForm().setFieldValue("firstname", "Minnie");  
              
            // Set the value of the lastname input field.  
            form.getForm().setFieldValue("lastname", "Mouse");  
              
            // Save the changes to the PDF Form.  
            form.saveAs(Paths.get("assets/BasicForm_Filled.pdf"));
    }
}
