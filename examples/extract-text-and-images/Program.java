package ironpdfjava.ExtractTextAndImages;

import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://unsplash.com/");
            String text = pdf.extractAllText();
            System.out.println("Text extracted from the website: " + text);
            try {
                List<BufferedImage> images = pdf.extractAllImages();
                System.out.println("Number of images extracted from the website: " + images.size());
            
                int i = 0;
                for (BufferedImage image : images) {
                    ImageIO.write(image, "PNG", Files.newOutputStream(Path.of("assets/extracted_" + ++i + ".png")));
                }
            } catch(Exception exception) {
                System.out.println("Failed to extract images from the website");
                exception.printStackTrace();
            }
    }
}
