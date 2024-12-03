***Based on <https://ironpdf.com/examples/headers-and-footers/>***

The following code sample illustrates how IronPDF grants developers the capability to assign headers and footers in PDF documents, whether they’re sourced from a filesystem or created from HTML.

Utilizing the `TextHeaderFooter` class, developers can designate text for the left, center, or right sections of a PDF document's header or footer. The example above demonstrates how developers can effortlessly construct headers and footers with the help of IronPDF's predefined templating tags such as `{date}`, `{time}`, and `{page}`. There's no obligation to stick strictly to these tags; IronPDF allows the inclusion of any text in any quantity at these positions for enhanced customization.

For added creativity and design control, consider the `HtmlHeaderFooter` class as an alternative to the `TextHeaderFooter` class. This substitution significantly enhances the aesthetic appeal and presentation of your documents within IronPDF.