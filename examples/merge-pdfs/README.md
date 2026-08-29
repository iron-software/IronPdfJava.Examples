> Full guide: [Merge PDFs](https://ironpdf.com/examples/merge-pdfs/)

IronPDF offers the capability to amalgamate the contents of various PDF files. This function is especially useful for adding cover pages to new or existing PDFs. It also facilitates the consolidation of pertinent documents into a single file, which simplifies both printing and distribution.

In the provided code sample, the `PdfDocument.merge` method is applied to two `PdfDocument` instances, both generated from HTML content. The outcome is a newly created `PdfDocument` in which the contents of the second `PdfDocument` are affixed to the conclusion of the first.

For merging more than three PDF documents, initiate by forming a list that encompasses the necessary `PdfDocument` objects. Subsequently, submit this list to the `PdfDocument.merge` method as a singular argument:

[Explore the PdfDocument.merge Method Documentation.](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#merge(java.util.List))