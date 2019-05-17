package com.wanghao.demo.springbootlibrary.service;

import com.wanghao.demo.springbootlibrary.domain.Department;
import com.wanghao.demo.springbootlibrary.domain.User;
import com.wanghao.demo.springbootlibrary.domain.bookborrowVo;
import com.wanghao.demo.springbootlibrary.page.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * className:UserService
 * Package:com.wanghao.demo.springbootlibrary.service
 * Description:
 *
 * @date:2019/5/617:31
 * @author:guoxin@bjpowernode.com
 */

public interface UserService {
    List<User> findUserByUserName(String userName);


    List<Department> findAllDepts();

    User userLogin(String userName,String password);


    boolean updateUser(User user, HttpServletRequest request);

    //查借书记录
    List<bookborrowVo> findAllBorrowingBooks(HttpServletRequest request);


    boolean userReturnBook(int bookId,HttpServletRequest request);


    boolean userBorrowingBook(int bookId,HttpServletRequest request);


    User findUserById(int id);


    Page<User> findUserByPage(int pageNum);


    int insertUser(User user);


    int deleteUserById(int userId);

}
