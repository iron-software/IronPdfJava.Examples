> Full guide: [PDF compression](https://ironpdf.com/examples/pdf-compression/?utm_source=github)

IronPDF offers a feature for reducing the file size of PDFs by compressing embedded images. Developers can utilize the `PdfDocument` class's `compressImages` method to decrease the file sizes of PDFs that contain large images and graphical elements, resulting in significant savings in storage, time, and costs involved in sharing PDFs over email and other communication mediums.

The `compressImages` method requires an integer input from 0 to 100, defining the desired quality level of the compressed images. This operation follows similar principles as those used for compressing lossy image formats such as JPEG. A setting of 100 maintains the original image quality, while lower settings reduce quality to achieve smaller file sizes.

In the IronPDF image compression tutorial, a practical example demonstrates the generation of two distinct PDFs from a single source PDF using varying levels of image compression. The first PDF is created using a low-quality setting below 70, resulting in significantly degraded image quality but much smaller file sizes. On the other hand, the second PDF uses a higher quality setting of 90%, which preserves better image quality, though the reduction in file size is less pronounced.

Determining the optimal quality setting for compression depends on individual needs and might require some trial and error to balance between acceptable image quality and file size reduction.

[Learn How to Compress PDFs in Java with IronPDF](https://ironpdf.com/java/how-to/compress-pdf-java-tutorial/?utm_source=github)