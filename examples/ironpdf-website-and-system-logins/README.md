***Based on <https://ironpdf.com/examples/ironpdf-website-and-system-logins/>***

When converting web pages that are behind HTML forms and password-protected directories to PDF, it's generally recommended to avoid using programmatic authentication and form submissions. Instead, it's more efficient to utilize the direct rendering of the markup from local files or HTML strings, as detailed in [the IronPDF login procedures resource page](https://ironpdf.com/how-to/logins/). Nevertheless, there are circumstances where it's challenging, time-consuming, or impractical to manually access the source code of the target web pages. In such cases, IronPDF facilitates the straightforward conversion of these restricted web pages into PDF files.

To transform web pages from password-protected directories into PDFs, you need to initialize a `ChromeHttpLoginCredentials` object with valid network credentials tailored for IronPDF's PDF Renderer. Subsequently, provide this `ChromeHttpLoginCredentials` object along with the URL of the password-protected page to the `PdfDocument.renderUrlAsPdf` method:

```java
// Converts a password-protected URL to a PDF file
PdfDocument.renderUrlAsPdf(restrictedUrl, loginCredentials).saveAs(Paths.get("output.pdf"));
```