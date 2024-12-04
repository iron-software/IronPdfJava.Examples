***Based on <https://ironpdf.com/examples/extract-text-from-pdf/>***

IronPDF boasts a robust suite of capabilities for creating and editing PDFs, including powerful content extraction tools.

Each `PdfDocument` object includes the method `extractAllText`. This method produces a `String` that contains the text from every page of the PDF document.

This functionality is especially useful for extracting text from PDF files that span multiple pages. For extracting text specifically from certain pages, one should use the `extractTextFromPage` method.

Below is a simple code example that demonstrates how to retrieve text from the first page of a PDF document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
```