package com.wanghao.demo.springbootlibrary.domain;

import java.util.Date;

public class BorrowingBooks {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Date date;

    private Integer recordprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRecordprice() {
        return recordprice;
    }

    public void setRecordprice(Integer recordprice) {
        this.recordprice = recordprice;
    }
}