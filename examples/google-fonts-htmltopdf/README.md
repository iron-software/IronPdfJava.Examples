> Full guide: [Google fonts htmltopdf](https://ironpdf.com/examples/google-fonts-htmltopdf/)

IronPDF delivers high-fidelity renderings of PDFs from HTML, including flawless depiction of custom web fonts and font icons from libraries like [Font Awesome](https://fontawesome.com/) and [Bootstrap Components](https://getbootstrap.com/docs/3.3/components/).

In addition, IronPDF extensively supports various custom WOFF and SVG CSS font packages, including those sourced from online type foundries like [Google Fonts](https://fonts.google.com/).

When converting a webpage featuring any of these-custom fonts into a PDF, it's crucial to ensure that IronPDF's HTML-to-PDF engine is given enough time to fully render these fonts. Developers can achieve this by adjusting the `renderDelay` attribute on the `ChromePdfRenderOptions`. Setting this property to a minimum of 500 milliseconds, using the `setRenderDelay` method, usually allows enough time for all font and icon assets to load completely before the conversion process. This process is illustrated in the example below.

It's important to be aware that web fonts are generally unsupported in Windows Apps running on Azure due to security policies.

[Learn to Set PDF Render Delay with IronPDF](https://ironpdf.com/java/object-reference/api/com/ironsoftware/ironpdf/render/ChromePdfRenderOptions.html#setRenderDelay(int))