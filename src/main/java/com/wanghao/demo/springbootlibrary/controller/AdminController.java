package com.wanghao.demo.springbootlibrary.controller;

import com.wanghao.demo.springbootlibrary.domain.BookCategory;
import com.wanghao.demo.springbootlibrary.domain.User;
import com.wanghao.demo.springbootlibrary.domain.bookVo;


import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.BookCategoryService;
import com.wanghao.demo.springbootlibrary.service.AdminService;

import com.wanghao.demo.springbootlibrary.service.UserService;
//import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;
   @Resource
    private BookCategoryService BookCategoryService;
    @Resource
    private UserService userService;


//    @GetMapping("adminIsExist")
//    @ResponseBody
//    public String adminIsExist(@RequestParam(value="adminName", required = false,defaultValue = "0") String adminName){
//        String s = adminName;
//        boolean b = adminService.adminIsExist(s);
//
//        if(b){
//            return "true";
//        }else{
//            return "false";
//        }
//    }
    @PostMapping ("isAdminExist")
    @ResponseBody
    public String adminIsExist(@RequestParam(value="adminName", required = false,defaultValue = "0") String adminName){
        String s = adminName;
        boolean b=adminService.adminIsExist(s);
        if(b){
            return "true";
        }else{
            return "false";
        }
    }

//    @GetMapping("adminLogin")
//    //@ResponseBody
//    public String adminLogin(@RequestParam(value = "adminName",required = false,defaultValue = "0") String adminName,@RequestParam(value = "password",required = false,defaultValue = "0") String password,HttpServletRequest request){
//        boolean res=adminService.adminLogin(adminName,password);
//        if(res==false){
//            return "adminLogin";
//        }
//        request.getSession().setAttribute("admin","admin");
//        return "admin/index";
//    }
    @PostMapping ("adminLogin")
    public String adminLogin(@RequestParam(value = "adminName",required = false,defaultValue = "0") String adminName,@RequestParam(value = "password",required = false,defaultValue = "0") String password,HttpServletRequest request){
        boolean res=adminService.adminLogin(adminName,password);
        if(res==false){
            return "adminLogin";
        }
        request.getSession().setAttribute("admin","admin");
        return "admin/index";
    }


    @GetMapping ("addBookPage")
    public String addBookPage(){
        return "admin/addBook";
    }


    @GetMapping("/addCategoryPage")
    public String addCategoryPage(@RequestParam(value = "pageNum") int pageNum, Model model){
        Page<BookCategory> page=BookCategoryService.SelectPageFrompageNum(pageNum);
       model.addAttribute("page",page);
        return "admin/addCategory";
    }
//

    @GetMapping("/showStausPage")
    public String showStausPage(){
       return "admin/showStaus";
    }
//

    @GetMapping("/adminIndex")
    public String returnAdminIndexPage(){
        return "admin/index";
    }
//
//
//

    @GetMapping("/showUsersPage")
    public String showUsersPage(Model model,@RequestParam(value = "pageNum") int pageNum){
        Page<User> page=userService.findUserByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/showUsers";
    }

    @GetMapping("/showBooksPage")
    public String showBooksPage(Model model){
        Page<bookVo> page=new Page<bookVo>();
        page.setPageCount(1);
        page.setPageNum(1);
        model.addAttribute("page",page);
        return "admin/showBooks";
   }
//
//
//

    @GetMapping("/adminLogOut")
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "adminLogin";
    }
//

    @GetMapping("/addUserPage")
        public String addUserPage(){
        return "admin/addUser";
   }

}
