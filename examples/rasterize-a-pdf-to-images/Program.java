package ironpdfjava.RasterizeAPdfToImages;

import java.util.List;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("assets/composite.pdf"));
            
            // Extract all the pages from the PDF file.
            List<BufferedImage> extractedImages = pdf.toBufferedImages();
            
            // With the ToImageOptions object, specify maximum image dimensions for each
            // extracted image, as well as their DPI
            ToImageOptions rasterOptions = new ToImageOptions();
            rasterOptions.setImageMaxHeight(100);
            rasterOptions.setImageMaxWidth(100);
            
            // Call the toBufferedImage method along with a PageSelection object to choose the pages from which to
            // extract the images
            //
            // Available PageSelection methods include: allPages, lastPage, firstPage, singlePage(int pageIndex),
            // and pageRange(int startingPage, int endingPage)
            List<BufferedImage> sizedExtractedImages = pdf.toBufferedImages(rasterOptions, PageSelection.allPages());
            
            // Save all the extracted images to a file location
            int i = 1;
            for (BufferedImage extractedImage : sizedExtractedImages) {
                String fileName = "assets/images/" + i++ + ".png";
                ImageIO.write(extractedImage, "PNG", new File(fileName));
            }
    }
}
