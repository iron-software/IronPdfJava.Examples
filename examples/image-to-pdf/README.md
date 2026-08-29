> Full guide: [Image to PDF](https://ironpdf.com/examples/image-to-pdf/)

IronPDF provides developers with the functionality to consolidate multiple images into a single PDF document.

Using the `PdfDocument.fromImage` method, developers can input a collection of `Path` objects. Each `Path` should correspond to a legitimate image file on the local file system. This approach gives developers substantial flexibility in terms of how they gather their images, whether they're pulling images from multiple folders, selecting images based on specific naming conventions, or file types. For example, if all images originate from the same directory, one can employ a `DirectoryStream` along with other `java.nio.file` classes to efficiently compile a list of all images in that directory.

The `PdfDocument.fromImage` function will place each image from the list on its own separate page within the resulting PDF document.

If there's a requirement to distribute the images across multiple PDF files, rather than amalgamating them into one, developers can take one of two approaches:

1. Repeatedly invoke `PdfDocument.fromImage`, each time with a list containing only one `Path` object.
2. Assemble all images into a single PDF document as described earlier, and subsequently utilize the `PdfDocument.copyPage` method to replicate each page into separate PDF documents.

[Learn to Convert PDFs to Images in Java](https://ironpdf.com/java/how-to/java-pdf-to-image-tutorial/){.code_content__related-link__doc-cta-link}