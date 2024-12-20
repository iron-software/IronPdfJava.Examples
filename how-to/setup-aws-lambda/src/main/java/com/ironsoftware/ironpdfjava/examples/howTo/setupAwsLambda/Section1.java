package com.ironsoftware.ironpdfjava.examples.howTo.setupAwsLambda;

import com.ironsoftware.ironpdf.*;

public class Section1 {
    public static void run() {
            Setting.setIronPdfEngineWorkingDirectory(Paths.get("/tmp/"));
    }
}
