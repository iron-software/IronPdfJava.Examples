Using IronPDF, you can merge multiple PDF documents into a single file. This functionality is particularly useful for tasks such as adding cover pages to existing PDFs or compiling several related documents into one file, enhancing ease of printing and distribution.

In the given code snippet, the `PdfDocument.merge` method is employed to amalgamate the contents of two `PdfDocument` instances that have been created from HTML content. When called, this method generates a new `PdfDocument` by appending the second document to the first.

If you need to merge over three PDFs, start by initiating a `List` of `PdfDocument` objects. Subsequently, merge these documents into one by passing the list to the `PdfDocument.merge` method like this:

```java
List<PdfDocument> pdfDocuments = new ArrayList<>();
pdfDocuments.add(documentA);
pdfDocuments.add(documentB);
pdfDocuments.add(documentC);
pdfDocuments.add(documentD);
PdfDocument finalMergedDocument = PdfDocument.merge(pdfDocuments);
```

Here, each `PdfDocument` is added to the list `pdfDocuments`, and the entire list is then merged into a new `PdfDocument`, `finalMergedDocument`, using the static method `PdfDocument.merge`. This method effectively consolidates all PDF contents into a single document, making it a versatile tool for handling multiple PDF files programmatically.