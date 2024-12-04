***Based on <https://ironpdf.com/examples/pdf-generation-settings/>***

The following example illustrates the capability and versatility of IronPDF in transforming HTML to PDF documents.

`ChromePdfRenderOptions` provides developers with comprehensive control over the PDF conversion process from web pages.

Utilizing the `ChromePdfRenderOptions` class, developers have the ability to tailor page margins, set page orientations, insert annotations, include bookmarks, edit document metadata, control zoom scaling, alter CSS rule sets, among various other features. These options can be configured through instances of this class which are optionally passed as the second parameter to any static PDF rendering methods (`renderHtmlAsPdf`, `renderHtmlFileAsPdf`, `renderUrlAsPdf`). This process allows developers to modify how IronPDF processes and renders PDF content from web content during these methods.

You can delve into the specifics of customization with [`ChromePdfRenderOptions`](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html) in the API Reference, which details the available options.