package com.wanghao.demo.springbootlibrary.page;

import lombok.Data;

import java.awt.*;
import java.util.List;

/**
 * className:Page
 * Package:com.wanghao.demo.springbootlibrary.page
 * Description:
 *
 * @date:2019/5/59:16
 * @author:guoxin@bjpowernode.com
 */
@Data
public class Page<T> {
    private List<T> list;
    private int PageNum;
    private int PageSize;
    private int pageCount;



}
