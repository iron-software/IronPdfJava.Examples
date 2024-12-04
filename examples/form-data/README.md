***Based on <https://ironpdf.com/examples/form-data/>***

The following guide provides a walkthrough for developers on how to utilize IronPDF to generate and manipulate PDF documents equipped with fillable forms.

To construct PDF forms, you firstly need to shape the form using HTML code. Once completed, you can transform this into a PDF document with the use of IronPDF's rendering functions. The methods `PdfDocument.renderHtmlAsPdf` and `PdfDocument.renderHtmlFileAsPdf` are available to transform HTML content from either a string or a local file into a PDF document, respectively. These methods output fillable PDF forms that can be handled by any PDF reader of choice.

IronPDF automatically permits the forms within the HTML to be editable. Developers have control over this attribute and can turn it on or off by providing a `ChromePdfRenderOptions` object to the rendering method. Adjust the `createPdfFormsFromHtml` attribute via the `setCreatePdfFormsFromHtml` method to either true or false to toggle the editability of the forms.

To modify or retrieve data from fields within a PDF form, developers should make use of the `FormManager` class, accessible from `PDfDocument`. The `FormManager` can be called as shown here:

```java
FormManager pdfForm = document.getForm();
```

To assign values to form fields, utilize the `FormManager`'s `setFieldValue` method by providing the field's name (from the HTML `<input>` element’s name attribute) and the desired value. This is illustrated on lines 26 and 29 of the provided code example.

To extract values from a form field, you must directly reference the specific form field. This can be accomplished by accessing a `FormManager`'s indexed `FormField` list, as demonstrated below:

```java
FormManager pdfForm = document.getForm();
List<FormField> fields = pdfForm.getFields().getAllFields();
FormField firstNameField = fields.get(0);
System.out.println("First Name: " + firstNameField.getValue());
```

For additional insights on managing PDF forms with IronPDF, consider exploring the [IronPDF Documentation Page](https://ironpdf.com/docs/).

To learn about other offerings by Iron Software like IronBarcode for barcode generation and scanning, IronOCR for advanced optical character recognition, or IronWebScraper for effective web data extraction, visit the [Iron Software Official Website](https://ironsoftware.com/).