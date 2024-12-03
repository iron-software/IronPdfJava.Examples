

String html = "<p> Hello Iron </p>"
    + "<p> This is 1st Page </p>"
    + "<div style = 'page-break-after: always;' ></div>"
    + "<p> This is 2nd Page</p>"
    + "<div style = 'page-break-after: always;' ></div>"
    + "<p> This is 3rd Page</p>";
PdfDocument pdf = PdfDocument.renderHtmlAsPdf(html);

// take the first page
PdfDocument page1doc = pdf.copyPage(0);
page1doc.saveAs("Split1.pdf");

// take the pages 2 & 3
var page23doc = pdf.copyPages(1, 2);
page23doc.saveAs("Split2.pdf");