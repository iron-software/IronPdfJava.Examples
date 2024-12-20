***Based on <https://ironpdf.com/examples/extract-text-from-pdf/>***

IronPDF boasts an array of PDF creation and manipulation capabilities, including advanced content extraction functions for detailed handling of PDF documents.

Within every instance of the `PdfDocument` object, there is an accessible method called `extractAllText`. This method retrieves all text from each page of the PDF and returns it as a single `String`.

This functionality allows for efficient extraction of text at a document-wide level, particularly useful for PDFs that comprise multiple pages. For more targeted text extraction—such as pulling text from specific pages—the `extractTextFromPage` method is the ideal tool.

Below is a simple example that demonstrates extracting text from the initial page of a PDF document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
```