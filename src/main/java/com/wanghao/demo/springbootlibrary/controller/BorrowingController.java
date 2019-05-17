package com.wanghao.demo.springbootlibrary.controller;

import com.wanghao.demo.springbootlibrary.domain.bookborrowVo;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.borrowRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class BorrowingController {

    @Resource
    private borrowRecord borrowingBooksRecord;

//    @RequestMapping("/allBorrowBooksRecordPage")
//    public String allBorrowingBooksRecordPage(Model model, @RequestParam("pageNum") Integer pageNum){
//        Page<bookborrowVo> page=borrowingBooksRecord.selectAllByPage(pageNum);
//        model.addAttribute("page",page);
//        return "admin/allBorrowingBooksRecord";
//    }
    @RequestMapping("/allBorrowBooksRecordPage")
    public String allBorrowingBooksRecordPage(Model model, @RequestParam(value = "pageNum",required = false,defaultValue = "0") int pageNum){
        Page<bookborrowVo> page=borrowingBooksRecord.selectAllByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/allBorrowingBooksRecord";
    }
}
