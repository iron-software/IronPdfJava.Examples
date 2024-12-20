***Based on <https://ironpdf.com/examples/form-data/>***

The following example illustrates how to utilize IronPDF for creating and manipulating PDF documents that incorporate fillable forms.

To begin with PDF forms, construct the form using HTML syntax and deploy one of IronPDF's rendering methods to transform it into a PDF document. You can use the method `PdfDocument.renderHtmlAsPdf` to convert HTML content directly from a string, as indicated in the provided sample. Alternatively, `PdfDocument.renderHtmlFileAsPdf` allows for the conversion of an HTML file from a local path into a PDF. Both techniques result in a PDF document containing forms that are fillable using standard PDF readers.

IronPDF automatically sets forms within an HTML layout to be editable. However, this functionality can be customized using a `ChromePdfRenderOptions` object. By adjusting the `createPdfFormsFromHtml` attribute through the `setCreatePdfFormsFromHtml` method, developers can enable or disable the creation of editable forms within the PDF.

Manipulating a PDF form involves accessing and modifying form fields via the `PDfDocument`'s `FormManager`. The following line of code accesses the form manager:

```java
FormManager pdfForm = document.getForm();
```

To assign values to the form fields, employ the `FormManager`'s `setFieldValue` method. This requires specifying the field name (aligned with the name attribute in the HTML input element) and the desired value, as demonstrated on lines 26 and 29.

Retrieving values from form fields is achieved by first accessing the form field directly via its index in the `FormManager`'s list of `FormField` objects. The snippet below shows how to acquire and print field values:

```java
FormManager pdfForm = document.getForm();
List<FormField> fields = pdfForm.getFields().getAllFields();
FormField firstNameField = fields.get(0);
System.out.println("First Name: " + firstNameField.getValue());
```

For comprehensive guidance on handling PDF forms with IronPDF, refer to the [IronPDF Documentation Page](https://ironpdf.com/docs/).

Explore additional solutions and libraries offered by Iron Software, including IronBarcode for barcode creation and scanning, IronOCR for robust OCR functionality, and IronWebScraper for effective web data extraction, all available on the [Iron Software Official Website](https://ironsoftware.com/).