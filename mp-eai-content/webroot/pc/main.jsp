<%@ include file='/apl/public.inc' %>
   <!DOCTYPE >
   <html>
   <head>
      <title></title>
      <meta charset="UTF-8" />
      <meta name="baidu-site-verification" content="r49gUEsySi" />
      <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/main.css">
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
   </head>
   <script>
      function doChart(code) {
         id_code.value = code;
         frmMain.submit();
      }
      function loginOut(){
         location.href="Index.wa?do=loginOut";
      }
   </script>
   <body>
      <p class="prompt"><span>您好，<jh:write source='&page.passport' />欢迎登陆！</span></p>
      <FORM name='frmMain' method='post' action='Index.wa'>
         <INPUT id='id_do' name='do' type='hidden' value='chart'>
         <INPUT id='id_code' name='code' type='hidden'>
         <header class="header floatBtn">
            <div class="head-left"><img class="logo" src="images/main/logo.png">
               <p class="pl-10"></p>
            </div>
            <div class="head-right">
               <p class="user-details" id="user-details"><i>3</i>您好<img src="images/main/icon.png"></p>
               <ul class="users" id="users">
                  <li class="binding">帐号绑定</li>
                  <li onclick="loginOut();">退出</li>
               </ul>
               <span class="img-details mr-20 pulse">
            <img src='../mb/images/re.png'>
         </span>
            </div>
         </header>
         <div class="clear"></div>
        <div class="main" style="display:;">
            <div class="imag-container">
               <div class="imag-details">
                  <p class="icon-picture"><span>客户</span><span style="display:none;">理财师</span><span style="display:none;" >公司</span></p>
                  <div id="container_details" style="">
                  <ul><li>
                        <img src="images/main/3.png">
                        <div class="shadow"><img src="images/main/iconfont-sousuo.png"></div>
                     </li><li >
                        <img src="images/main/1.png">
                        <div class="shadow"><img src="images/main/iconfont-sousuo.png"></div>
                     </li><li >
                        <img src="images/main/2.png">
                        <div class="shadow"><img src="images/main/iconfont-sousuo.png"></div>
                     </li></ul>
                     </div>
               </div>
            </div>
       </FORM>
         
         <div class="titles-container">
               <ul>
                  <p class="play_prev"></p>
                  <li class="on"><i class="mask"></i><img src="images/main/3-3.png"></li>
                  <li><i class="mask"></i><img src="images/main/1-1.PNG"></li>
                  <li><i class="mask"></i><img src="images/main/2-2.png"></li>
                  <p class="play_next"></p>
               </ul>
            </div>
         </div>
         <div class="binding-container" style="display:none;">
            <div class="box">
               <div class="box-container">
                  <h1>账号绑定</h1>
                  <span class="box-prompt"><i></i></span>
                  <p class="icon mt-30"><i class=""></i><input id="mobile" class="quantico account"  type="text" placeholder="E租宝"></p>
                  <p class="validation"><input type="text" id="verification_code" placeholder="验证码"><input type="button" id="send_btn" value="发送动态密码"></p>
                  <a href="javascript:;" class="btn"><input id="btn" type="submit"  value="提交"></a>
                  <p style="text-align: right"><a href="javascript:;" class="returns" style="margin-top: 20px;display:block;">返回首页</a></p>
               </div>
            </div>
         </div>
      <script type="text/javascript"></script>
   </body>
   </html>