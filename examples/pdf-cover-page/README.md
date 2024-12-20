***Based on <https://ironpdf.com/examples/pdf-cover-page/>***

The `PdfDocument.merge` method from IronPDF allows you to append the content of one PDF document to another.

```java
PdfDocument.merge(PdfDocument a, PdfDocument b);
```

When executed, this method incorporates all pages from PDF document b at the end of the pages in PDF document a.

Below is an example that illustrates how developers might leverage this method to append cover pages to existing PDF documents. First, generate your cover page using `PdfDocument.renderHtmlAsPdf` or obtain an already prepared one with `PdfDocument.fromFile`. Next, acquire (or generate) the main PDF document where the cover needs to be added and use `PdfDocument.merge` to merge them, placing the cover page as the initial document in the merge call.

It’s important to adjust the page numbering for documents generated this way, as seen with the `setFirstPageNumber` method applied to a `ChromePdfRenderOptions` instance, setting it to Page 2 on the 15th line of the sample code. This modification is crucial for the document’s pagination to accurately reflect the added cover page. Keep in mind, this adjustment is only possible for documents created on-the-fly; existing documents will need their page numbers modified beforehand through other techniques.

Alternatively, a cover page can be prepended to a PDF using the [`PdfDocument.prependPdf` method](https://ironpdf.com/docs/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#prependPdf(com.ironsoftware.ironpdf.PdfDocument)).

```java
PdfDocument.prependPdf(PdfDocument anotherPdfFile)
```