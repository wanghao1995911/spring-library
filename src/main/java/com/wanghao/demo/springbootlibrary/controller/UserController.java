package com.wanghao.demo.springbootlibrary.controller;




import com.wanghao.demo.springbootlibrary.domain.Department;
import com.wanghao.demo.springbootlibrary.domain.User;
import com.wanghao.demo.springbootlibrary.domain.bookborrowVo;
import com.wanghao.demo.springbootlibrary.page.Page;
import com.wanghao.demo.springbootlibrary.service.BookService;
import com.wanghao.demo.springbootlibrary.service.UserService;
import com.wanghao.demo.springbootlibrary.service.borrowRecord;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private borrowRecord borrowingBooksRecordService;

    @Resource
    private BookService bookService;



@PostMapping("isUserExist")
@ResponseBody
public String isUserExist(@RequestParam(value="userName", required = false,defaultValue = "0") String userName){
    List<User> users=userService.findUserByUserName(userName);
    if(null==users){
        return "false";
    }
    if(users.size()<1){
        return "false";
    }
    return "true";
}

    @GetMapping("/userLogin")
    public String userLogin(@RequestParam(value = "userName",required = false,defaultValue = "0") String userName,@RequestParam(value = "password",required = false,defaultValue = "0") String password,HttpServletRequest request){
        User user=userService.userLogin(userName,password);
        System.out.println(user);
        if(null!=user){
            request.getSession().setAttribute("user",user);
            System.out.println(user.getUserName());
            return "user/index";
        }
     //   request.getSession().setAttribute("userName", user.getUserName());
        return "index";
    }


    @PostMapping("/getDepts")
    @ResponseBody
    public List<Department> getDepts(){
        List<Department> depts=userService.findAllDepts();
        return depts;
    }

    @GetMapping("/userBorrowingBooksPage")
    public String userBorrowingBooksPage(Model model,HttpServletRequest request,@RequestParam(value = "pageNum",required = false,defaultValue = "0") int pageNum) throws ParseException {
        Page<bookborrowVo> res;
        if(request.getSession().getAttribute("borrowingBooksPageNum")==null){
           res= borrowingBooksRecordService.userSelectBypageNum(1,request);
            request.getSession().setAttribute("borrowingBooksPageNum",1);
        }else{
            res= borrowingBooksRecordService.userSelectBypageNum(pageNum,request);
        }
       model.addAttribute("borrowingBooksList",res);
        return "user/borrowingBooksRecord";
    }
    @GetMapping("/userReturnBooksPage")
    public String userReturnBooksPage(){
        return "user/returnBooks";
    }
    @GetMapping("/userMessagePage")
    public String userMessagePage(Model model,HttpServletRequest request){
        User session_user= (User) request.getSession().getAttribute("user");
        User user=userService.findUserById(session_user.getUserId());
        model.addAttribute("message_user",user);
        return "user/userMessage";
    }
    @GetMapping("/borrowingPage")
    public String borrowing(){
        return "user/borrowingBooks";
    }
    @GetMapping("/userIndex")
    public String userIndex(){
        return "user/index";
    }
    @PostMapping("/updateUser")
    @ResponseBody
    public boolean updateUser(User user,HttpServletRequest request){
        return userService.updateUser(user,request);
    }


    @PostMapping("/userReturnBook")
    @ResponseBody
    public boolean returnBook(int bookId,HttpServletRequest request){
        return userService.userReturnBook(bookId,request);
    }

    //借书
    @RequestMapping("/userBorrowingBook")
    @ResponseBody
    public boolean borrowingBook(int bookId,HttpServletRequest request){
        return userService.userBorrowingBook(bookId,request);
    }


    @GetMapping("/adminLoginPage")
    public String adminLoginPage(){
        return "adminLogin";
    }
//返回登录

    @GetMapping("/userLogOut")
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }


    @GetMapping("/findBookPage")
    public String findBookPage(){
        return "user/findBook";
    }
//返回


    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUserByUserId(@RequestParam(value = "userId") int userId){
        int res=userService.deleteUserById(userId);
        if(res>0){
            return "true";
        }
        return "false";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        int res=userService.insertUser(user);
        if(res>0){
            return "true";
        }else{
            return "false";
        }
    }
}
