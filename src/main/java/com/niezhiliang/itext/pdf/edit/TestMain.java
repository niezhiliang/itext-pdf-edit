package com.niezhiliang.itext.pdf.edit;

import com.niezhiliang.itext.pdf.edit.entity.PdfEditDTO;
import com.niezhiliang.itext.pdf.edit.enums.FontType;
import com.niezhiliang.itext.pdf.edit.utils.PdfUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TestMain {

    public static void main(String[] args) throws Exception {

        String world = "  sdf撒旦法阿斯蒂芬按时按时阿萨德阿斯蒂芬阿萨德阿斯顿福建；路撒地方；离开家暗室逢灯名女生都if技能名称；埃里克差距欧赔；你妈是无法 阿萨德联发科加速度；浪蝶狂蜂寄哪里奥德赛阿斯蒂芬大连富士康；加工费；雷克萨就能";

        int width = 505;
        int count = 0;
        StringBuffer stringBuffer = new StringBuffer();

        for (char c : world.toCharArray()) {
            String w = String.valueOf(c);
            if (unicodeScript(c)){
                count += 16;
            } else {
                count += 8;
            }
            if (count > width) {
                stringBuffer.append("\n");
                count = 0;
            }
            //空格
            if (Character.isSpace(c)) {
                stringBuffer.append("\u00a0").append("\u00a0");
            } else {
                stringBuffer.append(w);
            }
        }
        System.out.println(stringBuffer.toString());
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
        pdfEditDTO2.setFontSize(16);
        pdfEditDTO2.setFontType(FontType.STKAITI);
        pdfEditDTO2.setPositionX(40f);
        pdfEditDTO2.setPositionY(500f);
        pdfEditDTO2.setText(stringBuffer.toString());
        pdfEditDTO2.setWidth(width);
        pdfEditDTO2.setHeitht(200);
        pdfEditDTO2.setPageNum(1);

        pdfEditDTOList.add(pdfEditDTO2);

        PdfUtils.eidtPdfText(file,"/Users/fxq/Desktop/itext-pdf-edit/src/main/resources/test2.pdf",pdfEditDTOList);

    }

    /**
     * 判断单个字符串是否为汉字或中文字符
     * @param c 待判断的字符串
     * @return 是中文汉字或中文字符返回true，否则返回false
     */
    private static boolean unicodeScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if(sc == Character.UnicodeScript.HAN) return true;
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS)
            return true;
        return false;
    }
}
