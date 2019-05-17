package com.wanghao.demo.springbootlibrary.service.impl;

import com.wanghao.demo.springbootlibrary.domain.*;
import com.wanghao.demo.springbootlibrary.domain.bookborrowVo;
import com.wanghao.demo.springbootlibrary.mapper.BookMapper;
import com.wanghao.demo.springbootlibrary.mapper.BorrowingBooksMapper;
import com.wanghao.demo.springbootlibrary.mapper.DepartmentMapper;
import com.wanghao.demo.springbootlibrary.mapper.UserMapper;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * className:userServiceimpl
 * Package:com.wanghao.demo.springbootlibrary.service.impl
 * Description:
 *
 * @date:2019/5/79:30
 * @author:guoxin@bjpowernode.com
 */
@Service
public class userServiceimpl implements UserService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private BorrowingBooksMapper borrowingBooksMapper;
    @Resource
    private BookMapper bookMapper;

    @Override
    public List<User> findUserByUserName(String userName) {
        UserExample user = new UserExample();
        UserExample.Criteria criteria = user.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(user);
        return  users;



    }

    @Override
    public List<Department> findAllDepts() {
        return departmentMapper.selectByExample(new DepartmentExample());
    }

    @Override
    public User userLogin(String userName, String password) {
        List<User> user  =findUserByUserName(userName);

        if(user==null){
            return  null;

        }
        for (User u:user){
            if(u.getUserPwd().equals(password)){
                return u;
            }

        } return  null;
    }

    @Override
    public boolean updateUser(User user, HttpServletRequest request) {
       // return false;
        User user1 = (User) request.getSession().getAttribute("user");
        user.setUserId(user1.getUserId());
        int n = userMapper.updateByPrimaryKey(user);
        if(n>=1){
            User user2 = userMapper.selectByPrimaryKey(user.getUserId());
            request.getSession().setAttribute("user",user2);
            return true;
        }
        return false;
    }
    @Override
    public List<bookborrowVo> findAllBorrowingBooks(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");//获得在session中的user对象
      //  user.setUserId(user.getUserId());
        BorrowingBooksExample borrowingBooksExample = new BorrowingBooksExample();
        BorrowingBooksExample.Criteria criteria = borrowingBooksExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        List<BorrowingBooks> borrowingBooks = borrowingBooksMapper.selectByExample(borrowingBooksExample);//存入查询到的boorrow书籍
        if(borrowingBooks==null){
            return null;

        }
        LinkedList<bookborrowVo> vos = new LinkedList<>();
        for(BorrowingBooks s:borrowingBooks){
            Book book = bookMapper.selectByPrimaryKey(s.getUserId());
            bookborrowVo vo = new bookborrowVo();
            vo.setBook(book);

            Date date = s.getDate();
            SimpleDateFormat t = new SimpleDateFormat("yyyy年MM月dd日");
            String dataforborrowing = t.format(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(calendar.MONTH,2);
            Date time = calendar.getTime();
            String dateforreturn = t.format(time);
            vo.setDateOfBorrowing(dataforborrowing);
            vo.setDateOfReturn(dateforreturn);
            vos.add(vo);
        }


        return vos;
    }

    @Override
    public boolean userReturnBook(int bookId, HttpServletRequest request) {
      //  return false;
        User user = (User) request.getSession().getAttribute("user");
        BorrowingBooksExample borrowingBooksExample = new BorrowingBooksExample();
        BorrowingBooksExample.Criteria criteria = borrowingBooksExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
       // List<BorrowingBooks> list = borrowingBooksMapper.selectByExample(borrowingBooksExample);
        criteria.andBookIdEqualTo(bookId);
        int n = borrowingBooksMapper.deleteByExample(borrowingBooksExample);
        if(n>0){return  true;

        }
        return false;


    }

    @Override
    public boolean userBorrowingBook(int bookId, HttpServletRequest request) {
        //return false;
        User user = (User) request.getSession().getAttribute("user");
        BorrowingBooksExample borrowingBooksExample = new BorrowingBooksExample();
        BorrowingBooksExample.Criteria criteria = borrowingBooksExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        List<BorrowingBooks> list = borrowingBooksMapper.selectByExample(borrowingBooksExample);
        if (list.size() > 0) {
            return false;

        }
        BorrowingBooks borrowingBooks = new BorrowingBooks();
        borrowingBooks.setBookId(bookId);
        borrowingBooks.setUserId(user.getUserId());
        borrowingBooks.setDate(new Date());
        int n = borrowingBooksMapper.insert(borrowingBooks);
        if(n>0){
            return true;
        }
        return false;



    }


    @Override
    public User findUserById(int id) {
       // return null;
        return userMapper.selectByPrimaryKey(id);

    }

    @Override
    public Page<User> findUserByPage(int pageNum) {
       // return null;
        List<User> users = userMapper.selectByPage((pageNum - 1) * 10, 10);
        Page<User> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(10);
        page.setList(users);
        int n = userMapper.selectUserCount();
        int pagecount;
        pagecount=n/10;
        if(n%10>0){
            pagecount++;
        }
        page.setPageCount(pagecount);
        return page;



    }

    @Override
    public int insertUser(User user) {
       return userMapper.insert(user);
    }

    @Override
    public int deleteUserById(int userId) {
     //   return 0;
        return  userMapper.deleteByPrimaryKey(userId);
    }
}
