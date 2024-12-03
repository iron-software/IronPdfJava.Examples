***Based on <https://ironpdf.com/examples/pdf-signatures/>***

Java developers can now effortlessly integrate electronic and digital signatures into PDF documents using the Signature and `SignatureManager` classes in IronPDF for Java.

To implement digital signatures, begin by creating a new instance of the `Signature` class, specifying the paths to a `.pfx` or `.p12` certificate file and providing the associated password. Then, utilize the `signPdfWithSignature` method from the `SignatureManager` associated with the target PDF document to apply the digital signature.

IronPDF extends its functionality to include signature images, such as auto-generated text visuals or scanned versions of manual signatures. Incorporate such images by employing the `addSignatureImage` method before executing the final document signing process.

If there’s a need to append a manual signature to a PDF, the [`HtmlStamper`](https://ironpdf.com/object-reference/api/IronPdf.Editing.HtmlStamper.html) class can be used. This feature allows the addition of HTML content, including text and images, to designated pages within the PDF.

# How to add a digital signature to a PDF using Java

1. Begin by installing the IronPDF Java library, equipping your application with the capability to insert a digital signature into a PDF.
2. Engage with user-friendly APIs to either load an existing PDF or generate a new one.
3. Initiate a `Signature` object and meticulously customize its details.
4. Fetch the `SignatureManager` using the `getSignature` method from your PDF object.
5. Execute the digital signing by calling the `signPdfWithSignature` method from the `SignatureManager` instance.