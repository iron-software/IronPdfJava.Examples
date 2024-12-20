***Based on <https://ironpdf.com/examples/extract-text-and-images/>***

IronPDF's robust suite of PDF creation and editing tools includes powerful content extraction functionalities, which allow for detailed handling of the contents within a PDF document.

Within all `PdfDocument` instances, the `extractAllText` method is provided. This method returns a `String` containing all the text from each page of the PDF document. For image extraction, the `extractAllImages` method is employed; it compiles a collection of all embedded images in the PDF, each represented as a `BufferedImage` object. To gather images in their raw byte format, the `extractAllRawImages` method is the appropriate choice.

These functions are invaluable for efficiently extracting large volumes of content from extensive documents, spanning dozens or even hundreds of pages. The extracted text and images can then be manipulated according to specific application requirements, such as analyzing text line-by-line with advanced algorithms or independently storing each image in separate files. An example illustrating these content extraction capabilities provided by IronPDF is shown below.

For scenarios where comprehensive extraction of all text and images is excessive or unnecessary, developers can utilize more selective methods like `extractTextFromPage` and `extractAllImagesFromPages`. These methods offer the flexibility of extracting content from specific pages, accepting a parameter of type `PageSelection` that can specify single or multiple pages.

Below is a simple code snippet illustrating the extraction of text from the initial page and images from specified pages in a PDF document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
String firstPageText = document.extractTextFromPage(PageSelection.firstPage());
List<BufferedImage> pageRangeImages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
```

This example demonstrates how effortless it is to retrieve text and images from predetermined pages using IronPDF's targeted extraction methods.