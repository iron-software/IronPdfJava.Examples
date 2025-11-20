***Based on <https://ironpdf.com/examples/headers-and-footers/>***

In this coding example, we highlight how developers can utilize IronPDF to insert headers and footers in PDF documents, whether they originate from the file system or are created from HTML sources.

The `TextHeaderFooter` class provides an opportunity for developers to define text for inclusion in the left, right, or center sections of a PDF document's header or footer. As indicated, IronPDF simplifies the process of crafting headers and footers by offering built-in templating tags like `{date}`, `{time}`, and `{page}`). While these tags are handy, IronPDF does not restrict users to these alone; it allows the integration of any type and amount of text in these areas.

For those seeking more design versatility, consider employing the `HtmlHeaderFooter` class instead of the `TextHeaderFooter` class within IronPDF. This alternative enhances document aesthetics and functionality.

[Explore the TextHeaderFooter Class Documentation](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/headerfooter/TextHeaderFooter.html) for more detailed insights and capabilities.