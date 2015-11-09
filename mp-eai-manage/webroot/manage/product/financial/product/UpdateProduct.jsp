<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
       progress();
       if (!isValid()){
          closeProgress();
          return;
       }
       
       var file = $("#iconUrl").val();
       if(""!=file){
          if(!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(file)){
             closeProgress();
             alert("图片类型必须是.gif|jpg|jpeg|png|gif|jpg|png中的一种!");
             return false;
          }
          var fileSize = document.getElementById("iconUrl").files[0].size;
          if(fileSize>1024*1024){
             closeProgress();
             alert("请上传大小小于1M的等比例图片!");
             return false;
          }
       }
    $("#config").submit();
    closeProgress();
    }

  //选择图片
    function but(){
       $("#iconUrl").click();
    }
    function changfile(obj){
       $('#imgdiv').hide();
       $("#oriIcon").attr("src","");
       $('#oiconUr').val("");
       var a = obj.lastIndexOf("\\");
       $("#oiconUr").val(obj.substr(a+1,obj.length));
    }
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>修改产品信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/financial/product/Product.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config" enctype=multipart/form-data
   action="/manage/product/financial/product/Product.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="810" height="200" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="86" height="38"><div align="left">英&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,40]'"
        value="<jh:write source='&unit.code'/>" /><input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" /><input
        id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
      <td rowspan="3" style="width:114px;" ><div align="left" id="imgdiv">
       <img width="114" height="114" src="<jh:write source='&unit.makeUrl'/>"></div></td>
     </tr>
     <tr>
     <td width="86" height="38"><div align="left">中&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称签:</div></td>
     <td><input id="label" name="label"
      class="easyui-validatebox textbox notnull" style="width:380px;height:20px"
      data-options="required:true,validType:'length[0,40]'"
      value="<jh:write source='&unit.label'/>" /></td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td width="86" height="38"><div align="left">收&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;益&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;率:</div></td>
     <td><div align="left">
       <input id="rate" name="rate"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'"
        value="<jh:write source='&unit.rate'/>" />
     </div></td>
     <td>&nbsp;</td>
     </tr>
     <tr>
     <td width="86" height="38"><div align="left">投&nbsp;&nbsp;资&nbsp;&nbsp;期&nbsp;&nbsp;&nbsp;限:</div></td>
     <td><div align="left">
       <input id="horizonCount" name="horizonCount"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'"
        value="<jh:write source='&unit.horizonCount'/>" />
      </div></td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td width="86" height="38"><div align="left">投资期限类型:</div></td>
     <td><div align="left">
       <input id="horizonUnit"
        name="horizonUnit"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,40]'" value="<jh:write source='&unit.horizonUnit'/>" />
     </div></td>
     <td>&nbsp;</td>
     </tr>
     <tr>
     <td width="86" height="38"><div align="left">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;闭&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期:</div></td>
     <td><div align="left">
       <input id="horizonClosed"
        name="horizonClosed"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'" value="<jh:write source='&unit.horizonClosed'/>" />
      </div></td>
     <td></td>
    </tr>
    <tr>
     <td width="86" height="38"><div align="left">等&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;待&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期:</div></td>
     <td><div align="left">
       <input id="horizonWait"
        name="horizonWait"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'" value="<jh:write source='&unit.horizonWait'/>" />
     </div></td>
     <td>&nbsp;</td>
     </tr>
     <tr>
     <td width="86" height="38"><div align="left">业&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绩:</div></td>
     <td><div align="left">
       <input id="factor"
        name="factor"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'" value="<jh:write source='&unit.factor'/>" />
      </div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</div></td>
     <td  colspan="2"><div align="left">
       <input type="file" name="iconUrl" id="iconUrl" style="display:none;" onchange="changfile(this.value)"> 
       <input style="width:280px;" name="oiconUr" readonly="readonly" type="text" id="oiconUr" class="easyui-validatebox textbox" value="<jh:write source='&unit.makeUrl'/>" >
       <input type="button" value="选择上传文件" onclick="but()"> <span style="color:red;">&nbsp;&nbsp;选择小于1M的等比例图片</span>
      </div></td>
    </tr>
    <tr>
     <td width="86" height="38"><div align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</div></td>
     <td colspan="2"><div align="left">
       <input id="note" name="note" class="easyui-textbox"
        data-options="multiline:true" style="height:100px;width:700px" value="<jh:write source='&unit.note'/>" />
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>