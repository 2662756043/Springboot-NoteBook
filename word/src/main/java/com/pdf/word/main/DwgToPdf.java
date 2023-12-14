package com.pdf.word.main;


import com.aspose.cad.Color;
import com.aspose.cad.Image;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.aspose.cad.imageoptions.PdfOptions;
import com.aspose.cad.internal.B.S;
import com.aspose.cad.internal.Q.A;
import com.aspose.pdf.internal.imaging.FontSettings;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DwgToPdf {
    /**
     * dwg转换pdf
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception{

        //URL url = ResourceUtils.getURL("dwg-Font");
        //System.out.println(url.getPath().substring(1));


        String name = "销轴23";
        DWGFileToPDF("C:\\Users\\DELL\\Downloads\\dwg\\" + name + ".dwg", "C:\\Users\\DELL\\Downloads\\dwg\\" + name + ".pdf");

    }


    /**
     * @param srcFile 选择dwg文件路径
     * @param dataDir 保存FTP文件路径
     */
    public static void DWGFileToPDF(String srcFile, String dataDir) throws Exception {

        Image objImage = Image.load(srcFile);
        CadRasterizationOptions rasterizationOptions = new CadRasterizationOptions();
        rasterizationOptions.setBackgroundColor(Color.getWhite());
        rasterizationOptions.setPageWidth(1600);
        rasterizationOptions.setPageHeight(1600);
        //rasterizationOptions.se
        // Create an instance of PdfOptions
        PdfOptions pdfOptions = new PdfOptions();
        pdfOptions.setVectorRasterizationOptions(rasterizationOptions);
        //FontSettings.setDefaultFontName(FontSettings.getDefaultFontName());
        //FontSettings.setFontsFolder("D:\\word\\src\\main\\resources\\dwg-Font");
        FontSettings.setFontsFolders(FontSettings.getAllFonts());
        objImage.save(dataDir, pdfOptions);
        objImage.close();
    }


}
