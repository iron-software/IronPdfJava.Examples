***Based on <https://ironpdf.com/examples/converting-a-url-to-a-pdf/>***

IronPDF offers a straightforward and efficient method to convert HTML to PDF from various sources, including URLs. The following Java code snippet demonstrates how to generate a PDF document from web pages located on both local and remote servers using the `PdfDocument.renderUrlAsPdf` method. This method returns a `PdfDocument` object, which you can then save using the `saveAs` method.

The `PdfDocument.renderUrlAsPdf` method takes a String that represents a complete URL to a webpage. IronPDF will request the HTML content from this URL via HTTP and seamlessly convert it into a PDF document. If the webpage requires authentication, developers can pass a `ChromeHttpLoginCredentials` object as an optional second parameter to the `renderUrlAsPdf` method. This feature is particularly useful for accessing web pages inside a password-protected directory. For further details on the `ChromeHttpLoginCredentials` class, visit the [ChromeHttpLoginCredentials Class in API Reference](https://ironpdf.com/java/object-reference/api/).

This is an excellent approach to downloading PDFs from URLs in Java.

For more insights, watch [this video tutorial on converting URLs to PDFs with IronPDF](https://youtu.be/1yIlV74P3Ok).

Additionally, explore the [Detailed API Reference on the `ChromePdfRenderOptions` class](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html) to learn more about customizing the appearance of PDF documents during their creation from HTML content.