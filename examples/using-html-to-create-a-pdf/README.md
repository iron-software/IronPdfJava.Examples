***Based on <https://ironpdf.com/examples/using-html-to-create-a-pdf/>***

This example showcases how IronPDF can convert HTML content into high-quality PDFs that are visually identical to original web content. IronPDF can process both basic HTML structures, such as the example provided, as well as more intricate designs that include nested elements, CSS, and JavaScript.

Internally, IronPDF leverages a Chrome-based rendering engine to analyze HTML, JavaScript, and CSS, presenting them as genuine web content. This is then precisely translated into a PDF format, ensuring that the final output replicates how the content would look in a web browser adhering to modern standards.

The `PdfDocument` class in IronPDF offers multiple static methods that let developers render HTML from various sources into PDFs. The method `PdfDocument.renderHtmlAsPdf` transforms HTML markup contained within a string into a PDF. To convert content from a webpage on a local network or the internet, you can use `PdfDocument.renderUrlAsPdf`, which requires a URL string of the webpage to be rendered. For converting HTML saved locally, utilize the `PdfDocument.renderHtmlFileAsPdf` method and provide the file path.

Developers also have options to tailor the appearance of the PDF output using the `ChromePdfRenderOptions` class. For detailed usage, see the [ChromePdfRenderOptions API Documentation](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html).