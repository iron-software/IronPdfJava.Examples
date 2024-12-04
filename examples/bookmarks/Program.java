package ironpdfjava.Bookmarks;

import java.util.List;
import com.ironsoftware.ironpdf;

public class Program {
    public static void main(String[] args) {
            // Load an existing PDF from the file system (or create a new one from HTML)
            PdfDocument pdf = PdfDocument.fromFile(Paths.get("assets/book.pdf"));
            
            // Add top-level bookmarks to pages of the PDF using their page indices
            BookmarkManager bookmarks = pdf.getBookmark();
            bookmarks.addBookMarkAtEnd("Author's Note", 2);
            bookmarks.addBookMarkAtEnd("Table of Contents", 3);
            bookmarks.addBookMarkAtEnd("Summary", 10);
            bookmarks.addBookMarkAtEnd("References", 12);
            
            // Retrieve a reference to the Summary bookmark so that we can add a sublist of bookmarks to it.
            List<Bookmark> bookmarkList = bookmarks.getBookmarks();
            Bookmark bookmark = bookmarkList.get(2);
            bookmark.AddChildBookmark("Conclusion", 11);
            
            // Save the PDF to the filesystem
            pdf.saveAs(Paths.get("assets/bookmarked.pdf"));
    }
}
