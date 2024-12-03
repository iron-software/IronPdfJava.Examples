***Based on <https://ironpdf.com/examples/file-to-pdf/>***

IronPDF enables the conversion of HTML files from local or network directories. To perform this conversion, utilize the method `PdfDocument.renderHtmlFileAsPdf`, as demonstrated in the example provided.

Once executed successfully, the `PdfDocument.renderHtmlFileAsPdf` method will generate a new `PdfDocument` object that encapsulates the contents of the HTML file located at the specified path. This method also ensures that all related assets within the HTML file, such as stylesheets, scripts, and images, are correctly rendered within their respective contexts in the file.

Essentially, the HTML file is reproduced as a PDF just as it is displayed in a web browser, complete with all visual elements and styling preserved!

However, if `PdfDocument.renderHtmlFileAsPdf` encounters issues in accessing or reading the HTML file, it will raise an `IOException`.

For additional details on adjusting the PDF output through customization options, refer to the [IronPDF API Documentation for ChromePdfRenderOptions](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html). This resource provides guidance on how to tailor the appearance of PDFs created using the `renderHtmlFileAsPdf` method.