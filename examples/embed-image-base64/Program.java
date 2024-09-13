
using IronPdf;
using System.IO;
using System.Drawing;

var Renderer = new IronPdf.ChromePdfRenderer();

// Example 1: From an Image File or Bytes

var pngBinaryData = File.ReadAllBytes("use your image here");
var base64bytes = new byte[3]; // Use your own here
var ImgDataURI = @"data:image/png;base64," + Convert.ToBase64String(base64bytes);
var ImgHtml = $"<img src='{ImgDataURI}'>";

var pdfdoc = Renderer.RenderHtmlAsPdf(ImgHtml);
pdfdoc.SaveAs("embeded_example_1.pdf");


// Example 2: From a System.Drawing.Bitmap
System.Drawing.Bitmap MyImage = new Bitmap("use your image here");

string DataURI = IronPdf.Imaging.ImageUtilities.ImageToDataUri(MyImage);
var Data = $"<img src='{DataURI}'>";
var pdfdoc2 = Renderer.RenderHtmlAsPdf(Data);
pdfdoc2.SaveAs("embeded_example_2.pdf");