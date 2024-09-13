
import com.ironsoftware.ironpdf.*;  
import java.io.IOException;  
import java.nio.file.*;  
import java.util.ArrayList;  
import java.util.List;  

// Reference to the directory containing the images that we desire to convert
Path imageDirectory = Paths.get("assets/images");

// Create an empty List to contain Paths to images from the directory.
List<Path> imageFiles = new ArrayList<>();

// Use a DirectoryStream to populate the List with paths for each image in the directory
// that we want to convert (this example uses a glob pattern to target only png and jpg images)
try (DirectoryStream<Path> stream = Files.newDirectoryStream(imageDirectory, "*.{png,jpg}")) {
    for (Path entry : stream) {
        imageFiles.add(entry);
    }

    // Render all targeted images as PDF content and save them together in one PDF document.
    PdfDocument.fromImage(imageFiles).saveAs(Paths.get("assets/composite.pdf"));
} catch (IOException exception) {
    throw new RuntimeException(String.format("Error converting images to PDF from directory: %s: %s",
            imageDirectory,
            exception.getMessage()),
            exception);
}