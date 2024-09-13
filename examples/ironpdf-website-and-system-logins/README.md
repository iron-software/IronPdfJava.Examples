When aiming to transform web pages situated behind HTML forms or password-protected directories into PDF documents, the preferred approach is typically to bypass programmatic authentication and simply use local files or HTML strings for the task. More details about this can be found [here](https://ironpdf.com/how-to/logins/). Nonetheless, there are scenarios where manually accessing the HTML source to convert it into a PDF file is too tedious or simply not possible. In such cases, IronPDF offers a seamless solution to generate PDFs from these restricted web pages.

To handle web pages within password-protected spaces, begin by establishing a set of genuine network credentials utilizing the `ChromeHttpLoginCredentials` object within IronPDF's toolkit. Then, connect these credentials together with the webpage's URL to the `PdfDocument.renderUrlAsPdf` method:

```java
// Create a PDF from a protected URL using predefined login credentials
PdfDocument.renderUrlAsPdf(protectedUrl, credentials).saveAs(Paths.get("secured-output.pdf"));
```