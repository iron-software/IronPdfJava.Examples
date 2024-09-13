

PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://unsplash.com/");
String text = pdf.extractAllText();
System.out.println("Text extracted from the website: " + text);