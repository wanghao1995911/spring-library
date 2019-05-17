$(document).ready(function () {
    $("#findBookByIdForm").validate({
        rules:{
            bookId:{
                required:true
            }
        },
        messages:{
            bookId:{
                required:"请输入书的代码"
            }
        }
    })
});