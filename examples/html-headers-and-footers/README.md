***Based on <https://ironpdf.com/examples/html-headers-and-footers/>***

IronPDF empowers developers to personalize PDF documents by adding custom headers and footers. The following example illustrates how to implement this using the `ChromePdfRenderOptions` class in tandem with the `HtmlHeaderFooter` class.

The `HtmlHeaderFooter` class provides a method for customizing a PDF's header or footer with HTML instead of just plain text, which is typically handled by the `TextHeaderFooter` class. To specify the HTML content for the header or footer, use the `addHtmlFragment` method of this class. This method requires a string containing valid HTML5, CSS3, and JavaScript (ECMAScript 6). IronPDF interprets this string as rich text markup, rendering it in the PDF just as a web browser would.

This feature enables the creation of visually appealing headers with images, varied colors, unique fonts, and other intricate design elements.

For simpler text-based customization of headers and footers, the `TextHeaderFooter` class is recommended as an alternative.

For more detailed guidance on enhancing PDF headers and footers and for comprehensive documentation, please visit [IronPDF Documentation](https://ironpdf.com).