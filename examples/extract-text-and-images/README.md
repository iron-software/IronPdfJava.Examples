***Based on <https://ironpdf.com/examples/extract-text-and-images/>***

IronPDF is renowned for its broad spectrum of capabilities in PDF generation and editing, and it also provides thorough content extraction functionalities.

Every `PdfDocument` object is equipped with the `extractAllText` method, which aggregates all the text from each page of a PDF into a single `String`. Additionally, `extractAllImages` is utilized to gather all images embedded in the document, each represented as a `BufferedImage` object. For those needing the images in their raw byte form, the method `extractAllRawImages` should be utilized.

These methods offer efficient document-level content extraction, particularly useful for lengthy PDFs that span numerous pages. Once extracted, the text and images can be further processed according to the specific requirements of your application, such as applying line-by-line text analysis with AI systems or storing each image separately. The following sample code illustrates how you can leverage IronPDF for content extraction:

If the necessity arises to extract content in a more selective manner—avoiding a blanket extraction—developers have the option of using `extractTextFromPage` and `extractAllImagesFromPages`. These functions accept a `PageSelection` parameter, allowing for precise content extraction from chosen pages.

Here is a concise code sample illustrating the extraction of text from the first page and images from pages 3 and 7 within a PDF document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
List<BufferedImage> pageRangeImages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
```