***Based on <https://ironpdf.com/examples/html-headers-and-footers/>***

IronPDF offers functionality that lets developers add custom headers and footers to PDF documents. This demonstration utilizes the `ChromePdfRenderOptions` class together with the `HtmlHeaderFooter` class to achieve such customizations.

The `HtmlHeaderFooter` class provides the ability to enhance a PDF's header or footer using HTML, a more dynamic option compared to the `TextHeaderFooter` class, which limits customization to plain text. To embed HTML into the header or footer, utilize the `addHtmlFragment` method of this class. This method requires a string filled with valid HTML5, CSS3, and JavaScript (ECMAScript 6) content. IronPDF then renders this content into the PDF, mimicking the display capabilities of a common web browser.

This class enables the incorporation of advanced design elements in headers such as images, diverse color schemes, and specialized fonts.

For developers seeking simpler text-based customizations for headers or footers, the `TextHeaderFooter` class is recommended as an alternative.

For further details on how to personalize PDF headers and footers, along with comprehensive documentation, please check out the [IronPDF Documentation](https://ironpdf.com).