
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using IronPdf;

// Instantiate Renderer
var Renderer = new IronPdf.ChromePdfRenderer();

var htmls = new List<string>() { "<h1>Html#1</h1>", "<h1>Html#2</h1>", "<h1>Html#3</h1>" };

Parallel.ForEach(htmls, (html) =>
{
    var pdfDocument = Renderer.RenderHtmlAsPdf(html).Result;
    // do something with each pdfDocument
});