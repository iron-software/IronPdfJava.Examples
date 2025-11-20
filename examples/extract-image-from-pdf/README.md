***Based on <https://ironpdf.com/examples/extract-image-from-pdf/>***

IronPDF provides an extensive suite of features for generating and manipulating PDF documents, including powerful options for extracting content from PDFs.

The `extractAllImages` method retrieves every image embedded in a PDF file, returning each as a `BufferedImage` object.

A frequent use case in many businesses involves saving images from PDF files as individual files. The following code example illustrates how to accomplish this using the `extractAllImages` method in combination with the Java `ImageIO` class.

Alternatively, IronPDF allows for the extraction of images directly in their raw byte format by using the `extractAllRawImages` method.

Moreover, it is feasible to extract images from specific pages within a PDF, instead of the whole document. The short code snippet below demonstrates using the `extractAllImagesFromPages` method to extract images from pages 3 and 7 of a sample PDF.

### Extracting Images from PDF using Java with IronPDF

1. [Install the IronPDF Java Library](https://ironpdf.com/java/download-modal)
2. Utilize the `extractAllImages` method to pull images from a PDF document
3. Loop through each image in the retrieved images collection
4. Use the `write` method in Java to save the extracted images
5. Ensure the extraction process does not modify the original PDF document

[Further explore the IronPDF Java API for Image Extraction](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html)