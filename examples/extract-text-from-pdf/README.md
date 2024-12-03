***Based on <https://ironpdf.com/examples/extract-text-from-pdf/>***

IronPDF’s rich suite of PDF manipulation capabilities includes a feature that allows for detailed interaction with the content of your PDF files. This is possible through its robust content extraction functions.

Every `PdfDocument` instance is equipped with the `extractAllText` method. This method produces a `String` that encapsulates the sum of the textual content across all the pages in the document.

This function offers an efficient approach for bulk text extraction from multi-page PDF documents. For those instances where you need text from specific pages only, you can utilize the `extractTextFromPage` method.

Here's a concise example that illustrates how to retrieve text from the first page of a PDF:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));  
String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
```