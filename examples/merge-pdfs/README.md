***Based on <https://ironpdf.com/examples/merge-pdfs/>***

IronPDF facilitates the merging of multiple PDF files into a single document. This feature is particularly useful for adding cover pages to existing PDFs or creating a consolidated file that encapsulates various related documents. Such functionality is handy for streamlining the printing process or simplifying document transportation.

In the given example, the `PdfDocument.merge` method is employed to amalgamate two `PdfDocument` objects that originated from HTML content. The approach results in a new `PdfDocument` instance where the second document’s content is appended to the first.

Should there be a need to merge more than three PDFs, initiate this process by generating a list of `PdfDocument` objects. Following this, submit this list to the `PdfDocument.merge` method as a single parameter:

```java
List<PdfDocument> pdfs = new ArrayList<>();
pdfs.add(pdfA); // Add first PDF document
pdfs.add(pdfB); // Add second PDF document
pdfs.add(pdfC); // Add third PDF document
pdfs.add(pdfD); // Add fourth PDF document
PdfDocument merged = PdfDocument.merge(pdfs); // Merge all PDF documents into one
```

For additional insights into IronPDF's capabilities and usage, please visit the [IronPDF Documentation](https://ironpdf.com/docs/).