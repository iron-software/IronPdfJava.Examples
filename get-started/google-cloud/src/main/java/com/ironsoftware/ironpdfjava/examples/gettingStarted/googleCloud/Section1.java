package com.ironsoftware.ironpdfjava.examples.gettingStarted.googleCloud;

import java.nio.file.Paths;
import java.io.IOException;
import com.ironsoftware.ironpdf.Settings;

public class Section1 {
    public static void run() throws IOException {
            // Set the working directory for the IronPDF Engine
              Settings.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
    }
}
