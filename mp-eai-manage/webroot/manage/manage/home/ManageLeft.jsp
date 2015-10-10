<!doctype html>
<%@ include file='/apl/public.inc' %>
   <html>

   <head>
      <meta charset="utf-8">
      <title>后台管理系统</title>
      <link rel="stylesheet" href="/manage/acs/style.css" type="text/css" media="screen" />
      <link rel="stylesheet" href="/manage/acs/main.css" type="text/css" media="screen" />
      <link rel="stylesheet" href="/manage/acs/lrtk.css" type="text/css" media="screen" />
      <script src="/manage/ajs/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
      <script>
         function checkHtml() {
            var menu = $.trim($("#one").children(".sub-menu").html());
            if (menu == '') {
               $("#one").hide();
            }
            menu = $.trim($("#two").children(".sub-menu").html());
            if (menu == '') {
               $("#two").hide();
            }
            menu = $.trim($("#three").children(".sub-menu").html());
            if (menu == '') {
               $("#three").hide();
            }
            menu = $.trim($("#four").children(".sub-menu").html());
            if (menu == '') {
               $("#four").hide();
            }
            menu = $.trim($("#six").children(".sub-menu").html());
            if (menu == '') {
               $("#six").hide();
            }
         }
      </script>
   </head>

   <body bgcolor="#198bc9" onload="checkHtml();">
      <div id="cy_left">
         <!-- 导航 开始 -->
         <ul id="accordion" class="accordion">

            <li id="one" class="files">
               <a href="#">系统管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.system.user.module" value="&basePage.menuString"><li><a href="/manage/system/user/module/Module.wa" target="right">模块管理</a></li></jh:equals>
                  <jh:equals source="manage.system.user.role" value="&basePage.menuString"><li><a href="/manage/system/user/role/Role.wa" target="right">角色管理</a></li></jh:equals>
                  <jh:equals source="manage.system.user" value="&basePage.menuString"><li><a href="/manage/system/user/User.wa" target="right">用户管理</a></li></jh:equals>
               </ul>
            </li>

            <!--
    <li id="three" class="system"> <a href="#three">版本管理</a>
      <ul class="sub-menu">
         <jh:equals source="system.application" value="&basePage.menuString"><li><a href="/cloud/manage/version/Application.wa" target="right" >应用管理</a></li></jh:equals>
         <jh:equals source="system.version" value="&basePage.menuString"><li><a href="/cloud/manage/version/Version.wa" target="right" >版本管理</a></li></jh:equals>
      </ul>
    </li>
    <li id="four" class="files">
      <a href="#">日志管理</a>
      <ul class="sub-menu">
         <jh:equals source="manage.logger" value="&basePage.menuString"><li><a href="/cloud/manage/log/log/Log.wa" target="right" >系统日志</a></li></jh:equals>
         <jh:equals source="manage.exception" value="&basePage.menuString"><li><a href="/cloud/manage/log/exception/Exception.wa" target="right" >系统例外</a></li>
         </jh:equals>
      </ul>
    </li>
    <li id="five" class="examine"> <a href="#four">流程管理(<span id="allNumber" style="color:#F00"></span>)</a>
      <ul class="sub-menu">
       <jh:equals source="logic.examine.version" value="&basePage.menuString"><li>
       <a href="/cloud/product/examine/version/Version.wa" target="right" >版本审批(<span id="versionAudit" style="color:#F00"></span>)</a></li></jh:equals>
      </ul>
    </li>
    <li id="six" class="data"> <a href="#five">数据管理</a>
      <ul class="sub-menu">
         <jh:equals source="data" value="&basePage.menuString"><li><a href="#" target="right" >数据(导入/导出)</a></li></jh:equals>
      </ul>
    </li>
-->
            <!--
            <li id="four" class="files">
               <a href="#">后台管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.batchProcess" value="&basePage.menuString">
                     <li><a href="/cloud/manage/batchProcess/BatchProcess.wa" target="right">后台处理</a></li>
                  </jh:equals>
                  <jh:equals source="manage.system.message" value="&basePage.menuString">
                     <li><a href="/cloud/manage/message/Message.wa" target="right">系统消息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.logic.guide" value="&basePage.menuString">
                     <li><a href="/cloud/manage/guide/Guide.wa" target="right">业务引导</a></li>
                  </jh:equals>
                  <jh:equals source="manage.logic.event" value="&basePage.menuString">
                     <li><a href="/cloud/manage/event/Event.wa" target="right">业务事件</a></li>
                  </jh:equals>
               </ul>
            </li>
-->


         </ul>
         <!-- 导航 结束 -->
      </div>
      <script type="text/javascript">
         $(document).ready(function() {
            // Store variables
            var accordion_head = $('.accordion > li > a'),
               accordion_body = $('.accordion li > .sub-menu');
            // Open the first tab on load
            accordion_head.first().addClass('active').next().slideDown('normal');
            // Click function
            accordion_head.on('click', function(event) {
               // Disable header links
               event.preventDefault();
               // Show and hide the tabs on click
               if ($(this).attr('class') != 'active') {
                  accordion_body.slideUp('normal');
                  $(this).next().stop(true, true).slideToggle('normal');
                  accordion_head.removeClass('active');
                  $(this).addClass('active');
               }
            });
         });
      </script>
   </body>

   </html>