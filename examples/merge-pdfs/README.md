***Based on <https://ironpdf.com/examples/merge-pdfs/>***

IronPDF has the capability to consolidate the contents of several PDF files. This functionality is particularly useful for adding cover pages to existing or new PDF documents. Additionally, it can be used to compile multiple related documents into a single file, which simplifies the processes of printing and sharing.

In the preceding code example, the `PdfDocument.merge` method was employed on two `PdfDocument` instances, both of which were created from HTML sources. This method produces a new `PdfDocument` by attaching the content from the second document to the end of the first one.

To merge more than three PDFs, begin by creating a list that holds the `PdfDocument` instances you want to combine. Then, input this list into the `PdfDocument.merge` method as shown in the following code snippet:

```java
List<PdfDocument> pdfs = new ArrayList<>();
pdfs.add(pdfA);
pdfs.add(pdfB);
pdfs.add(pdfC);
pdfs.add(pdfD);
PdfDocument merged = PdfDocument.merge(pdfs); // Create a merged PDF document from all listed PDFs
```

For additional details on the functionalities of IronPDF, please visit the [IronPDF Documentation](https://ironpdf.com/docs/).