***Based on <https://ironpdf.com/examples/html-headers-and-footers/>***

IronPDF enables developers to enhance PDF documents by adding tailored headers and footers. The following code example illustrates how to implement this customization using the `ChromePdfRenderOptions` class in conjunction with the `HtmlHeaderFooter` class.

The `HtmlHeaderFooter` class provides the capability to design a PDF's header or footer with HTML content, moving beyond the simpler plain text options available with the `TextHeaderFooter` class. To apply HTML to a header or footer, utilize the `addHtmlFragment` method on an instance of this class. This method requires a string that contains valid HTML5, CSS3, and JavaScript (ECMAScript 6). IronPDF will process this string, rendering the detailed hypertext markup within the PDF exactly as a web browser would render it.

Developers can leverage this feature to craft dynamic headers that feature images, diverse color schemes, specific fonts, and other sophisticated design elements.

For those seeking more basic text-centric header and footer customizations, the `TextHeaderFooter` class is a suitable alternative.

For comprehensive insights on customizing PDF headers and footers, along with detailed documentation, please visit the [IronPDF Documentation](https://ironpdf.com).