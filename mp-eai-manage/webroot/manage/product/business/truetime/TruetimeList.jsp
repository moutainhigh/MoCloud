<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
    //显示更新成功
    $(function() {
        doSubmit(null, null);
        var pager = $('#logicNews').datagrid().datagrid('getPager');
        pager.pagination({
            pageSize : 20,
            showPageList : [ 20, 30, 40 ],
            onSelectPage : function(pageNumber, pageSize) {
                doSubmit(pageNumber, pageSize);
            }
        });
    });
    function doSubmit(page, pageSize) {
        progress();
        var url = "/manage/product/business/truetime/Truetime.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var label = $.trim($('#label').val()).replaceAll("'", "");
        if (label == "实时数据标题") label = null;
        if (page != null) {
            url = "/manage/product/business/truetime/Truetime.wa?do=select&page="
                    + page + "&date=" + new Date().valueOf();
            data = {
                "label" : label,
                "page" : page,
                "pageSize" : pageSize
            };
        }
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                $('#logicNews').datagrid('loadData', toJsonObject(msg));
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
    }
    function del(id) {
       return confirmx('确定删除?',
             function() {
             location.href = "/manage/product/business/truetime/Truetime.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
          });
    }
    //更新配置信息-AnjoyTian
    function edit(id) {
       progress();
       console.info(id);
       window.location.href = "/manage/product/business/truetime/Truetime.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();
       closeProgress();
    }
    function showPhoto(iconUrl){
       if(iconUrl!=null&&iconUrl.length>0){
          return "<img src="+iconUrl+" height=55px width=55px/>";
       }
    }
    function phoneInfo(ouid){
       var l=(screen.availWidth-500)/2;
       var t=(screen.availHeight-500)/2;
       window.open('/manage/product/business/truetime/Truetime.wa?do=getDescription&ouid='+ouid,'_blank','height=600,width=600,top='+t+',left='+l+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
   }
    //搜索按钮，enter键
    document.onkeydown=function(){
       if(event.keyCode=="13"){
          doSubmit(0);    
       }
    }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>实时数据信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/manage/product/business/truetime/Truetime.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="label" name="label" type="text"
     onfocus="if(this.value=='实时数据标题'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='实时数据标题';this.style.color='#ccc';}"
     style="color: #ccc" value="实时数据标题"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
 <table id="logicNews" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
     <th
     data-options="field:'iconUrl',halign:'center',align:'left',formatter:showPhoto"
     width="55px">图片</th>
     <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="200px">实时数据标题</th>
     <th
     data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true"
     width="30px">状态</th>
     <th
     data-options="field:'displayCdStr',halign:'center',align:'left',sortable:true"
     width="60px">是否显示</th>
     <th
     data-options="field:'linkCdStr',halign:'center',align:'left',sortable:true"
     width="60px">外链状态</th>
     <th 
     data-options="field:'displayOrder',halign:'center',align:'left',sortable:true"
     width="40px">排序</th>
     <th
     data-options="field:'keywords',halign:'center',align:'left',sortable:true"
     width="60px">关键字</th>
     <th
     data-options="field:'linkUrl',halign:'center',align:'left',sortable:true"
     width="160px">外链地址</th>
    <th
     data-options="field:'description',halign:'center',align:'left',sortable:true"
     width="160px">描述</th>
     <th
     data-options="field:'content',halign:'center',align:'left',sortable:true"
     width="260px">实时数据内容</th>
     <th 
     data-options="field:'updateDate',halign:'center',align:'left',sortable:true"
     width="140px">更新时间</th>
     <th 
     data-options="field:'createDate',halign:'center',align:'left',sortable:true"
     width="140px">创建时间</th>
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_browser_editAndDelButton"
     width="230px">操作</th>
   </tr>
  </thead>
 </table>
 <div id="w" style="width:500px;height:200px;padding:5px;">
 </div>
</body>
</HTML>