IronPDF's `PdfDocument.merge` function seamlessly combines the content of one PDF into another.

```java
PdfDocument.merge(PdfDocument a, PdfDocument b);
```

Upon execution, `PdfDocument.merge` incorporates all the pages from PDF document B into PDF document A in a sequential manner.

The following code example illustrates how to append a cover page to an existing PDF document. Start by creating or loading a cover page using `PdfDocument.renderHtmlAsPdf`. Next, load the main PDF document. To merge them, call `PdfDocument.merge`, placing the cover page as the first parameter and the existing document as the second.

Notice the application of `setFirstPageNumber` to a `ChromePdfRenderOptions` object, setting it to Page 2, as shown in the 15th line of the example. This adjustment accounts for the additional cover page by altering the numbering of the ensuing pages in a PDF created from scratch. For pre-existing PDFs, adjustments to page numbers must be handled separately before merging.

Additionally, developers can prepend a cover page to a PDF document using the `<a href="https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#prependPdf(com.ironsoftware.ironpdf.PdfDocument)" target="_blank">PdfDocument.prependPdf</a>` method.

```java
PdfDocument.prependPdf(PdfDocument anotherPdfFile)
```
This method attaches another PDF file in front of the current PDF document, facilitating easy addition of cover pages or other preliminary content.