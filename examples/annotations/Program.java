
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.annotation.AnnotationIcon;
import com.ironsoftware.ironpdf.annotation.AnnotationManager;
import com.ironsoftware.ironpdf.annotation.AnnotationOptions;
import java.io.IOException;
import java.nio.file.Paths;

// Create a new PDF or load an existing one from the filesystem
PdfDocument pdf = PdfDocument.fromFile(Paths.get("assets/example.pdf"));

// Create an annotation to be placed at a specific location on a page.
AnnotationOptions annotation = new AnnotationOptions(
        "This is a major title", // Title of the annotation
        "This is the long 'sticky note' comment content...", // Content of the annotation
        150, // x-axis coordinate location
        250  // y-axis coordinate location
);
annotation.setIcon(AnnotationIcon.HELP);
annotation.setOpacity(0.9);
annotation.setPrintable(false);
annotation.setHidden(false);
annotation.setOpen(true);
annotation.setReadonly(true);
annotation.setRotateable(true);

// Add the annotation to a specific page of the PDF
AnnotationManager annotationManager = pdf.getAnnotation();
annotationManager.addTextAnnotation(annotation, 0);

// Save the PDF with the modifications
pdf.saveAs(Paths.get("assets/annotated.pdf"));