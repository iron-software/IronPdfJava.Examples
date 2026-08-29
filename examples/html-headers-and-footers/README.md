> Full guide: [HTML headers and footers](https://ironpdf.com/examples/html-headers-and-footers/?utm_source=github)

IronPDF provides developers the flexibility to customize PDF documents with personalized headers and footers. The following example illustrates how to use the `ChromePdfRenderOptions` and `HtmlHeaderFooter` classes for this purpose.

The `HtmlHeaderFooter` class enables developers to design a PDF's header or footer using HTML, where `TextHeaderFooter` is limited to plain text. To set up HTML content for headers or footers, utilize the `addHtmlFragment` method available in the `HtmlHeaderFooter` class. This method requires a string filled with valid HTML5, CSS3, and JavaScript (ECMAScript 6). IronPDF treats this string as rich hypertext markup, rendering it in the PDF just like a web browser would render on a webpage.

This functionality allows for the inclusion of images, diverse color schemes, sophisticated fonts, and other intricate design elements in PDF headers.

If your needs are geared towards more basic text-based headers or footers, the `TextHeaderFooter` class is a suitable alternative.

[Explore the HtmlHeaderFooter Class Documentation](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/headerfooter/HtmlHeaderFooter.html?utm_source=github) for more detailed information.