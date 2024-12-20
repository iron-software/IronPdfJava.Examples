***Based on <https://ironpdf.com/examples/convert-rtf-to-pdf/>***

Using IronPDF, you can effortlessly transform your RTF (Rich Text Format) documents, even those containing images, into PDF files.

To convert rich-text content into PDF documents, utilize the `PdfDocument.renderRtfAsPdf` method. This method is capable of converting rich text content from both a raw string of data and an external file, which can be specified either as a valid `Path` object or a string path. It produces a `PdfDocument` which a developer can then modify as needed before ultimately storing it on the file system via the `saveAs` method.

When converting raw strings of rich-text data into PDFs, it is critical to ensure the string is correctly formatted. The `renderRtfAsPdf` method will raise an `IOException` if the string data is improperly formatted or contains elements (such as symbols or tags) that are not recognized.