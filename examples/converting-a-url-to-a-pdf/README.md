***Based on <https://ironpdf.com/examples/converting-a-url-to-a-pdf/>***

IronPDF offers a straightforward and efficient approach to converting HTML into PDFs from various sources, including URLs. The following example illustrates how to generate a PDF from web pages accessible via local and external server URLs using the `PdfDocument.renderUrlAsPdf` method in Java. This method returns a `PdfDocument` object which you can subsequently save using the `saveAs` method.

The `PdfDocument.renderUrlAsPdf` method requires a string with an absolute URL. IronPDF handles the HTTP request for the URL, captures the returned HTML, and accurately converts it to a PDF format. For secured web pages needing authentication, developers can pass login credentials (username and password) using a `ChromeHttpLoginCredentials` object as an optional secondary parameter. For further details on handling credentials, please view the [ChromeHttpLoginCredentials Class in the API Reference](https://ironpdf.com/java/object-reference/api/).

This feature provides an excellent means to download PDFs from URLs using Java.

For more insights, watch [this video tutorial on converting URLs to PDFs with IronPDF](https://youtu.be/1yIlV74P3Ok).

Furthermore, explore the [Detailed API Reference on the `ChromePdfRenderOptions` class](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html) to learn how you can tailor the appearance and conversion process of your PDF documents from HTML sources.