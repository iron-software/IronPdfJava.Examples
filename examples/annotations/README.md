> Full guide: [Annotations](https://ironpdf.com/examples/annotations/)

Leverage the `PdfDocument` object's `AnnotationManager` and the `AnnotationOptions` class from IronPDF to incorporate "sticky note"-style annotations on specific pages within a PDF document.

To insert a text-based annotation at a precise location on a page, utilize the coordinates (x, y) as parameters in the `AnnotationOptions` constructor, as demonstrated in the following code sample. Then, apply the `addTextAnnotation` method of the `AnnotationManager` to append the annotation to the targeted page in the current PDF document.

Each `AnnotationOptions` object provides methods that allow developers to tailor the annotation's appearance and functionality. For example, in the code sample provided, we adjust its opacity, select an icon, and make sure it is neither editable nor printable. Further customization options include altering the annotation's color, dimensions, and title, as well as its title, subject, content, and placement.

### How to Add an Annotation to a PDF Using Java

1. Install the IronPDF Java library to enable annotation capabilities in PDF documents.
2. Use the `PdfDocument` class to open an existing PDF file in Java.
3. Construct and personalize annotations using the `AnnotationOptions` class.
4. Implement `addTextAnnotation` from IronPDF to place annotations on predetermined pages of the PDF.
5. Save the modified PDF document with the annotations.

For additional guidance on initiating annotations in PDFs via IronPDF, access the [IronPDF Documentation](https://ironpdf.com/docs/).

[Discover more about AnnotationOptions on IronPDF Java Docs](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/annotation/AnnotationOptions.html)