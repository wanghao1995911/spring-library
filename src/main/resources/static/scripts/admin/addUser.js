$(document).ready(function () {

    $("#btn_addUser").click(function () {
        if(validateAddUserForm().form()){
            addUser();
        }
    });
});


function addUser() {
    $.ajax({
        async : false,
        type : 'post',
        url : '/addUser',
        data : $('#addUserForm').serialize(),
        success : function(data) {
            alert("添加成功");

        },
        error : function(data) {
            alert("添加失败");
        }
    });
};

function validateAddUserForm() {
    return $("#addUserForm").validate({
        rules:{
            userName:{
                required:true
            },
            userPwd:{
                required:true
            },
            userEmail:{
                required:true
            },
            userSex:{
                required:true
            },
            userTel:{
                required:true
            },
            userBoring:{
                required:true
            }
        },
        messages:{
            userName:{
                required:"请输入用户名"
            },
            userPwd:{
                required:"请输入密码"
            },
            userEmail:{
                required:"请输入email"
            },
            userSex:{
                required:"请输入性别"
            },
            userTel:{
                required:"请输入电话号码"
            },
            userBoring:{
                required:"请输入出生日期"
            }
        }

    })
}