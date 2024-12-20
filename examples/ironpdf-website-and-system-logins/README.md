***Based on <https://ironpdf.com/examples/ironpdf-website-and-system-logins/>***

To turn web pages that are secured with HTML forms and password protections into PDF files, the recommended method is to bypass programmatic authentication and form submissions. Instead, use local files or HTML strings to render the content directly, as outlined on [IronPDF's login procedures resource page](https://ironpdf.com/how-to/logins/). However, if accessing the source code of the web pages you wish to convert is difficult, time-consuming, or simply not possible, IronPDF offers a straightforward and efficient solution for generating PDFs from these protected areas.

When you need to process web pages from password-protected directories, create a `ChromeHttpLoginCredentials` instance filled with valid network credentials that IronPDF's PDF renderer will use. Here's how you can assign this object to a URL for PDF conversion:

```java
// Create a PDF from a URL using login credentials
PdfDocument.renderUrlAsPdf(restrictedUrl, loginCredentials).saveAs(Paths.get("secured-output.pdf"));
```