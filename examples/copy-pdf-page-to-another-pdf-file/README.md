***Based on <https://ironpdf.com/examples/copy-pdf-page-to-another-pdf-file/>***

### Convert HTML to PDF with IronPDF

IronPDF, a proficient .NET library, facilitates the conversion of HTML to PDF seamlessly. It supports various .NET versions including .NET 8, 7, 6, .NET Core, and .NET Framework, making it highly compatible across different environments.

Key features of IronPDF include:
- Generating PDF files from HTML, MVC, ASPX, and image sources
- Comprehensive capabilities to sign, edit, and read PDFs, boasting over 50 features
- Streamlined installation and deployment through NuGet

#### Installation
To integrate IronPDF into your project, execute:
```plaintext
PM> Install-Package IronPdf
```

#### Example of HTML to PDF Conversion
Below is a simple example to demonstrate converting HTML content to PDF using IronPDF:

```csharp
using IronPdf;

// Create a new PDF document
var Renderer = new ChromePdfRenderer();
var PDF = Renderer.RenderHtmlAsPdf("<h1>Your HTML content here</h1>");

// Save the generated PDF
PDF.SaveAs("result.pdf");
```

#### Advanced Features
IronPDF supports loading external HTML assets such as images, CSS, and JavaScript to ensure that the generated PDFs are detailed and precise. You can specify a base path to load these assets correctly:

```csharp
var Renderer = new ChromePdfRenderer();
Renderer.RenderingOptions.BaseUrl = new Uri(@"file:///C:/site/assets/");

var HtmlContent = "<img src='icons/iron.png'><h1>HTML with Assets</h1>";
var PDF = Renderer.RenderHtmlAsPdf(HtmlContent);
PDF.SaveAs("html-with-assets.pdf");
```

### Availability and Support
IronPDF is available for Windows, Linux, and MacOS, ensuring extensive environmental compatibility. Licensed under fair terms, IronSoftware provides dedicated support through various channels including email, which is accessible at [support@ironsoftware.com](mailto:support@ironsoftware.com).

For further inquiries and assistance, you can visit our official page at [www.ironpdf.com](https://www.ironpdf.com).

This guide represents a streamlined approach to integrate IronPDF into .NET projects for robust PDF generation and management .