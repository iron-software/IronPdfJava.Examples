IronPDF has capabilities to optimize PDF file sizes by compressing embedded images. To achieve this, developers can utilize the `PdfDocument` class's `compressImages` method. This functionality is particularly useful for efficiently managing storage and transmission costs when dealing with large images and graphics within PDFs.

```java
PdfDocument compressImages(int quality);
```

The `compressImages` method takes an integer parameter from 0 to 100, dictating the desired quality percentage of the compressed images. The functionality mirrors that of optimizing lossy image formats such as JPEG, where a quality setting of 100 maintains original image quality, and lower values degrade the quality to achieve smaller file sizes.

This tutorial showcases the use of the `compressImages` method by creating two different PDFs from a single source document, each with varying levels of image compression. The first example (see line 9) applies a low quality setting, substantially reducing the image quality but also significantly decreasing the file size. Conversely, the second example (see line 14) uses a higher quality setting of 90%, resulting in better image quality but less reduction in file size.

Selecting the right quality setting depends on individual needs and might require some trial to balance between acceptable image quality and minimal file size. Here's how you might implement differing quality levels in your code:

```java
// Compress images in the PDF to two different qualities
PdfDocument originalPdf = new PdfDocument("path/to/original.pdf");
PdfDocument lowQualityPdf = originalPdf.compressImages(30); // Much lower image quality
PdfDocument highQualityPdf = originalPdf.compressImages(90); // Higher image quality
```

This approach allows developers to tailor the compression based on the specific requirements of their applications, optimizing both the performance and costs associated with handling large PDF files.