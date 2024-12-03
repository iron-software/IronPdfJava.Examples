
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.security.PdfPrintSecurity;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

// Open an encrypted file (or create a new one from HTML)
PdfDocument pdf = PdfDocument.fromFile(Paths.get("assets/encrypted.pdf"), "password");

// Edit file metadata
MetadataManager metadata = pdf.getMetadata();
metadata.setAuthor("Satoshi Nakamoto");
metadata.setKeywords("SEO, Friendly");
metadata.setModifiedDate(new Date().toString());

// Edit file security settings
// The code below makes the PDF read only and disallows users to copy, paste, and print
SecurityOptions securityOptions = new SecurityOptions();
securityOptions.setAllowUserCopyPasteContent(false);
securityOptions.setAllowUserAnnotations(false);
securityOptions.setAllowUserPrinting(PdfPrintSecurity.FULL_PRINT_RIGHTS);
securityOptions.setAllowUserFormData(false);
securityOptions.setOwnerPassword("top-secret");
securityOptions.setUserPassword("sharable");

// Change or set the document encryption password
SecurityManager securityManager = pdf.getSecurity();
securityManager.removePasswordsAndEncryption();
securityManager.makePdfDocumentReadOnly("secret-key");


securityManager.setSecurityOptions(securityOptions);
pdf.saveAs(Paths.get("assets/secured.pdf"));