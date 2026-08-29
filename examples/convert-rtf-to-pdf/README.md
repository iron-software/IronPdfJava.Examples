> Full guide: [Convert rtf to PDF](https://ironpdf.com/examples/convert-rtf-to-pdf/?utm_source=github)

With IronPDF, you're equipped to transform your Rich Text Format (RTF) documents, including those with embedded images, into PDF formats.

This conversion is facilitated through the `PdfDocument.renderRtfAsPdf` method, which accepts either an RTF string directly or a reference to an external file in the form of a `Path` or `String`. The outcome is a `PdfDocument` which can be customized and saved using the `saveAs(...)` method.

Ensure the RTF content is correctly formatted, as the `renderRtfAsPdf` method may generate an `IOException` when encountering formatting issues or elements that it does not recognize.

## Steps to Convert RTF to PDF in Java

1. Incorporate IronPDF into your project, for example, by adding it via Maven.
2. Apply the `renderRtfAsPdf` method for RTF strings or `renderRtfFileAsPdf` for file-based inputs.
3. Utilize `saveAs(...)` to store the PDF file that is generated.

[Learn more about rendering RTF files to PDFs in Java](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html?utm_source=github#renderRtfFileAsPdf(java.lang.String))