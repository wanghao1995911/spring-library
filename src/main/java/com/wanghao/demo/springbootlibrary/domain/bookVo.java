package com.wanghao.demo.springbootlibrary.domain;

import lombok.Data;

/**
 * className:bookVo
 * Package:com.wanghao.demo.springbootlibrary.domain
 * Description:
 *
 * @date:2019/5/511:44
 * @author:guoxin@bjpowernode.com
 */
@Data
public class bookVo {

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookPublish;

    private String isExist;
    private Double bookPrice;
}
