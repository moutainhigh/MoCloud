<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/public.inc' %>
<HTML>
<HEAD>
<TITLE>eUIS - Download</TITLE>
<je:css/>
<je:js type='runtime'/>
<STYLE>
.RBody_Panel{
   height:100%;
   width:100%;
   filter:progid:dximagetransform.microsoft.alphaimageloader(src=<jh:img type='path' src='/person/background.jpg'/>,sizingmethod=scale);
   background-image:none;
}
.RBody_Top{
   width:947;
   height:90;
   background:url('body_top.png');
   }
.RBody_Middle{
   padding:0px 8px;
   width:947;
   background:url(body_middle.png);
   }
.RBody_Bottom{
   width:947;
   height:28;
   background:url(body_bottom.png);
   }
</STYLE>
</HEAD>
<!-- Script - begin --------------------------------------->
<SCRIPT>
// ---------------------------------------------------------
function _onloadAll(){
   MoJS.initialize();
   RWindow.setEnable(true);
}
// ---------------------------------------------------------
function _onload(){
   _start = new Date().getTime();
   RWindow.connect(window);
   RLoader.loadJs('mobj', 'workspace');
   RLoader.waitJs(new TInvoke(null, _onloadAll), 'mobj', 'workspace');
}
</SCRIPT>
<!-- Script - end ----------------------------------------->
<!-- Body - begin ----------------------------------------->
<BODY style='margin:0; padding:0' onload='_onload()' disabled>
<TABLE width="100%" height='100%' border='0' cellpadding="0" cellspacing="0" class='RBody_Panel'>
<TR>
<TD width='50%'><DIV></DIV></TD>
<TD>
<TABLE width="947" height='100%' border="0" cellpadding="0" cellspacing="0" style='position:relative;'>
<TR><TD height='10'></TD></TR>
<TR><TD class='RBody_Top'></TD></TR>
<TR><TD class='RBody_Middle' valign='top' style='padding:8'>
<!--------------------------------------------------------->
<TABLE width="100%" height='100%' border="0" cellpadding="0" cellspacing="0">
<TR>
    <TD height='1' align='center'>
      如果您在10秒钟内还没有出现下载文件的提示，<BR><BR>
      请用鼠标右键<A href='<jh:context/><jh:write source='&#parameter.r'/>'><B style='color:#EC5C3A'>点击这里</B></A>，选择[<FONT color='GREEN'>目标另存为...</FONT>]开始下载文件。
   </TD>
</TR>
<TR><TD height='8'></TD></TR>
<TR>
   <TD style='padding:8'>
      <!-- <IFRAME align='center' frameborder='0' marginwidth='0' style='width:100%;height:100%;border:1 solid #999999;' src='<jh:context/><jh:write source='&#parameter.r'/>'></IFRAME> -->
   </TD>
</TR>
</TABLE>
<!--------------------------------------------------------->
</TD></TR>
<TR><TD class='RBody_Bottom'></TD></TR>
<TR><TD height='16'></TD></TR>
</TABLE>
</TD>
<TD width='50%'><DIV></DIV></TD>
</TR>
</TABLE>
</BODY>
<!-- Body - end ------------------------------------------->
</HTML>
