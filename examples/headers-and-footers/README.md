The code snippet provided illustrates how IronPDF empowers developers to create custom headers and footers in PDF documents, whether they are imported from the file system or crafted from HTML sources.

With the `TextHeaderFooter` class, developers have the ability to insert text into the left, right, or center sections of a PDF document's header or footer. As demonstrated, the use of IronPDF's integrated templating tokens—such as `{date}`, `{time}`, and `{page}`—simplifies the construction of headers and footers. These tokens are not mandatory; IronPDF allows the integration of any text in any quantity at these positions.

For enhanced creative control over the design, consider opting for the `HtmlHeaderFooter` class instead of the `TextHeaderFooter` class.