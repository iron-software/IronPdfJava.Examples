***Based on <https://ironpdf.com/examples/pdf-cover-page/>***

IronPDF's `PdfDocument.merge` method facilitates the appending of one PDF's content to another.

```java
PdfDocument.merge(PdfDocument firstPdf, PdfDocument secondPdf);
```

The `PdfDocument.merge` method, upon execution, will position all pages of the second PDF (`secondPdf`) after the pages of the first PDF (`firstPdf`).

The example below illustrates how to utilize this method for adding a cover page to an existing PDF document. Start by either creating a cover page using the `PdfDocument.renderHtmlAsPdf` or by loading an already created one with `PdfDocument.fromFile`. Subsequently, open (or generate) the main PDF document to be appended with the cover. Use `PdfDocument.merge`, providing the cover page as the first argument, and the main document as the second.

Note the implementation of `setFirstPageNumber` on the `ChromePdfRenderOptions` object, set to page 2 on line 15 in the given code snippet. This setup aids in updating the numbering of the pages to account for the newly added cover before merging. This adjustment is only tactible for on-the-fly generated documents; it's necessary to alter page numbers of pre-existing documents ahead of merging by alternative methods.

Furthermore, a cover page can be prepended to a PDF utilizing the [`PdfDocument.prependPdf` method](https://ironpdf.com/docs/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#prependPdf(com.ironsoftware.ironpdf.PdfDocument)).

```java
PdfDocument.prependPdf(PdfDocument anotherPdfFile)
```