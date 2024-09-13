
using IronPdf;

var html_a = @"<p> [PDF_A] </p>
                <p> [PDF_A] 1st Page </p>
                <div style = 'page-break-after: always;' ></div>
                <p> [PDF_A] 2nd Page</p>";

var html_b = @"<p> [PDF_B] </p>
                <p> [PDF_B] 1st Page </p>
                <div style = 'page-break-after: always;' ></div>
                <p> [PDF_B] 2nd Page</p>";

var Renderer = new IronPdf.ChromePdfRenderer();

// our main document
var pdfdoc_a = Renderer.RenderHtmlAsPdf(html_a);


// create and select a page to copy
var pdfdoc_b = Renderer.RenderHtmlAsPdf(html_b);
var page_to_insert = pdfdoc_b.CopyPage(1);

//3 ways to insert:

pdfdoc_a.AppendPdf(page_to_insert); // at the end
									// or
pdfdoc_a.PrependPdf(page_to_insert); // at the start
									 // or
pdfdoc_a.InsertPdf(page_to_insert, 1); // in the middle

pdfdoc_a.SaveAs("CopiedPages.pdf");
