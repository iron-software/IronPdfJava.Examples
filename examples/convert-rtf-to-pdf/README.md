***Based on <https://ironpdf.com/examples/convert-rtf-to-pdf/>***

Using IronPDF, transforming RTF (Rich Text Format) documents—which can include embedded images—into PDF files is straightforward and efficient.

To seamlessly convert rich-text content to PDF, utilize the `PdfDocument.renderRtfAsPdf` method. This powerful method enables the conversion of rich text content either directly from a string of raw data or from a file specified by a valid `Path` object or string path. After conversion, it produces a `PdfDocument` which can then be tailored further by the developer before persisting it to the system's storage with the `saveAs` method.

When converting raw rich-text strings to PDFs, ensure that the strings are correctly formatted. The `renderRtfAsPdf` method will generate an `IOException` if the string data is improperly formatted or contains elements that are not recognized, such as unusual symbols or tags.