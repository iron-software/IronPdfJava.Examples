***Based on <https://ironpdf.com/examples/pdf-compression/>***

IronPDF offers a feature to decrease the PDF file sizes by compressing embedded images through the `PdfDocument` class's `compressImages` method. This technique is particularly beneficial for reducing the space needed on storage devices and minimizing data transfer costs when sending PDFs over email or other data transmission modes.

```java
PdfDocument compressImages(int quality);
```

The `compressImages` method takes an integer parameter, ranging from 0 to 100, specifying the preferred quality percentage for the embedded images. This method works under principles similar to those used in optimizing JPEG files where a value of 100 implies no quality loss, preserving the images in their original state. Conversely, lower values mean a greater reduction in image quality.

An example from the IronPDF image compression tutorial showcases the creation of two PDFs from a single source file by employing varying degrees of image compression. For instance, a compression setting of less than 70 (see line 9) will typically result in a PDF with significantly reduced image quality but notably smaller file size. On the other hand, a setting of 90, as used on line 14, produces a PDF where the image quality is higher, but the reduction in file size is less drastic.

Determining the optimal quality setting demands some trials, as the best value depends on balancing the necessity for acceptable image quality against the need for file size reduction. Adjusting this setting allows developers to tailor the compression to fit specific needs and constraints.