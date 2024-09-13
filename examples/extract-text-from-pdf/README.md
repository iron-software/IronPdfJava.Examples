IronPDF, a cornerstone in PDF manipulation, offers a wide array of functionalities for both creating and editing PDF files. Among these, it provides detailed content extraction capabilities.

A feature particularly useful found within every `PdfDocument` instance is the `extractAllText` method. This method returns a `String` comprising all the text from each page of the PDF, enabling a comprehensive gathering of data across the entire document.

For those requiring text extraction from specific pages rather than the entire document, the `extractTextFromPage` method is the optimal choice. This allows for targeted extraction, enhancing flexibility when working with multi-page PDFs.

The following example demonstrates how to retrieve text from the first page of a PDF document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));  
String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
```

This succinct snippet illustrates the process of using IronPDF to extract text from a particular page, emphasizing the library’s ease of use and effectiveness in handling PDF content.