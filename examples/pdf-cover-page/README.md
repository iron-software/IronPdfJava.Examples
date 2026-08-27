> Full guide: [PDF cover page](https://ironpdf.com/examples/pdf-cover-page/)

Iron Software's `PdfDocument.merge` function is designed to combine two PDF documents into one by appending the content of the second PDF behind the first.

When this function is executed, it seamlessly integrates all pages from PDF `b` right after the pages of PDF `a`.

Here's how programmers can effectively utilize this functionality to append cover pages to existing PDF documents. Start by generating your desired cover page using `PdfDocument.renderHtmlAsPdf` or by loading an already existing one with `PdfDocument.fromFile`. Next, you'll need to prepare or retrieve the main PDF document to which the cover page will be attached. Execute `PdfDocument.merge` to fuse the cover page and the main document, ensuring the cover page is passed as the initial argument, followed by the main document.

In the given example, there's an implementation of `setFirstPageNumber` within the `ChromePdfRenderOptions` object, setting it to Page 2. This adjustment helps realign the numbering of pages in the PDF after adding a cover page, applicable only for PDFs created dynamically. For pre-existing PDFs, any modifications to page numbers should be managed before merging.

Additionally, developers have the option to prepend a cover page using the `PdfDocument.prependPdf` method.

[Learn more about the PdfDocument.merge method](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#merge\(com.ironsoftware.ironpdf.PdfDocument,com.ironsoftware.ironpdf.PdfDocument\))