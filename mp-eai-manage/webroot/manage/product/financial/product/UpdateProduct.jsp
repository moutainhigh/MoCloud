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

        if (!isValid())
            return;
        progress();
        var url = "/manage/product/financial/product/Product.wa?do=update&date="
                + new Date().valueOf();
        var data = {
            "adminId" : $('#adminId').val(),
            "name" : $('#name').val(),
            "label" : $('#label').val(),
            "rentPerson" : $('#rentPerson').val(),
            "tenantPerson" : $('#tenantPerson').val(),
            "timeLimit" : $('#timeLimit').val(),
            "annualRateOfReturn" : $('#annualRateOfReturn').val(),
            "note" : $('#note').val(),
            "ouid" : $('#ouid').val()
        };
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                console.info("-->"+msg.trim(" ",""));
                var result = toJsonObject(msg);
                location.href = "/manage/product/financial/product/Product.wa";
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
    }

    //日历插件函数
    function myformatter(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
                + (d < 10 ? ('0' + d) : d);
    }
    function myparser(s) {
        if (!s)
            return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
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
     href="/manage/product/financial/customer/Customer.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/manage/product/financial/product/Product.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="710" height="446" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="56" height="38"><div align="left">名&nbsp;&nbsp;&nbsp;&nbsp;称:</div></td>
     <td width="103"><div align="left">
       <input id="name" name="name" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.name'/>" /><input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" /><input
        id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
     <td width="54"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td width="185"><input id="label" name="label"
      class="easyui-validatebox textbox" style="width:80px;height:20px"
      data-options="validType:'length[0,100]'"
      value="<jh:write source='&unit.label'/>" /></td>
     <td width="67">&nbsp;</td>
     <td width="245">&nbsp;</td>
    </tr>
    <tr>

     <td><div align="left">出租人:</div></td>
     <td><div align="left">
       <input id="rentPerson" name="rentPerson"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.rentPerson'/>" />
      </div></td>
     <td height="30"><div align="left">承租人:</div></td>
     <td><div align="left">
       <input id="tenantPerson" name="tenantPerson"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.tenantPerson'/>" />
      </div></td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">投资期限:</div></td>
     <td><div align="left">
       <input id="timeLimit"
        name="timeLimit"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" value="<jh:write source='&unit.timeLimit'/>" />
      </div></td>
     <td><div align="left">预期年收益率:</div></td>
     <td><div align="left">
       <input id="annualRateOfReturn"
        name="annualRateOfReturn"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" value="<jh:write source='&unit.annualRateOfReturn'/>" />
      </div></td>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>

    </tr>
    <tr>


     <td height="19"><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">备注:</div></td>
     <td colspan="5"><div align="left">
       <input id="note" name="note" class="easyui-textbox"
        data-options="multiline:true" style="height:100px;width:500px" value="<jh:write source='&unit.note'/>" />
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>