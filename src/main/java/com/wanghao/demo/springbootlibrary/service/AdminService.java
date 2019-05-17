package com.wanghao.demo.springbootlibrary.service;

import com.wanghao.demo.springbootlibrary.domain.Book;
import com.wanghao.demo.springbootlibrary.domain.BookCategory;

import java.util.List;

public interface AdminService {


    public boolean adminIsExist(String name);

    public boolean adminLogin(String name, String password);


    public boolean addBook(Book book);


    public List<BookCategory> getBookCategorys();


    public boolean addBookCategory(BookCategory bookCategory);
}
