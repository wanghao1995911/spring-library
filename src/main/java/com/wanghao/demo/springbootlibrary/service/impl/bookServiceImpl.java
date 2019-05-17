package com.wanghao.demo.springbootlibrary.service.impl;

import com.wanghao.demo.springbootlibrary.domain.*;
import com.wanghao.demo.springbootlibrary.domain.bookVo;
import com.wanghao.demo.springbootlibrary.mapper.BookMapper;
import com.wanghao.demo.springbootlibrary.mapper.BorrowingBooksMapper;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * className:bookServiceImpl
 * Package:com.wanghao.demo.springbootlibrary.service
 * Description:
 *
 * @date:2019/5/511:48
 * @author:guoxin@bjpowernode.com
 */
@Service
public class bookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private BorrowingBooksMapper borrowingBooksMapper;
    @Override
    public List<bookVo> findBooksByBookName(String bookName) {
        com.wanghao.demo.springbootlibrary.domain.BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
       // BookExample booke = new BookExample();

        criteria.andBookNameEqualTo(bookName);
        List<Book> books = bookMapper.selectByExample(bookExample);
        List<bookVo>  bookVos= new LinkedList<>();
        if(books ==null)
            return  bookVos;
        for(Book b:books){
            bookVo vo = new bookVo();
            vo.setBookAuthor(b.getBookAuthor());
            vo.setBookId(b.getBookId());
            vo.setBookName(b.getBookName());
            vo.setBookPublish(b.getBookPublish());
            BorrowingBooksExample borrowingBooksExample = new BorrowingBooksExample();
            BorrowingBooksExample.Criteria criteria1 = borrowingBooksExample.createCriteria();
            criteria1.andBookIdEqualTo(b.getBookId());
            List<BorrowingBooks> borrowingBooks = borrowingBooksMapper.selectByExample(borrowingBooksExample);
            if(borrowingBooks==null||borrowingBooks.size()<1){
                vo.setIsExist("可借出");
            }
            if(borrowingBooks.size()>=1){
                vo.setIsExist("不可借");
            }
            bookVos.add(vo);

        }return bookVos;

    }

    @Override
    public Page<bookVo> findBookByBookCategoryId(int categoryId, int pageNum) {
        List<Book> books = bookMapper.selectByCategoryId(categoryId, (pageNum - 1) * 10, 10);
        LinkedList<bookVo> bookVos = new LinkedList<>();
        Page<bookVo> page = new Page<>();
      if(books==null){
          page.setPageSize(1);
          page.setPageNum(1);
          return page;
      }
        for(Book b:books){
            bookVo vo = new bookVo();
            vo.setBookAuthor(b.getBookAuthor());
            vo.setBookId(b.getBookId());
            vo.setBookName(b.getBookName());
            vo.setBookPublish(b.getBookPublish());
            vo.setBookPrice(b.getBookPrice());

            BorrowingBooksExample borrowingBooksExample = new BorrowingBooksExample();
            BorrowingBooksExample.Criteria criteria1 = borrowingBooksExample.createCriteria();
            criteria1.andBookIdEqualTo(b.getBookId());
            List<BorrowingBooks> borrowingBooks = borrowingBooksMapper.selectByExample(borrowingBooksExample);
            if(borrowingBooks==null||borrowingBooks.size()<1){
                vo.setIsExist("可借出");
            }
            if(borrowingBooks.size()>=1){
                vo.setIsExist("不可借");
            }
            bookVos.add(vo);
    }
        page.setList(bookVos);
        page.setPageNum(pageNum);
        page.setPageSize(10);
        int bookCount=bookMapper.selectBookCountByCategoryId(categoryId);
        int pageCount=0;
        pageCount=bookCount/10;
        if(bookCount%10!=0){
            pageCount++;
        }
        page.setPageCount(pageCount);
        if(bookCount==0){
            page.setPageCount(1);
        }
        return page;

    }

    @Override
    public List<bookVo> findBookByBooKId(int bookId) {
        com.wanghao.demo.springbootlibrary.domain.BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        // BookExample booke = new BookExample();

        criteria.andBookIdEqualTo(bookId);
        List<Book> books = bookMapper.selectByExample(bookExample);
        List<bookVo>  bookVos= new LinkedList<>();
        if(books ==null)
            return  bookVos;
        for(Book b:books){
            bookVo vo = new bookVo();
            vo.setBookAuthor(b.getBookAuthor());
            vo.setBookId(b.getBookId());
            vo.setBookName(b.getBookName());
            vo.setBookPublish(b.getBookPublish());
            BorrowingBooksExample borrowingBooksExample = new BorrowingBooksExample();
            BorrowingBooksExample.Criteria criteria1 = borrowingBooksExample.createCriteria();
            criteria1.andBookIdEqualTo(b.getBookId());
            List<BorrowingBooks> borrowingBooks = borrowingBooksMapper.selectByExample(borrowingBooksExample);
            if(borrowingBooks==null||borrowingBooks.size()<1){
                vo.setIsExist("可借出");
            }
            if(borrowingBooks.size()>=1){
                vo.setIsExist("不可借");
            }
            bookVos.add(vo);

        }return bookVos;

    }

    }



