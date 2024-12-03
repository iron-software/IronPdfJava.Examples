***Based on <https://ironpdf.com/examples/form-data/>***

This code snippet illustrates how developers can leverage IronPDF to generate and modify PDF documents featuring fillable forms.

To fabricate PDF forms, first construct the form using HTML and then transition it into a PDF format using IronPDF’s static rendering functions. Utilize the method `PdfDocument.renderHtmlAsPdf` to transform an HTML string containing a form into a PDF, as illustrated earlier, or use `PdfDocument.renderHtmlFileAsPdf` for converting an HTML file from a local directory. Both approaches yield editable PDF forms that can be used with any standard PDF viewer.

IronPDF automatically allows form fields within the HTML to be editable. This feature can be enabled or disabled by passing a `ChromePdfRenderOptions` object when rendering the PDF. Adjust the `createPdfFormsFromHtml` setting to true or false using the `setCreatePdfFormsFromHtml` function based on your needs.

To manipulate the values of a PDF form's fields, access the `FormManager` from the `PdfDocument`, as demonstrated here:

```java
FormManager pdfForm = document.getForm();
```

In the provided example, on lines 26 and 29, values are assigned to form fields simply by invoking `setFieldValue` on `FormManager`. This method requires the name of the text field (matching the name attribute in the original HTML `<input>` element) and the value to be set.

Retrieving a field’s value involves specifically fetching that form field from the `FormManager`'s `FormField` list. The subsequent code snippet shows how to achieve this:

```java
FormManager pdfForm = document.getForm();
List<FormField> fields = pdfForm.getFields().getAllFields();
FormField firstNameField = fields.get(0);
System.out.println("First Name: " + firstNameField.getValue());
```

For additional guidance on manipulating PDF forms with IronPDF, consider visiting the [IronPDF Documentation Page](https://ironpdf.com/docs/).

Explore more about various libraries and solutions provided by Iron Software, including IronBarcode for generating and scanning barcodes, IronOCR for robust OCR features, and IronWebScraper for effective web data extraction, at the [Iron Software Official Website](https://ironsoftware.com/).