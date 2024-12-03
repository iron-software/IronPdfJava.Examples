***Based on <https://ironpdf.com/examples/pdf-cover-page/>***

The `PdfDocument.merge` function of IronPDF skillfully concatenates the contents of one PDF to another.

```java
PdfDocument.merge(PdfDocument firstPDF, PdfDocument secondPDF);
```

Upon execution, this function seamlessly integrates all pages of the second PDF (secondPDF) to the end of the first PDF (firstPDF).

The following example illustrates how to employ this function to append a cover page to an existing PDF document. Begin by creating the desired cover page using `PdfDocument.renderHtmlAsPdf`, or by loading an existing one with `PdfDocument.fromFile`. Next, load or create the main PDF document that requires the cover page. Utilize `PdfDocument.merge` by passing the cover page as the first parameter and the main document as the second.

Please note the implementation of `setFirstPageNumber` on a `ChromePdfRenderOptions` object, setting it to page 2 as seen in line 15 of the example. This adjustment modifies the page numbering of the resultant PDF document to accommodate the newly added cover page before the merger. Remember, this adjustment applies only to PDFs generated dynamically; for pre-existing PDF documents, you must change the page numbers before merging.

Additionally, a cover page can be attached at the beginning of a PDF document using the [`PdfDocument.prependPdf method`](https://ironpdf.com/docs/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#prependPdf(com.ironsoftware.ironpdf.PdfDocument)).

```java
PdfDocument.prependPdf(PdfDocument anotherPdfFile)
```