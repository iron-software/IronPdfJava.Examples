***Based on <https://ironpdf.com/examples/pdf-compression/>***

IronPDF offers a feature that allows reduction in PDF file size by compressing embedded images within the document. This functionality is accessible through the `PdfDocument` class's `compressImages` method, effectively reducing the PDF size. This is particularly useful for storing and transmitting large PDFs through email and other digital methods, saving both time and costs.

```java
PdfDocument compressImages(int quality);
```

The `compressImages` method requires an integer parameter between 0 and 100, representing the desired quality percentage of the embedded images. This operates in a manner akin to adjusting file sizes in lossy image formats, such as JPEG. Specifically, a quality value of 100 maintains the original image quality with no loss, while lower values correspond to diminished quality levels.

As demonstrated in the IronPDF guide on image compression, the example below employs the method to generate two versions of a PDF from the same source file, each with varying levels of image compression. On line 9, image compression is set low, substantially degrading image quality for a significant reduction in file size. Conversely, line 14 sets the compression to a higher quality level (90%), resulting in better image quality but less reduction in file size.

The optimal compression settings may need to be fine-tuned according to specific user needs, requiring some trials to achieve a balance between file size and image quality that's suitable for their purposes.