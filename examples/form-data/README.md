This example demonstrates how developers can leverage IronPDF to generate and manipulate PDF documents containing fillable forms.

To construct PDF forms, begin by crafting a form using HTML, and then transform it into a PDF format utilizing IronPDF’s static rendering functions. For translating an HTML string that includes form elements into a PDF, the method `PdfDocument.renderHtmlAsPdf` should be employed using the HTML content, as depicted in the sample provided. Alternatively, to convert an HTML file containing a form from a local source, utilize `PdfDocument.renderHtmlFileAsPdf`. Both techniques will generate PDF forms that can be opened and completed in any standard PDF viewer.

IronPDF automatically enables form fields within the HTML to be editable. This feature can be controlled dynamically by supplying a `ChromePdfRenderOptions` instance when rendering the HTML to PDF. Modifying the `createPdfFormsFromHtml` attribute through the `setCreatePdfFormsFromHtml` method allows developers to activate or deactivate the editable functionality of the forms.

Managing the input and output of data in a PDF form's fields is handled via the `PDfDocument`'s `FormManager`. Access it with the following line of code:

```java
FormManager pdfForm = document.getForm();
```

As indicated in the given code snippet, updating text field values is straightforward. Utilize the `FormManager`'s `setFieldValue` method by specifying the field's name (noted in the HTML's `<input>` element name attribute) and the intended value:

To retrieve the value from a form field, one needs to first secure a direct link to the targeted field by referencing `FormManager`'s comprehensive list of `FormField` objects. The following snippet exemplifies how to proceed:

```java
FormManager pdfForm = document.getForm();
List<FormField> fields = pdfForm.getFields().getAllFields();
FormField firstNameField = fields.get(0);
System.out.println("First Name: " + firstNameField.getValue());
``` 

This approach allows developers to effectively read and update the values of form fields within PDF documents created through HTML forms.