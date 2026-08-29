> Full guide: [PDF signatures](https://ironpdf.com/java/examples/pdf-signatures/?utm_source=github)

Java programmers can embed both electronic and digital signatures into PDF documents using IronPDF for Java, using the `Signature` and `SignatureManager` classes.

To apply digital signatures, you should initiate a new instance of the `Signature` class, specifying the path to a valid `.pfx` or `.p12` certificate file and its associated password. Subsequently, utilize the `signPdfWithSignature` function of the `SignatureManager` associated with the target PDF document to implement the digital signature.

IronPDF also facilitates the embedding of signature images, such as electronically generated text or scanned handwritten signatures. Implement this by using the `addSignatureImage` method before signing the document.

If your requirement is to append a handwritten signature onto a PDF page, turn to the [`HtmlStamper`](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/stamp/HtmlStamper.html?utm_source=github) class. This tool allows for adding HTML content, including text and images, to one or several pages within a PDF file.

## Steps to Programmatically Add a Digital Signature to a PDF in Java

1. First, install the IronPDF Java library to gain the functionality necessary for digital signatures on PDFs.
2. Employ the user-friendly APIs to either load an existing PDF or to create a new one from scratch.
3. Instantiate a `Signature` object and configure its detailed settings.
4. Retrieve a `SignatureManager` by invoking the `getSignature` method on your PDF object.
5. Finally, secure the PDF document by signing it with the `signPdfWithSignature` method available in the `SignatureManager`.

[Discover more about the Signature Class for Java Digital Signatures](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/signature/Signature.html?utm_source=github)