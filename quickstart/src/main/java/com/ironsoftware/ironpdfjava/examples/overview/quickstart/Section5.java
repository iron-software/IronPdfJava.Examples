package com.ironsoftware.ironpdfjava.examples.overview.quickstart;

import com.ironsoftware.ironpdf.Settings;
import java.nio.file.Paths;

public class Section5 {
    public static void run() {
            com.ironsoftware.ironpdf.Settings.setLogPath(Paths.get("C:/tmp/myIronPdfEngineLog.log"));
    }
}
