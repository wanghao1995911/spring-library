package com.wanghao.demo.springbootlibrary.domain;

import com.wanghao.demo.springbootlibrary.domain.Book;
import com.wanghao.demo.springbootlibrary.domain.User;
import lombok.Data;

/**
 * className:bookborrowVo
 * Package:com.wanghao.demo.springbootlibrary.domain
 * Description:
 *
 * @date:2019/5/511:45
 * @author:guoxin@bjpowernode.com
 */
@Data
public class bookborrowVo {

        private User user;
        private Book book;  //借阅书籍
        private String dateOfBorrowing;  //借书日期
        private String dateOfReturn;
        private long dateforBorrow;




}