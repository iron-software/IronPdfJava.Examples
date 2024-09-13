

// Step 1. Create a PDF
PdfDocument pdf = PdfDocument.renderHtmlAsPdf("<h1>Testing 2048 bit digital security</h1>");

// Step 2. Create a Signature.
// You may create a .pfx or .p12 PDF signing certificate using Adobe Acrobat Reader.
// Read: https://helpx.adobe.com/acrobat/using/digital-ids.html
Signature signature = new Signature("Iron.pfx", "123456");

// Step 3. Optional signing options and a handwritten signature graphic
signature.setSigningContact("support@ironsoftware.com");
signature.setSigningLocation("Chicago, USA");
signature.setSigningReason("To show how to sign a PDF");
BufferedImage signatureImage = ImageIO.read(new File("handwriting.png"));
WritableRaster raster = signatureImage.getRaster();
DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
signature.setSignatureImage(data.getData());

// Step 4. Sign the PDF with the PdfSignature. Multiple signing certificates may be used
SignatureManager signatureManager = pdf.getSignature();
signatureManager.SignPdfWithSignature(signature);

// Step 5. The PDF is not signed until saved to file, stream or byte array.
pdf.saveAs("signed.pdf");