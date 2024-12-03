***Based on <https://ironpdf.com/examples/pdf-page-orientation/>***

IronPDF for Java offers functionality to change the page orientation of both new and existing PDF files.

When generating new PDFs using IronPDF, they default to a portrait orientation. However, developers can alter this orientation by employing the `ChromePdfRenderOptions` during the PDF creation process. This is achieved using HTML, RTF, URL content, and more. By utilizing the `setPaperOrientation` method and passing it a `PaperOrientation` value, the orientation of the resultant PDF can be modified as needed. An example in the code demonstrates this process from lines 21 to 23, where a PDF document is created in landscape orientation. By using `setPaperOrientation(PaperOrientation.LANDSCAPE)` on line 21, the landscape mode is activated. Alternatively, using `PaperOrientation.PORTRAIT` in this setup would generate the PDF of the [IronPDF homepage](https://ironpdf.com) in portrait mode.

For changing the orientation of existing PDF documents, such as those returned from previous rendering operations or loaded through `PdfDocument.fromFile`, `ChromePdfRenderOptions` is not applicable. Instead, IronPDF provides the `rotateAllPages` method for applying rotation-based transformations to adjust the orientation.

The `rotateAllPages` function takes a `PageRotation` enum, offering predefined rotation values. For example, line 40 in another code snippet provided rotates every page of a PDF document 270 degrees clockwise. If selective page rotation is needed, instead of rotating all pages, the `rotatePage` method should be utilized.

The following refined Java code demonstrates the selective page rotation:

```java
existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.firstPage());  // Rotate the first page 270 degrees clockwise
existingPdf.rotatePage(PageRotation.CLOCKWISE_180, PageSelection.lastPage());  // Rotate the last page 180 degrees clockwise
existingPdf.rotatePage(PageRotation.CLOCKWISE_90, PageSelection.singlePage(8)); // Rotate page 9 ninety degrees clockwise
existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.pageRange(9, 14)); // Rotate pages 10 to 15, 270 degrees clockwise
```