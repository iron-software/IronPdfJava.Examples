***Based on <https://ironpdf.com/examples/extract-image-from-pdf/>***

IronPDF, a part of Iron Software's robust suite of tools for PDF manipulation, offers detailed capabilities for processing the content within a PDF, including advanced content extraction methods.

The method `extractAllImages` retrieves a list of all the images contained within a PDF, presenting each as a `BufferedImage` object.

A prevalent practical application is the extraction and individual storage of images from PDF documents. Demonstrated in the code example above, this can be achieved using the `extractAllImages` method in conjunction with the Java `ImageIO` class.

For those needing images in their elemental byte format, IronPDF provides the `extractAllRawImages` method.

Moreover, IronPDF supports extracting images from specific pages rather than the entire PDF. The following simple code snippet illustrates using the `extractAllImagesFromPages` method to extract images from pages 3 and 5 of a test document:

```java
PdfDocument document = PdfDocument.fromFile(Paths.get("sample.pdf"));  
List<BufferedImage> imagesFromSelectedPages = document.extractAllImagesFromPages(PageSelection.pageRange(3, 7));
```