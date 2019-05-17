package com.wanghao.demo.springbootlibrary.controller;


import com.wanghao.demo.springbootlibrary.domain.Book;
import com.wanghao.demo.springbootlibrary.domain.BookCategory;
import com.wanghao.demo.springbootlibrary.domain.bookVo;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.BookCategoryService;
import com.wanghao.demo.springbootlibrary.service.BookService;
import com.wanghao.demo.springbootlibrary.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BookController {
    @Resource
    private AdminService adminService;
    @Resource
    private BookService bookService;
    @Resource
    private BookCategoryService bookCategoryService;

    @PostMapping("/addBook")
    @ResponseBody
    public String addBook(Book book){
        boolean res=adminService.addBook(book);
        if(res){
            return "true";
        }
        return "false";
    }

    @GetMapping("/showBooksResultPageByCategoryId")
    public String showBooksResultPageByCategoryId(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "bookCategory") int bookCategory, Model model){
        Page<bookVo> page=bookService.findBookByBookCategoryId(bookCategory,pageNum);
        model.addAttribute("page",page);
        model.addAttribute("bookCategory",bookCategory);
        return "admin/showBooks";
    }


    @GetMapping("/findBookByName")
    public String findBooksResultPage(@RequestParam(value = "bookName") String bookName,Model model){
        List<bookVo> bookVos =bookService.findBooksByBookName(bookName);
        model.addAttribute("bookList",bookVos);
        return "user/findBook";
    }
    @GetMapping("/findBookByID")

    public String findBooksResultPagebyId(@RequestParam(value = "bookId") int bookId,Model model){
        List<bookVo> bookVos =bookService.findBookByBooKId(bookId);
        model.addAttribute("bookList",bookVos);
        return "user/findBookbyId";
    }


    @PostMapping("/findAllBookCategory")
    @ResponseBody
    public List<BookCategory> findAllBookCategory(){
        return adminService.getBookCategorys();
    }

    @PostMapping("/addBookCategory")
    @ResponseBody
    public String addBookCategory(BookCategory bookCategory){
        boolean b=adminService.addBookCategory(bookCategory);
        if(b){
            return "true";
        }
        return "false";
    }


    @PostMapping("/deleteCategory")
    @ResponseBody
    public String deleteBookCategoryById(@RequestParam("bookCategoryId") int bookCategoryId){
        int res=bookCategoryService.delteCategory(bookCategoryId);
        if(res>0){
            return "true";
        }
        return "false";
    }

}
