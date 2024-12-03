# Transforming HTML to PDF Using IronPDF

***Based on <https://ironpdf.com/how-to/java-print-pdf-tutorial/>***


IronPDF is a comprehensive library for .NET developers facilitating the conversion of HTML to PDF. This process is robust and can be implemented swiftly using C#. Here’s how you can perform this conversion:

## Installation

First, ensure that IronPDF is part of your project. You can easily add it via NuGet package manager with:

```plaintext
PM> Install-Package IronPdf
```

## Using IronPDF in Your Code

To use IronPDF, include the IronPdf namespace in your class:

```csharp
using IronPdf;
```

Then, create an instance of the `HtmlToPdf` object which provides numerous methods for PDF generation:

```csharp
var renderer = new HtmlToPdf();
```

You can directly convert plain HTML strings or URLs to PDF. Here’s how you generate a PDF from an HTML string and save it:

```csharp
var pdfDocument = renderer.RenderHtmlAsPdf("<h1>Your HTML content here</h1>");
pdfDocument.SaveAs("html-string-output.pdf");
```

### Conversion with Advanced Features

IronPDF supports a full range of HTML, CSS, JavaScript, and image assets, making your PDF look like your HTML source. For instance, if your HTML relies on external stylesheets, images, or scripts, define the base path as shown:

```csharp
renderer.RenderingOptions.BaseUrl = new Uri("http://your-assets-path.com");
```

Below is an example demonstrating how to convert an HTML file while ensuring external resources are correctly loaded:

```csharp
var pdfWithAssets = renderer.RenderHtmlAsPdf(@"
    <h1 style='color: blue;'>Hello, World!</h1>
    <img src='assets/logo.png' alt='Company Logo'>
", new Uri("https://www.ironsoftware.com/assets/"));
pdfWithAssets.SaveAs("pdf-with-external-assets.pdf");
```

## Output

The output will be a perfectly formatted PDF file saved to your specified path. You can open and review the PDF to see the quality and accuracy of the rendering.

## Conclusion

IronPDF offers a simple yet powerful solution for generating PDF files from HTML content in .NET applications, supporting all modern HTML5, CSS3, and JavaScript features. This makes it ideal for report generation, invoices, contracts, and other documents directly from web pages or HTML codes.

For more information and detailed documentation, visit the IronPDF website at [IronPDF Official](https://ironpdf.com/).