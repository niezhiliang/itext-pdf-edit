package com.niezhiliang.itext.pdf.edit.entity;

import com.niezhiliang.itext.pdf.edit.enums.FontType;
import lombok.Data;

@Data
public class PdfEditDTO {

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 内容宽
     */
    private Integer width;

    /**
     * 内容高
     */
    private Integer heitht;

    /**
     * 占位符别名
     */
    private String fieldName;

    /**
     * 合同页数
     */
    private Integer pageNum;

    /**
     * 左下角X
     */
    private Float positionX;

    /**
     * 左下角Y
     */
    private Float positionY;

    /**
     * 填充的文本内容
     */
    private String text;

    /**
     * 字体类型（枚举）
     */
    private FontType fontType;

}
