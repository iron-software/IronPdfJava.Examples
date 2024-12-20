***Based on <https://ironpdf.com/examples/pdf-compression/>***

IronPDF offers functionality to optimize PDF file sizes by minimizing the dimensions of embedded images. Developers can leverage the `PdfDocument` class and its `compressImages` method to effectively reduce the PDF size, specifically when dealing with large images and graphics. This capability significantly saves on storage, expedites file transmission, and cuts associated costs when sharing PDFs via email or other media.

```java
PdfDocument compressImages(int quality);
```

The `compressImages` method takes an integer parameter between 0 and 100, representing the desired quality percentage of the images after compression. This approach mirrors the compression techniques used for lossy image formats such as JPEG. A parameter value of 100 means no quality loss—preserving images in their original form—whereas a lower value indicates a higher level of compression.

In a coding example from IronPDF's documentation on image compression, two distinct PDFs are generated from one source file but with differing quality settings for image compression. In the example, a lower quality setting (below 70, as shown in line 9 of the code example), results in significantly reduced image quality but also achieves much smaller file sizes. Conversely, a setting of 90% (as seen in line 14) maintains higher image quality but reduces file sizes to a lesser extent.

Determining the best quality setting involves a balance between file size and image clarity and may require some trial and error to optimize based on specific needs.