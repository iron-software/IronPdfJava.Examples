***Based on <https://ironpdf.com/examples/pdf-signatures/>***

Java developers have the capability to embed both electronic and digital signatures into PDF documents programmatically by leveraging IronPDF for Java's `Signature` and `SignatureManager` classes.

To apply digital signatures, first create an instance of the `Signature` class, specifying the path to a valid `.pfx` or `.p12` certificate and its corresponding password. Then, utilize the `signPdfWithSignature` method from the `SignatureManager` of the active PDF document to sign it with the specified certificate.

IronPDF also facilitates the addition of signature images, such as generated text images or scanned images of handwritten signatures. These images can be incorporated into a signature using the `addSignatureImage` method before the signing process of the PDF.

If you're looking to insert a handwritten signature on a PDF page, the [`HtmlStamper`](https://ironpdf.com/object-reference/api/IronPdf.Editing.HtmlStamper.html) class can be used. This class allows for the addition of HTML content, including text and images, to individual or multiple pages of a PDF document.

# How to Add a Digital Signature to a PDF Programmatically in Java

1. Begin by installing the IronPDF Java library to enable digital signing of PDFs.
2. Utilize the intuitive APIs provided by IronPDF to open existing PDFs or create new ones.
3. Instantiate a `Signature` object and detail its properties as needed.
4. Retrieve the `SignatureManager` by invoking the `getSignature` method on the current PDF.
5. Execute the `signPdfWithSignature` method within your `SignatureManager` instance to sign the PDF.