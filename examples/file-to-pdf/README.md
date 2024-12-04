***Based on <https://ironpdf.com/examples/file-to-pdf/>***

IronPDF offers the capacity to convert HTML files, whether stored locally or on a network path, into PDF documents. This is achieved through the use of the `PdfDocument.renderHtmlFileAsPdf` method, as illustrated below.

Upon successful execution, the `PdfDocument.renderHtmlFileAsPdf` method will produce a new `PdfDocument` object that encapsulates the content from the HTML file at the specified location. This method also ensures that all relative assets referred within the HTML, like paths to stylesheets, scripts, and images, are accurately represented within the PDF in the same context as they appear in the HTML file.

Essentially, the converted HTML file to PDF will look identical to how it is displayed in a web browser, complete with all images and CSS styles preserved!

Should there be an issue locating or opening the HTML file, `PdfDocument.renderHtmlFileAsPdf` will generate an `IOException`.

For additional details on utilizing this method to tailor the aesthetics of the generated PDFs, please refer to the [IronPDF API Documentation for ChromePdfRenderOptions](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html).