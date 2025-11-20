***Based on <https://ironpdf.com/examples/file-to-pdf/>***

IronPDF enables the conversion of HTML files situated on local drives or network paths. To perform this conversion, utilize the `PdfDocument.renderHtmlFileAsPdf` method, as demonstrated in the example provided.

Upon successful execution, the `PdfDocument.renderHtmlFileAsPdf` method returns a new `PdfDocument` instance encapsulating the content from the specified HTML file. This method also ensures that all relative references within the HTML, such as stylesheets, scripts, and image paths, are correctly rendered, maintaining their original context from the HTML.

Essentially, the output PDF document will mirror the appearance of the HTML file in a web browser, complete with all images and CSS preserved.

The `PdfDocument.renderHtmlFileAsPdf` method might issue an `IOException` if it fails to locate or open the specified HTML file.

For additional details on customizing the resulting PDF's appearance using the `renderHtmlFileAsPdf` method, consult the [IronPDF API Documentation for ChromePdfRenderOptions](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html).

[Learn to Convert HTML to PDF with Java Tutorial](https://ironpdf.com/java/tutorials/html-to-pdf/) provides further insights and guidance on this process.