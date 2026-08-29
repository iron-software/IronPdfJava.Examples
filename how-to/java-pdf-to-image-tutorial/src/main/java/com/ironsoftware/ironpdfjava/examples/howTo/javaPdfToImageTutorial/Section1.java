package com.ironsoftware.ironpdfjava.examples.howTo.javaPdfToImageTutorial;

import com.ironsoftware.ironpdf.image.ToImageOptions;


public class Section1 {
    public static void run() {
            // The page opens this before the snippet; opened here so the
            // section stands on its own.
            ToImageOptions rasterOptions = new ToImageOptions();
            rasterOptions.setImageMaxHeight(800);
            rasterOptions.setImageMaxWidth(500);
    }
}
