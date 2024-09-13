IronPDF for Java provides capabilities to adjust page orientation in both newly created and existing PDF documents.

By default, new PDFs generated with IronPDF are formatted in portrait orientation. However, developers can customize this setting by employing a `ChromePdfRenderOptions` instance during the content-to-PDF conversion process, which may involve HTML, RTFs, or URLs. The method `setPaperOrientation` within this instance can be used to specify the desired `PaperOrientation`. For example, the code snippet from lines 21 to 23 shows how to set the document in landscape orientation using `setPaperOrientation(PaperOrientation.LANDSCAPE)`. To revert to a portrait orientation, simply swap this value for `PaperOrientation.PORTRAIT`, which would then format the PDF in portrait mode when rendering the IronPDF home page through `PdfDocument.renderUrlAsPdf`.

For altering the orientation of existing PDFs—these being either earlier conversions or files loaded via `PdfDocument.fromFile`—`ChromePdfRenderOptions` is not applicable. Instead, IronPDF provides methods like `rotateAllPages` for such transformations. This function leverages the `PageRotation` enum to apply the desired rotation to all pages within a document. As demonstrated on line 40 of the code snippet, applying a 270-degree clockwise rotation affects every page. For targeted rotation of specific pages, the method `rotatePage` substitutes `rotateAllPages`. Here's how it can be applied:

```java
existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.firstPage()); // Rotate the first page by 270 degrees clockwise
existingPdf.rotatePage(PageRotation.CLOCKWISE_180, PageSelection.lastPage());  // Rotate the last page by 180 degrees clockwise
existingPdf.rotatePage(PageRotation.CLOCKWISE_90, PageSelection.singlePage(8)); // Rotate the 9th page by 90 degrees clockwise
existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.pageRange(9, 14)); // Rotate pages 10 to 15 by 270 degrees clockwise
```

This modified code and explanations present how developers can effectively manipulate the orientation and rotation of pages within their PDF documents using IronPDF's comprehensive Java library.