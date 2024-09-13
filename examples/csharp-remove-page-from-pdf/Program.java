
using IronPdf;

// 4 Page PDF Document
var html = @"<p> Hello Iron</p>
                <p> This is 1st Page </p>
                <div style = 'page-break-after: always;' ></div>
                <p> This is 2nd Page</p>
                <div style = 'page-break-after: always;' ></div>
                <p> This is 3rd Page</p>
                <div style = 'page-break-after: always;' ></div>
                <p> This is 4th Page</p>";


var Renderer = new IronPdf.ChromePdfRenderer();
var pdfdoc = Renderer.RenderHtmlAsPdf(html);

// Remove a pages 2 & 3.  Similar syntax to to Substring
pdfdoc.RemovePages(1, 2);

pdfdoc.SaveAs("Page1And4.pdf");
