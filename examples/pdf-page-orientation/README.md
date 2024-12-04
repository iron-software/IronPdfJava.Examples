***Based on <https://ironpdf.com/examples/pdf-page-orientation/>***

IronPDF for Java provides functionalities for modifying the page orientation of both new and existing PDF documents.

By default, new PDF documents created with IronPDF are set to a portrait orientation. This setting can be changed by leveraging a `ChromePdfRenderOptions` instance when converting various content formats such as HTML, RTFs, or URLs into PDFs. The `setPaperOrientation` method within this instance accepts a `PaperOrientation` value, allowing developers to customize the page orientation of the resulting PDFs to meet their requirements. For instance, within the provided code snippet (lines 21 to 23), the document is configured to have a landscape orientation by using `setPaperOrientation(PaperOrientation.LANDSCAPE)` on line 21. Changing this to `PaperOrientation.PORTRAIT` would instead render the [IronPDF homepage](https://ironpdf.com) in portrait orientation.

However, `ChromePdfRenderOptions` cannot modify the orientation of existing PDF documents (such as those generated previously or loaded via `PdfDocument.fromFile`). Instead, the orientation of these documents can be adjusted through rotation-based transformations provided by IronPDF. The `rotateAllPages` function is particularly useful, accepting a `PageRotation` enum that defines possible rotation angles. In the code example provided, line 40 demonstrates how each page of a selected PDF can be rotated clockwise by 270 degrees. For scenarios where only specific pages need rotation, the `rotatePage` method should be used instead of `rotateAllPages`.

```java
existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.firstPage());  
existingPdf.rotatePage(PageRotation.CLOCKWISE_180, PageSelection.lastPage());  
existingPdf.rotatePage(PageRotation.CLOCKWISE_90, PageSelection.singlePage(8)); // Rotates the 9th page  
existingPdf.rotatePage(PageRotation.CLOCKWISE_270, PageSelection.pageRange(9, 14)); // Rotates pages 10 to 15
```