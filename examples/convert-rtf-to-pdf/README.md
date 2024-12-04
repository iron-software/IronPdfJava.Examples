***Based on <https://ironpdf.com/examples/convert-rtf-to-pdf/>***

IronPDF provides a robust solution for transforming RTF (Rich Text Format) documents, including those with embedded images, into PDF files.

To convert rich-text to PDF, you can utilize the `PdfDocument.renderRtfAsPdf` method. This function is capable of processing rich text content from both a raw data string and an external file, which can be referenced either through a `Path` object or a simple file path string. This method yields a `PdfDocument` instance which developers can further manipulate before ultimately saving it to the filesystem using the `saveAs` method.

When converting from raw rich-text strings to PDF format, ensure the string is correctly formatted. If the input string data is improperly formatted or contains unrecognized elements like unusual symbols or tags, `renderRtfAsPdf` will result in an `IOException`.