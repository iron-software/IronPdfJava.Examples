> Full guide: [Extract text and images](https://ironpdf.com/java/examples/extract-text-and-images/)

IronPDF offers a comprehensive suite of PDF creation and editing capabilities, including detailed methods for content extraction from PDF documents.

Every `PdfDocument` object includes the `extractAllText` method. This method returns a `String` containing the complete text from every page of the PDF document. In a similar manner, the `extractAllImages` method retrieves a collection of all images in a PDF, each represented as a `BufferedImage` object. For those needing image data in raw byte form, the `extractAllRawImages` method is available.

These methods make it easy to handle large-scale content extraction from PDFs that contain extensive content spread across many pages. The text and images extracted can be manipulated according to specific application needs, such as processing text line by line for intelligent system input or saving images as individual files, as shown in IronPDF's sample code for content extraction.

For scenarios where complete extraction of all text and images is unnecessary or inefficient, developers can use the `extractTextFromPage` and `extractAllImagesFromPages` methods. These methods offer more selective extraction and accept a `PageSelection` enum to specify extraction from a particular page or a group of pages.