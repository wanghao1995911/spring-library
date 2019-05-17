package com.wanghao.demo.springbootlibrary.service;

import com.wanghao.demo.springbootlibrary.domain.BookCategory;
import com.wanghao.demo.springbootlibrary.page.Page;
import org.springframework.stereotype.Service;

/**
 * className:BookCategoryService
 * Package:com.wanghao.demo.springbootlibrary.service
 * Description:
 *
 * @date:2019/4/3017:10
 * @author:guoxin@bjpowernode.com
 */

public interface BookCategoryService {
public Page<BookCategory> SelectPageFrompageNum(int pageNum);
   int delteCategory(int categoryId);

}
