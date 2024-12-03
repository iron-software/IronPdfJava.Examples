***Based on <https://ironpdf.com/examples/extract-image-from-pdf/>***

IronPDF, a well-rounded library within Iron Software's suite, offers a comprehensive selection of tools for creating and editing PDF files, including advanced content extraction capabilities.

One such functionality is the `extractAllImages` method, which gathers all images embedded within a PDF and outputs each as a `BufferedImage` object.

This method is predominantly used in business scenarios where there is a need to store images from a PDF document into individual files. An example provided previously illustrates how to implement this by utilizing the `extractAllImages` method in conjunction with the Java `ImageIO` class.

Additionally, IronPDF supports extraction of images in their original byte format using the `extractAllRawImages` method.

For scenarios where image extraction is required from specific pages rather than the entire document, IronPDF provides the `extractAllImagesFromPages` method. The example below demonstrates fetching images from pages 3 and 7 of a sample PDF document.

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));
List<BufferedImage> pageRangeImages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
```

In this code snippet, the `PageSelection.pageRange(3, 7)` function specifies the range of pages from which images are to be extracted, illustrating IronPDF's capability to target specific sections of a PDF document.