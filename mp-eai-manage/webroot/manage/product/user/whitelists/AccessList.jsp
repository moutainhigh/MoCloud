<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            doSubmit(null,null);
            var pager = $('#userAccess').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: false,
               onSelectPage: function(pageNumber) {
                  doSubmit(pageNumber,pageSize);
               }
            });
         });

         function doSubmit(page,pageSize) {
            progress();
            var url = null;
            var data = null;
            var hostAddress = $.trim($('#hostAddress').val()).replaceAll("'", "");
            if (hostAddress == "IP地址") hostAddress = null;
            if (page != null) {
               url = "/manage/product/user/whitelists/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "hostAddress": hostAddress,
                  "page": page
               };
            } else {
               url = "/manage/product/user/whitelists/Access.wa?do=select&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#userAccess').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function del(id) {
            location.href = "/manage/product/user/whitelists/Access.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
         }

         function edit(id) {
            location.href = "/manage/product/user/whitelists/Access.wa?do=updateBefore&id=" + id + "&date=" + new Date().valueOf();
         }
         function formatAccess(value,row,index){
            return (row.accessCd == '1')?"允许":"禁止";           
         }
         function formatType(value,row,index){
            return (row.typeCd == '1')?"永久":"临时";
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right">
         <div class="right_title">
            <span>白名单</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="/manage/product/user/whitelists/Access.wa?do=insertBefore" class="add_btn"></a>
            </div>
            <div class="nav_search">
               <input id="hostAddress" name="hostAddress" type="text"
                 onfocus="if(this.value=='IP地址'){this.value='';}this.style.color='#000000';"
                 onblur="if(this.value=='') {this.value='IP地址';this.style.color='#ccc';}"
                 style="color: #ccc" value="IP地址"> <a onClick="doSubmit(0)"
                  href="#" class="sear_btn"></a>
            </div>
         </div>
      </div>
      <table id="userAccess" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'hostAddress',halign:'center',align:'left',sortable:true" width="150px">IP地址</th>
               <th data-options="field:'passport',halign:'center',align:'left',sortable:true" width="150px">帐号</th>
               <th data-options="field:'accessCd',halign:'center',align:'center',sortable:true,formatter:formatAccess" width="80px">权限</th>
               <th data-options="field:'typeCd',halign:'center',align:'center',sortable:true,formatter:formatType" width="80px">是否永久</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="400px">说明</th>
               <th data-options="field:'beginDate',halign:'center',align:'left',sortable:true" width="140px">开始时间</th>
               <th data-options="field:'endDate',halign:'center',align:'left',sortable:true" width="140px">结束时间</th>
               <th data-options="field:'updateDate',halign:'center',align:'left',sortable:true" width="140px">更新时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>