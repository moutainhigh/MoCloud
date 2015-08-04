<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
     <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
     <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
$(function(){	
	userSubmit(null);
	var pager =	$('#user').datagrid().datagrid('getPager');
	pager.pagination({
			pageSize: 20,
			showPageList:false,
			onSelectPage:function(pageNumber){
				userSubmit(pageNumber);
			}
	});
});
function userSubmit(page){
	progress();	
	var url = null;
	var data = null;
	if(page != null){
		url = "/manage/user/User.wa?do=select&page="+page+"&date="+new Date().valueOf();
		data ={"passport":$('#passport').val(),"page":page};
	}else{
		url = "/manage/user/User.wa?do=select&date="+new Date().valueOf();
	}
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 $('#user').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}

function edit(id){
	location.href = "/cloud/manage/user/User.wa?do=updateUserOnload&id="+id+"&date="+new Date().valueOf();	
}

</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>后台用户列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="/cloud/manage/user/User.wa?do=insertOnload" class="add_btn"></a>
        </div>
        <div class="nav_search">
            
        </div>
  </div>  
</div>
<table id="user" fit='true' class="easyui-datagrid"
style="width:100%;height:100%;text-align:center;align:true " 
data-options="toolbar:'#cy_right',pagination:true,collapsible:true">
	<thead>
			<tr>
			      <th data-options="field:'ouid',halign:'center',align:'left'" width="60px">编号</th>
               <th data-options="field:'passport',halign:'center',align:'left',sortable:true" width="120px">帐号</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="100px">说明</th>
               <th data-options="field:'description',halign:'center',align:'left',sortable:true" width="160px">描述</th>
               <th data-options="field:'content',halign:'center',align:'left'" width="140px">内容</th>
               <th data-options="field:'createDate',halign:'center',align:'left'" width="300px">创建时间</th>
               <th data-options="field:'updateDate',halign:'center',align:'left'" width="140px">修改时间</th>
               <th data-options="field:'operation',halign:'center',align:'left',formatter:insert_editAndDelButton" width="140px">操作</th>
			</tr>
	</thead>
</table>
</body>
</HTML>