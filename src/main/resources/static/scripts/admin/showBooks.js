$(document).ready(function () {

    //给选择框赋值
    findAllBookCategory();

    $("#bookCategoryForm").validate({
       rules:{
           bookCategory:{
               required:true
           }
       } ,
        messages:{
           bookCategory:{
               required:"请选择图书类别"
           }
        }
    });


    var lab1=$("#lab1").html().trim();
    var lab2=$("#lab2").html().trim();
    $("#prePage").click(function () {
        if(lab1==0){
            alert("已经是第一页了!");
            return false;
        }
        return true;
    });
    $("#nextPage").click(function () {
        if(lab1==lab2){
            alert("已经是最后一页了!");
            return false;
        }
        return true;
    });
});

function findAllBookCategory() {
    $.ajax({
        async : false,
        type : "post",
        url : "/findAllBookCategory",
        dataType : "json",
        success: function (data) {
            console.log(data);
            $("select[name='bookCategory']").empty();
            $("select[name='bookCategory']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].categoryId+'">';
                html +=data[i].categoryName + '</option>';
                $("select[name='bookCategory']").append(html);
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
};