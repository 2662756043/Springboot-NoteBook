package com.pdf.word.main;


import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.internal.imaging.FontSettings;

import java.io.*;

/**
 * pdf转换成word
 */

public class PDFHelper3 {

    public static void main(String[] args) throws IOException {
        pdf2doc("C:\\Users\\user\\Desktop\\发票\\318.pdf");
        //dwg2pdf("C:\\Users\\DELL\\Downloads\\dwg\\销轴4.dwg");
//        for (String allFont : FontSettings.getAllFonts()) {
//            System.out.println(allFont);
//        }
    }


    //pdf转doc
    public static void pdf2doc(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            //新建一个word文档
            String wordPath=pdfPath.substring(0,pdfPath.lastIndexOf("."))+".docx";
            FileOutputStream os = new FileOutputStream(wordPath);
            //doc是将要被转化的word文档
            Document doc = new Document(pdfPath);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            doc.save(os, SaveFormat.DocX);
            os.close();
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
    }

    public static void dwg2pdf(String dwgPath) {
        long old = System.currentTimeMillis();
        try {
            //新建一个word文档
            String wordPath=dwgPath.substring(0,dwgPath.lastIndexOf("."))+".pdf";
            FileOutputStream os = new FileOutputStream(wordPath);
            for (String allFont : FontSettings.getAllFonts()) {
                System.out.println(allFont);
            }
            System.out.println(FontSettings.getDefaultFontName());
            FontSettings.setFontsFolders(FontSettings.getAllFonts());
            //doc是将要被转化的word文档
            Document doc = new Document(dwgPath);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            doc.save(os, SaveFormat.Pdf);
            os.close();
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
    }


}
