package com.wanghao.demo.springbootlibrary.service.impl;
import com.wanghao.demo.springbootlibrary.domain.BookCategory;
import com.wanghao.demo.springbootlibrary.mapper.BookCategoryMapper;
import com.wanghao.demo.springbootlibrary.mapper.BorrowingBooksMapper;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.BookCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * className:bookCategoryImpl
 * Package:com.wanghao.demo.springbootlibrary.service.impl
 * Description:
 *
 * @date:2019/5/59:47
 * @author:guoxin@bjpowernode.com
 */
@Service
public class bookCategoryImpl implements BookCategoryService {
    @Resource
    private BookCategoryMapper bookCategoryMapper;
    @Resource
    private BorrowingBooksMapper borrowingBooksMapper;

    @Override
    public Page<BookCategory> SelectPageFrompageNum(int pageNum){
        Page<BookCategory> page =new Page<>();
       List<BookCategory> list = bookCategoryMapper.selectByPageNum((pageNum-1)*10,10);
        page.setPageNum(pageNum);
       page.setPageSize(10);
        page.setList(list);
   int recordcount= bookCategoryMapper.selectAllCount();
    int pagecount =recordcount/10;
        if(recordcount%10!=0){
            pagecount++;
        }
        page.setPageCount(pagecount);
        return page;

    }

    @Override
    public int delteCategory(int categoryId) {
return  bookCategoryMapper.deleteByPrimaryKey(categoryId);



    }
}
