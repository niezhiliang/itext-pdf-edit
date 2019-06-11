package com.niezhiliang.itext.pdf.edit.utils;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.niezhiliang.itext.pdf.edit.entity.PdfEditDTO;
import com.niezhiliang.itext.pdf.edit.enums.FontType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PdfUtils {

    /**
     *
     * @param pdf 源文件
     * @param savePath 编辑后的文件地址
     * @param pdfEditDTOList 编辑内容的集合
     * @throws Exception
     */
    public static void eidtPdfText(File pdf, String savePath, List<PdfEditDTO> pdfEditDTOList) throws Exception {
        // 编辑后的文件
        PdfWriter pdfWriter = new PdfWriter(savePath);
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(pdf), pdfWriter);
        PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDocument, true);
        //font
        Rectangle rectangle;
        for (PdfEditDTO editDTO : pdfEditDTOList) {
            String ttfPath = PdfUtils.class.getClassLoader().getResource("./font/"+editDTO.getFontType().getFont()).getPath();
            PdfTextFormField pdfTextFormField;
            // 读取ttf字体文件
            FontProgram fontProgram = FontProgramFactory.createFont(ttfPath);
            // 编码使用 PdfEncodings.IDENTITY_H
            PdfFont font = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
            // 设置表单域的位置
            rectangle = new Rectangle(editDTO.getPositionX(), editDTO.getPositionY(), editDTO.getWidth(), editDTO.getHeitht());
            pdfTextFormField = PdfTextFormField.createText(pdfDocument, rectangle,editDTO.getFieldName(), editDTO.getText());
            pdfTextFormField.setBorderWidth(0).setReadOnly(true).setColor(ColorConstants.BLACK).setFontAndSize(font,
                    editDTO.getFontSize());
            /** 将表单域加入pdf的指定页中 */
            pdfAcroForm.addField(pdfTextFormField, pdfDocument.getPage(editDTO.getPageNum()));

        }

        // 将表单域中的value嵌入到pdf文件中
        pdfAcroForm.flattenFields();
        pdfDocument.close();
        pdfWriter.close();
    }
}
