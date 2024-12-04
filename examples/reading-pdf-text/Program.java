package ironpdfjava.ReadingPdfText;

import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            //Rendering PDF documents to Images or Thumbnails
            using IronPdf;
            using System.Drawing;
            
            // Extracting Image and Text content from Pdf Documents
            
            // open a 128 bit encrypted PDF
            var pdf = PdfDocument.FromFile("encrypted.pdf", "password");
            
            //Get all text to put in a search index
            string AllText = pdf.ExtractAllText();
            
            //Get all Images
            IEnumerable<System.Drawing.Image> AllImages = PDF.ExtractAllImages();
            
            //Or even find the precise text and images for each page in the document
            for (var index = 0; index < PDF.PageCount; index++)
            {
            	int PageNumber = index + 1;
            	string Text = pdf.ExtractTextFromPage(index);
            	IEnumerable<System.Drawing.Image> Images = PDF.ExtractImagesFromPage(index);
            	///...
            }
    }
}
