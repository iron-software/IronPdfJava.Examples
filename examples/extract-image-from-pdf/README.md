IronPDF, known for its robust suite of PDF creation and modification capabilities, also offers precise content extraction options from PDF documents.

The method `extractAllImages` retrieves all images embedded in a PDF, where each image is encapsulated as a `BufferedImage` object.

A typical business application for this function is the extraction and individual saving of images from PDF files. An illustrative code example provided earlier demonstrates how to achieve this using the `extractAllImages` method in conjunction with Java's `ImageIO` class.

Furthermore, IronPDF enables the extraction of images in their original byte format by utilizing the `extractAllRawImages` method.

Additionally, it is feasible to extract images from specific pages of a PDF instead of the entire document. The following code snippet illustrates the extraction of images from selected pages using the `extractAllImagesFromPages` method, specifically from pages 3 and 7 of a document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
List<BufferedImage> pageRangeImages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
```