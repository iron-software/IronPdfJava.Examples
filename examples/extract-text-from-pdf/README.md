> Full guide: [Extract text from PDF](https://ironpdf.com/java/examples/extract-text-from-pdf/)

IronPDF offers a robust set of features aimed at both creating and editing PDF documents, including the capability to process the content of PDFs with detailed content extraction methods.

Each `PdfDocument` object includes the `extractAllText` method. This method returns a `String` that encapsulates all the text from every page of the PDF in question.

Utilizing this method is an effective approach for extracting text across an entire document, especially in the case of multi-page PDFs. For targeted extraction from specific pages, `extractTextFromPage` is the method you'll want to employ.

The example code snippet below demonstrates how to retrieve text from the first page of a PDF document.

<a href="https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/PdfDocument.html#extractAllText()" class="code_content__related-link__doc-cta-link">Learn more about the extractAllText Method in the IronPDF Java Documentation</a>