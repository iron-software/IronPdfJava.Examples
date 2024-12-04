***Based on <https://ironpdf.com/examples/headers-and-footers/>***

This sample demonstrates how IronPDF enables the customization of headers and footers for PDF documents, either loaded from the file system or created from HTML sources.

Using the `TextHeaderFooter` class, developers can define text for the left, right, or center sections of a PDF document's header or footer. As illustrated, it's simple to configure headers and footers leveraging IronPDF's built-in template tags, such as `{date}`, `{time}`, and `{page}`. IronPDF does not limit users to these tags only; it allows for the integration of any type and volume of text in these areas.

For enhanced design versatility within IronPDF, consider opting for the `HtmlHeaderFooter` class instead of the `TextHeaderFooter` class. This choice improves the aesthetic appeal and customization of your document presentations.