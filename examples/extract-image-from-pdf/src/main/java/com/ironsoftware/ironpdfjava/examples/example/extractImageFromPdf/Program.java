package com.ironsoftware.ironpdfjava.examples.example.extractImageFromPdf;

import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.imageio.ImageIO;
import com.ironsoftware.ironpdf.PdfDocument;

public class Program {
    public static void main(String[] args) {
            try {
                // The page renders the document before this snippet; rendered
                // here so the example stands on its own.
                PdfDocument pdf = PdfDocument.renderUrlAsPdf("https://ironpdf.com");

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
