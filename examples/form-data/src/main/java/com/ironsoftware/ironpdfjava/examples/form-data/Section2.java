package com.ironsoftware.ironpdfjava.examples.formData;

import com.ironsoftware.ironpdf.*;

public class Section2 {
    public static void run() {
            FormManager pdfForm = document.getForm();
            List<FormField> fields = pdfForm.getFields().getAllFields();
            FormField firstNameField = fields.get(0);
            System.out.println("First Name: " + firstNameField.getValue());
    }
}
