IronPDF empowers developers to enhance PDF documents with personalized headers and footers. The following example demonstrates how developers can utilize the `ChromeRenderOptions` class in conjunction with the `HtmlHeaderFooter` class for this purpose.

With the `HtmlHeaderFooter` class, developers have the flexibility to design PDF headers or footers using HTML, providing a richer visual presentation compared to the more basic `TextHeaderFooter` class which only supports plain text. To embed custom HTML into your PDF, use the `addHtmlFragment` method from the `HtmlHeaderFooter` class. This method requires a string parameter filled with valid HTML5, CSS3, and JavaScript (ECMAScript 6). IronPDF processes this string, rendering it in the PDF just as a web browser would interpret and display the web content.

This capability means developers can craft headers featuring not just text but also images, a variety of colors, distinct typefaces, and other sophisticated design elements to enhance document appeal.

For developers needing simpler, text-only headers or footers, the `TextHeaderFooter` class is an excellent alternative that offers straightforward text customization options.