package com.wanghao.demo.springbootlibrary.service.impl;

import com.wanghao.demo.springbootlibrary.domain.*;
import com.wanghao.demo.springbootlibrary.mapper.AdminMapper;
import com.wanghao.demo.springbootlibrary.mapper.BookCategoryMapper;
import com.wanghao.demo.springbootlibrary.mapper.BookMapper;
import com.wanghao.demo.springbootlibrary.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServicreImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookCategoryMapper bookCategoryMapper;
    @Override
    public boolean adminIsExist(String name) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria=adminExample.createCriteria();
        criteria.andAdminNameEqualTo(name);
        List<Admin> admin=adminMapper.selectByExample(adminExample);
        if(null==admin)
        return false;
        if(admin.size()<1){
            return false;
        }
        return true;
    }

    @Override
    public boolean adminLogin(String name, String password) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria=adminExample.createCriteria();
        criteria.andAdminNameEqualTo(name);
        List<Admin> admin=adminMapper.selectByExample(adminExample);
        if(null==admin){
            return false;
        }
        for(Admin a:admin){
            if(a.getAdminPwd().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        int n=bookMapper.insert(book);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<BookCategory> getBookCategorys() {
        BookCategoryExample bookCategoryExample=new BookCategoryExample();
        return bookCategoryMapper.selectByExample(bookCategoryExample);
    }

    @Override
    public boolean addBookCategory(BookCategory bookCategory) {
        int n=bookCategoryMapper.insert(bookCategory);
        if(n>0){
            return true;
        }
        return false;
    }
}
