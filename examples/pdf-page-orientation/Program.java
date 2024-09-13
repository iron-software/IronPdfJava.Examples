
import com.ironsoftware.ironpdf.PdfDocument;  
import com.ironsoftware.ironpdf.edit.PageSelection;  
import com.ironsoftware.ironpdf.page.PageRotation;  
import com.ironsoftware.ironpdf.render.*;  
import java.io.IOException;  
import java.nio.file.Paths;

// Use the setPaperOrientation method to set rendered PDFs in portrait or landscape orientation.  
// Note: This will only work for newly-created PDFs!  
ChromePdfRenderOptions renderOptions = new ChromePdfRenderOptions();  
renderOptions.setPaperOrientation(PaperOrientation.LANDSCAPE);  
PdfDocument newPdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com", renderOptions);  
newPdf.saveAs(Paths.get("assets/LandscapePdf.pdf"));  
  
// Use the rotatePage/rotateAllPages methods to adjust the page orientation for existing PDFs  
PdfDocument existingPdf = PdfDocument.fromFile(Paths.get("assets/example.pdf"));  
  
// Get the orientation of the first page of the existing PDF document.  
PageRotation firstPageRotation = existingPdf.getPagesInfo().get(0).getPageRotation();  
System.out.println(firstPageRotation);  
  
// Rotate the first page of the document only 90 degrees clockwise.  
existingPdf.rotatePage(PageRotation.CLOCKWISE_90, PageSelection.firstPage());  
  
// Rotate all pages of the document clockwise.  
existingPdf.rotateAllPages(PageRotation.CLOCKWISE_270);  
  
existingPdf.saveAs(Paths.get("assets/ExistingPdfRotated.pdf"));