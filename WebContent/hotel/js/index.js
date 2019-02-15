$(function(){
    // 输入框字体
    // var message = $(".message");
    // $(".text1").focus(function(){
    //     if($(this).val() === "用户名"){
    //         $(this).val("").css({"color":"#000","border-color":"#66afe9"});
    //     }
    //     message.hide();
    // }).blur(function(){
    //     if($(this).val() === ""){
    //         $(this).val("用户名").css({"color":"rgb(187, 183, 183)","border-color":"rgb(235, 232, 232)"});
    //     }
    // });
    // $(".text2").focus(function(){
    //     if($(this).val() === "密码"){
    //         $(this).val("").css("color","#000").attr("type","password");
    //     }
    //     message.hide();
    // }).blur(function(){
    //     if($(this).val() === ""){
    //         $(this).val("密码").css("color","rgb(187, 183, 183)").attr("type","text");
    //     }
    // });
    $(".text1").focus();
    $(document).keyup(function(){
        if(window.event.keyCode == 13){
            $("#btn").trigger("click");
        }
    });

    // 轮播图
    var index = 0,
        timer = null;
    function a(){
        $(".slide div").stop().eq(index).fadeIn().siblings("div").fadeOut();
        $(".spot span").eq(index).css("background-color","#f13003").siblings("span").css("background-color","#fff");
        index++;
        if(index > 2){
            index = 0;
        } 
    }
    $(".slide").mouseout(function(){
        timer = setInterval(a,2500);
    }).mouseover(function(){
        clearInterval(timer);
    });
    $(".spot span").mouseover(function(){
        index = $(this).index();
        a();
    });
    $(".banner-nav li:eq(0)").mouseover(function(){
        $(".hide1").stop().show();
    }).mouseout(function(){
        $(".hide1").stop().hide();
    })
})