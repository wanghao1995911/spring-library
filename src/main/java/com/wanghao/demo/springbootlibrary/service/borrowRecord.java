package com.wanghao.demo.springbootlibrary.service;

import com.wanghao.demo.springbootlibrary.domain.bookborrowVo;
import com.wanghao.demo.springbootlibrary.page.Page;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * className:borrowRecord
 * Package:com.wanghao.demo.springbootlibrary.service
 * Description:
 *
 * @date:2019/5/515:30
 * @author:guoxin@bjpowernode.com
 */


public interface borrowRecord {
    public Page<bookborrowVo> userSelectBypageNum(int pageNum, HttpServletRequest request) throws ParseException;
    public Page<bookborrowVo>  selectAllByPage(int pageNum);
    public int borrowDay();

}
