<%@ include file='/apl/public.inc'%>
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
      $("#cityId").val($('#city').combobox("getValue"));
      //$("#countryId").val($('#country').combobox("getValue"));
      $("#config").submit();
   }
   $(function() {
       var url = "/manage/product/common/Country.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#country').combobox('loadData', result);
          },
          fail: function() {
             alert("error");
           }
        });
   })
   function getCountry(){
      var data = null;
      var counId = $('#country').combobox("getValue");
      if(counId!=null) data={"countryId":counId};
      var url = "/manage/product/common/Area.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
               var result = toJsonObject(msg);
               if(result.length==0){
               }
               $('#area').combobox("setValue",null);
               $('#area').combobox('loadData', result);
         },
         fail: function() {
            alert("error");
         }
      });
   }
   function getArea(){
      var data = null;
      var areaId = $('#area').combobox("getValue");
      if(areaId!=null) data={"areaId":areaId};
      var url = "/manage/product/common/Province.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
               var result = toJsonObject(msg);
               if(result.length==0){
               }
               $('#province').combobox("setValue",null);
               $('#province').combobox('loadData', result);
         },
         fail: function() {
            alert("error");
         }
      });
   }
   function getProvince(){
      var data = null;
      var provinceId = $('#province').combobox("getValue");
      if(provinceId!=null) data={"provinceId":provinceId};
      var url = "/manage/product/common/City.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
               var result = toJsonObject(msg);
               if(result.length==0){
               }
               $('#city').combobox("setValue",null);
               $('#city').combobox('loadData', result);
         },
         fail: function() {
            alert("error");
         }
      });
   }
</script>
<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加城市身份证对照信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/common/Citycard.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config"
   action="/manage/product/common/Citycard.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="850" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">身份证:</div></td>
     <td><div align="left">
       <input id="cardCode" name="cardCode" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,11]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属国家:</div></td>
     <td><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="country" name="country" data-options="valueField:'ouid',textField:'name',editable:false"/>
       <input name="countryId" id="countryId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属区域:</div></td>
     <td><div align="left">
       <div onclick="getCountry()"><input class="easyui-combobox" style="width:380px;" id="area" name="area" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="areaId" id="areaId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属省份:</div></td>
     <td><div align="left">
       <div onclick="getArea()"><input class="easyui-combobox" style="width:380px;" id="province" name="province" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="areaId" id="provinceId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属城市:</div></td>
     <td><div align="left">
       <div onclick="getProvince()"><input class="easyui-combobox" style="width:380px;" id="city" name="city" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="cityId" id="cityId" type="hidden">
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>