var $shadowBg = $(".shadow-bg"),
    $managementPrompt = $(".management-prompt");
    function shutDown(){
      $(".note-setupthe").slideUp();
      $shadowBg.hide();
      // $managementPrompt.removeClass('bounceInDown').addClass('fadeOutDown');
      $managementPrompt.hide();
    // 
    };
    function setManagement(){
        $(".management-prompt").show();
        $shadowBg.show();
    }
$(function(){
	var link = location.href,
	$managementPrompt = $(".management-prompt");
	var inde=0;
    $(".management-prompt").on("click",".remind",function(){
        inde = $(this).index();
        $(this).find("input").prop("checked",true);
    })
    var page = getQueryString("page");
    var data ={};
    var id = null;
    // hover 跳转
    $(".focus").on("click",".trs",function(){
        var url = $(this).attr("href");
         location.href= url;
    })
    // 解除关系
    $(".imag-container").on("click",".remove",function(event){
        event.stopPropagation();
        // event.preventDefault();
        $managementPrompt.show();
        id = $(this).data("id");
        $shadowBg.show();
    })

    // 提交
    $(".submits").click(function(){
       data = {
          id : id,
          type:$(".remind").data("id")
       };
      setAjax("",data,function(datas){
        console.log(datas);
        // location.href = location.href+
        })
    })


})
