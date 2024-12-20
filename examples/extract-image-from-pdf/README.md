***Based on <https://ironpdf.com/examples/extract-image-from-pdf/>***

IronPDF provides an extensive toolkit for creating and editing PDF documents, including specific capabilities for detailed content manipulation within PDFs. Notably, IronPDF offers methods that allow for the extraction of various document content.

The method `extractAllImages` retrieves a collection of images embedded within a PDF, each as a `BufferedImage` object. This function is especially useful for cases where you need to separate images from a PDF and store them as individual files. The code example provided illustrates this by using the `extractAllImages` method in conjunction with the Java `ImageIO` class to facilitate this action.

In addition to its capability to manage images directly in their embedded format, IronPDF supports extracting images in their original byte format through the `extractAllRawImages` function. This can be particularly useful for applications that require image data in byte form for further processing or storage.

IronPDF is also versatile enough to handle image extraction from selected pages of a PDF rather than the entire document. For instance, the following Java code snippet demonstrates how to extract images specifically from pages 3 and 7 of a PDF:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
List<BufferedImage> pageRangeImages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
```

This method, `extractAllImagesFromPages`, allows developers to specify which pages to process, optimizing performance and targeting specific document sections.