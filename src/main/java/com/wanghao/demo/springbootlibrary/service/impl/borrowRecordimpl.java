package com.wanghao.demo.springbootlibrary.service.impl;

import com.wanghao.demo.springbootlibrary.domain.Book;
import com.wanghao.demo.springbootlibrary.domain.BorrowingBooks;
import com.wanghao.demo.springbootlibrary.domain.User;
import com.wanghao.demo.springbootlibrary.domain.bookborrowVo;
import com.wanghao.demo.springbootlibrary.mapper.BookMapper;
import com.wanghao.demo.springbootlibrary.mapper.BorrowingBooksMapper;
import com.wanghao.demo.springbootlibrary.mapper.UserMapper;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.borrowRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * className:borrowRecordimpl
 * Package:com.wanghao.demo.springbootlibrary.service.impl
 * Description:
 *
 * @date:2019/5/515:45
 * @author:guoxin@bjpowernode.com
 */
@Service
public class borrowRecordimpl implements borrowRecord {

    @Resource
    BorrowingBooksMapper borrowingBooksMapper;
    @Resource
    BookMapper bookMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public Page<bookborrowVo> userSelectBypageNum(int pageNum, HttpServletRequest request) throws ParseException {
        User user = (User) request.getSession().getAttribute("user");
if(user==null){
    return null;
}
        List<BorrowingBooks> list = borrowingBooksMapper.selectByPageNumAndPageSize((pageNum-1)*10, 10,user.getUserId());
   if(list==null ){
       return  null;
   }
        Page<bookborrowVo> page = new Page<bookborrowVo>();
        LinkedList<bookborrowVo> bookborrowVos = new LinkedList<>();
for(BorrowingBooks v: list){
   Book book= bookMapper.selectByPrimaryKey(v.getBookId());
    bookborrowVo vo= new bookborrowVo();
    vo.setBook(book);
    Date date = v.getDate();

    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
    String dataforborrowing = s.format(date);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(calendar.MONTH,2);
    Date time = calendar.getTime();
    String dateforreturn = s.format(time);
    vo.setDateOfBorrowing(dataforborrowing);
    vo.setDateOfReturn(dateforreturn);


    Date nowdays = new Date();
    String sss= String.valueOf(nowdays);
    SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);

    Date parse = dateFormat1.parse(sss);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String nowdaysformat = dateFormat.format(parse);

//    String nowdays = s.format(nowday);
//    if((long)date<System.currentTimeMillis())
    //    System.out.println(time);
    String ccc= String.valueOf(time);
    Date parse2 = dateFormat1.parse(ccc);
    String borrowdaysformat = dateFormat.format(parse2);
    Date date1 = dateFormat.parse(borrowdaysformat);

    Date date2 =dateFormat.parse(nowdaysformat);
    long cha = date2.getTime() - date1.getTime();
//    if(cha>0){
//        return null;
//    }
//
//    long d = cha/(24*60*60*1000);
    vo.setDateforBorrow(cha/(24*60*60*1000)<0?0:(cha/(24*60*60*1000))*2);

    bookborrowVos.add(vo);






}
page.setList(bookborrowVos);
page.setPageNum(pageNum);
page.setPageSize(10);


int n =borrowingBooksMapper.selectAllRecordCount(user.getUserId());

        int pagecount;
        pagecount=n/10;
        if(n%10>0){
            pagecount++;
        }
        page.setPageCount(pagecount);
        return page;





    }

    @Override
    public Page<bookborrowVo> selectAllByPage(int pageNum) {
        List<BorrowingBooks> list = borrowingBooksMapper.selectAllByPage((pageNum-1)*10, 20);
        if(list==null){return null; }
        Page<bookborrowVo> borrowRecordPage = new Page<>();
        LinkedList<bookborrowVo> list1 = new LinkedList<>();
        for(BorrowingBooks s:list){
            Book book= bookMapper.selectByPrimaryKey(s.getBookId());
            User user = userMapper.selectByPrimaryKey(s.getUserId());
            bookborrowVo vo = new bookborrowVo();
            vo.setBook(book);
            vo.setUser(user);
            Date date = s.getDate();
            SimpleDateFormat t = new SimpleDateFormat("yyyy年MM月dd日");
               String dateforborrowing = t.format(date);

            Calendar calendar= Calendar.getInstance();
            calendar.setTime(date);

            calendar.add(calendar.MONTH,2);
            Date time = calendar.getTime();
            String backforborrowing = t.format(time);
            vo.setDateOfReturn(backforborrowing);
            vo.setDateOfBorrowing(dateforborrowing);
            list1.add(vo);




        }
        borrowRecordPage.setList(list1);
        borrowRecordPage.setPageNum(pageNum);
        borrowRecordPage.setPageSize(10);

        int recordCount =0;
         recordCount = borrowingBooksMapper.selectAll();
//        int n = userMapper.selectUserCount();
//        int pagecount;
//        pagecount=n/10;
//        if(n%10>0){
//            pagecount++;
//        }
//        page.setPageCount(pagecount);
//        return page;
int n=borrowingBooksMapper.selectAll();

        int pagecount;
        pagecount=n/10;
        if(n%10>0){
            pagecount++;
        }
        borrowRecordPage.setPageCount(pagecount);
        return borrowRecordPage;


        //   return null;
    }

    @Override
    public int borrowDay() {

        return 0;


    }
}
