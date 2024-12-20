***Based on <https://ironpdf.com/examples/google-fonts-htmltopdf/>***

IronPDF impeccably translates HTML documents into PDFs, capturing even the fine details of custom web fonts like those available from [Font Awesome](https://fontawesome.com/) and [Bootstrap Components](https://getbootstrap.com/docs/3.3/components/).

Additionally, IronPDF fully supports WOFF and SVG CSS font packages from a variety of sources, including prestigious online type foundries such as [Google Fonts](https://fonts.google.com/).

For developers looking to accurately convert web pages that incorporate custom fonts into PDFs, it’s crucial to appropriately set a rendering delay within IronPDF's HTML-to-PDF conversion engine. This can be achieved by adjusting the `renderDelay` property on a `ChromePdfRenderOptions` object. Setting this value to at least 500 milliseconds — or half a second — using the `setRenderDelay` method typically allows enough time for all custom fonts and icons to load completely prior to their conversion into a PDF format.

It’s important to be aware, though, that due to security constraints, web fonts are not supported on Windows Apps that are hosted on Azure.