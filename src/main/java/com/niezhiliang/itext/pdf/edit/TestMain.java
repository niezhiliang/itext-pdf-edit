package com.niezhiliang.itext.pdf.edit;

import com.niezhiliang.itext.pdf.edit.entity.PdfEditDTO;
import com.niezhiliang.itext.pdf.edit.enums.FontType;
import com.niezhiliang.itext.pdf.edit.utils.PdfUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) throws Exception {
        //获取pdf源文件
        File file = new File(PdfUtils.class.getClassLoader().getResource("./test.pdf").getPath());

        List<PdfEditDTO> pdfEditDTOList = new ArrayList<>();

        PdfEditDTO pdfEditDTO = new PdfEditDTO();
        pdfEditDTO.setFieldName("one");
        pdfEditDTO.setFontSize(18);
        pdfEditDTO.setFontType(FontType.SIMYOU);
        pdfEditDTO.setPositionX(0f);
        pdfEditDTO.setPositionY(10f);
        pdfEditDTO.setText("Hello World I am One Field");
        pdfEditDTO.setWidth(250);
        pdfEditDTO.setHeitht(20);
        pdfEditDTO.setPageNum(1);

        pdfEditDTOList.add(pdfEditDTO);

        PdfEditDTO pdfEditDTO2 = new PdfEditDTO();
        pdfEditDTO2.setFieldName("two");
        pdfEditDTO2.setFontSize(18);
        pdfEditDTO2.setFontType(FontType.STKAITI);
        pdfEditDTO2.setPositionX(0f);
        pdfEditDTO2.setPositionY(820f);
        pdfEditDTO2.setText("Hello World I am Two Field");
        pdfEditDTO2.setWidth(250);
        pdfEditDTO2.setHeitht(20);
        pdfEditDTO2.setPageNum(2);

        pdfEditDTOList.add(pdfEditDTO2);

        PdfUtils.eidtPdfText(file,"/Users/fxq/Desktop/itext-pdf-edit/src/main/resources/test2.pdf",pdfEditDTOList);

    }

}
