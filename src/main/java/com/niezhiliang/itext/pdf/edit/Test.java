package com.niezhiliang.itext.pdf.edit;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020-04-08 10:57
 */
public class Test {

    public static void main(String[] args) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(new File("/Users/fxq/Desktop/t.pdf")));
        Document doc = new Document(pdfDoc);
        PdfFont sysFont = PdfFontFactory.createFont("STSongStd-Light",
                "UniGB-UCS2-H", false);
        //创建总表形式（一行四格）
        Table table = new Table(new float[] { 100});
        //表格行合并"2"代表合并2行单元格
        Cell cell=new Cell(1,1).add(
                new Paragraph("onesadfsadfsadfasdfsas沙发大多数发送阿斯顿发斯蒂芬按时答复按时阿斯蒂芬df\r\nsafsadfds撒旦法阿斯顿发送到爱撒旦法爱上大放送上的地方阿斯蒂芬阿斯蒂芬afsadfsadf")
                        .setFont(sysFont));
        table.addCell(cell);
        doc.add(table);
        doc.close();
    }
}
