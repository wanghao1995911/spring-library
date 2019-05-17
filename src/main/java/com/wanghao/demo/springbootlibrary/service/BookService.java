package com.wanghao.demo.springbootlibrary.service;

import com.wanghao.demo.springbootlibrary.domain.bookVo;
import com.wanghao.demo.springbootlibrary.page.Page;

import java.util.List;

/**
 * className:BookService
 * Package:com.wanghao.demo.springbootlibrary.service
 * Description:
 *
 * @date:2019/5/511:29
 * @author:guoxin@bjpowernode.com
 */

public interface BookService {

    public List<bookVo> findBooksByBookName(String bookName);
    public Page<bookVo> findBookByBookCategoryId(int categoryId,int pageNum);
    public List<bookVo>  findBookByBooKId(int bookId);


}
