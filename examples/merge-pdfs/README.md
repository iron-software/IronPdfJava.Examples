***Based on <https://ironpdf.com/examples/merge-pdfs/>***

IronPDF offers the ability to merge multiple PDF documents into a single file. This functionality is particularly useful for appending cover pages to existing PDFs or assembling various documents into a single file for easier printing and distribution.

The provided code example demonstrates how to utilize the `PdfDocument.merge` method to combine the contents of two `PdfDocument` instances, which are both generated from HTML content. The result is a new `PdfDocument` that incorporates the content from the second document appended to that of the first.

To merge more than three PDF documents, you should initialize a list with the `PdfDocument` instances and then use this list as a parameter in the `PdfDocument.merge` method:

```java
List<PdfDocument> pdfList = new ArrayList<>();
pdfList.add(pdfFirst);
pdfList.add(pdfSecond);
pdfList.add(pdfThird);
pdfList.add(pdfFourth);
PdfDocument combinedPDF = PdfDocument.merge(pdfList);
```

For additional resources and guidance on utilizing IronPDF, you can visit the [IronPDF Documentation](https://ironpdf.com/docs/).