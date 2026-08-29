> Full guide: [Form data](https://ironpdf.com/examples/form-data/?utm_source=github)

This code sample shows how developers can utilize IronPDF to generate and modify PDF documents containing fillable forms.

To produce PDF forms, begin by designing your form using HTML. Once the form is formatted in HTML, you can transform it into a PDF using IronPDF’s rendering methods. You can either use `PdfDocument.renderHtmlAsPdf` to convert HTML content from a string directly into a PDF or `PdfDocument.renderHtmlFileAsPdf` to convert an HTML file from a local path into a PDF. Both approaches will create PDF forms that can be filled out in any standard PDF reader.

IronPDF automatically enables editability for forms embedded within HTML. However, programmers have the flexibility to switch this feature on or off. This is managed by passing a `ChromePdfRenderOptions` object to the PDF rendering method and explicitly setting the `createPdfFormsFromHtml` attribute to true or false using the method `setCreatePdfFormsFromHtml`.

To manipulate the fields of a PDF form, access the `PdfDocument`’s `FormManager`. Here’s how you can use it:

As demonstrated in lines 26 and 29 of the provided code, a developer can directly assign values to form text fields by using `FormManager`’s `setFieldValue`. This function requires the name of the text field (aligned with the name attribute in the HTML `<input>` element) and the value to populate the field with.

To extract a value from a form field, it is necessary to first secure a direct reference to the desired `FormField` from the `FormManager`’s indexed collection of fields. The following example illustrates how to accomplish this:

[Learn to Create PDF Forms in Java with IronPDF](https://ironpdf.com/java/how-to/create-forms/?utm_source=github)