<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<jsp:include page="/manage/common/kindediter.jsp"></jsp:include>
</HEAD>
<style> 
  form {
  margin: 0;
  }
  textarea {
  display: block;
  }
  </style> 

<script>
    $(function(){
       var image = $("#image").val();
       $("#oriIcon").attr("src",image);
       $('#displayCd').combobox("select", $('#oldDisplayCd').val());
       $('#linkCd').combobox("select", $('#oldLinkCd').val());
       var conte = $("#conte").val();
       $("#kindeditor_view").val(conte);
    });
    function submitForm() {
       progress();
       $("#getHtml").click();
       $("#logicNews").submit();
       closeProgress();
    }
    var editor;
    KindEditor.ready(function(K) {
       editor=K.create('#kindeditor_view', {
           uploadJson : '/manage/ajs/kindeditor-4.1.10/jsp/upload_json.jsp',
           items : kindeditor_items,
           resizeType : 1
       });
       K('input[id=getHtml]').click(function(e) {
           $("#content").val(editor.html())
       });
      K('input[id=showHtml]').click(function(e) {	
         $("#phoneShow").window("open");
         $("#phoneShow").html(editor.html());
      });
   });
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
   <span>修改业务资讯信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/business/News.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="logicNews" enctype=multipart/form-data
   action="/manage/product/business/News.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="810" height="346" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="54" height="38"><div align="left">资讯标题:</div></td>
      <td style="width:380px;"><input id="label" name="label" class="easyui-validatebox textbox"
        style="width:380px;height:20px"
        value="<jh:write source='&unit.label'/>" />
        <input id="adminId" name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
        <input id="image" name="image" style="display:none"
        value="<jh:write source='&unit.imageName'/>" />
        <input id="conte" name="conte" style="display:none"
        value="<jh:write source='&unit.content'/>" />
      </td>
      <td rowspan="3" style="width:140px;" ><div align="left" id="imgdiv">
       <img width="140" height="140" id="oriIcon"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">是否展示:</div></td>
     <td style="width:380px;"><div align="left">
       <input type="hidden" id="oldDisplayCd" value="<jh:write source='&unit.displayCd'/>">
       <input style="width:380px;height:20px" id="displayCd" class="easyui-combobox" name="displayCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'1','text':'展示'},{'value':'2','text':'非展示'}]"/>
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">外链状态:</div></td>
     <td><div align="left">
       <input type="hidden" id="oldLinkCd" value="<jh:write source='&unit.linkCd'/>">
       <input style="width:380px;height:20px" id="linkCd" class="easyui-combobox" name="linkCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'1','text':'内容'},{'value':'2','text':'外链'}]"/>  
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</div></td>
     <td  colspan="2"><div align="left">
       <input type="file" name="iconUrl" id="iconUrl" style="display:none;" onchange="changfile(this.value)"> 
       <input style="width:280px;" name="oiconUr" readonly="readonly" type="text" id="oiconUr" class="easyui-validatebox textbox" value="<jh:write source='&unit.iconUrl'/>" >
       <input type="button" value="选择上传文件" onclick="but()"> <span style="color:red;">&nbsp;&nbsp;选择小于20k的等比例图片</span>
      </div></td>
    </tr>
    <tr>
      <td  height="38" width="74"><div align="left">排序:</div></td>
      <td><input id="displayOrder" name="displayOrder" class="easyui-validatebox textbox"
        style="width:380px;height:20px"
        data-options="validType:'length[0,11]'"  value="<jh:write source='&unit.displayOrder'/>"/></td>
    </tr>
    <tr>
      <td height="38"><div align="left">关键字:</div></td>
      <td><input id="keywords" name="keywords" class="easyui-validatebox textbox"
        style="width:380px;height:20px"
        data-options="validType:'length[0,800]'" value="<jh:write source='&unit.keywords'/>"/></td>
    </tr>
    <tr>
     <td height="38"><div align="left">外链地址:</div></td>
     <td><div align="left">
         <input id="linkUrl" name="linkUrl" class="easyui-validatebox textbox"
        style="width:380px;height:20px" data-options="validType:'length[0,800]'" value="<jh:write source='&unit.linkUrl'/>"/>
     </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td colspan="2"><div align="left">
      <input id="description" name="description" class="easyui-textbox"
        data-options="multiline:true" value="<jh:write source='&unit.description'/>" 
        style="height:100px;width:700px" />
      </div></td>
    </tr>
    <tr>
     <td><div align="left">资讯内容:</div></td>
     <td align="left"  colspan="2">
        <textarea id="kindeditor_view" name="kindeditor_view" style="width:700px;height:300px" ></textarea>
          <input style="display:none" id="content" name="content" />
          <input type="button" style="display:none" id="getHtml" value="取得HTML" />
     </td>
    </tr>
   </table>
  </form>
 </div>
</body>
</HTML>