$(document).ready(function () {
   $("#adminLoginForm").validate({
       rules:{
           adminName:{
               required:true,
               remote:{
                   url: "isAdminExist",
                   url: "AdminLogin",

             dataType: "json",
                   data: {
                       adminName: function() {
                           return $("#adminName").val();
                       }
                   }
               }
           },
           password:{
               required:true
           }
       },
       messages:{
           adminName:{
               required:"请输入管理员登录名",
               remote:"用户不存在"
           },
           password:{
               required:"请输入密码"
           }
       }
   }) ;
});

var current = null;
document.querySelector('#adminName').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: 0,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#password').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -336,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#submit').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -730,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '530 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});