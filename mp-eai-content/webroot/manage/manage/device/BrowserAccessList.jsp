<%@ include file='/apl/public.inc' %>
   <jh:define source="&basePage.user" alias="base"></jh:define>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            var flag = "<jh:write source='&base.ouid' />";
            if (flag == "") {
               alert("连接超时！");
               parent.parent.location.href = "/manage/home/Frame.wp";
            }
            doSubmit(null);
            var pager = $('#browserAccess').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: false,
               onSelectPage: function(pageNumber) {
                  doSubmit(pageNumber);
               }
            });
         });

         function doSubmit(page) {
            progress();
            var url = null;
            var data = null;
            if (page != null) {
               url = "/manage/device/Device.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            } else {
               url = "/manage/device/Device.wa?do=select&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#browserAccess').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function infoButton(value, row, index) {
            var edit = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="rowInfo(\'' + row.ouid + '\')"><span class="l-btn-text icon-tip l-btn-icon-left">详情</span></span></a>';
            return edit;
         }

         function rowInfo(id) {
            location.href = "/manage/device/Device.wa?do=updateBefore&ouid=" + id + "&date=" + new Date().valueOf();
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>设备信息</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn"></div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="browserAccess" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'deviceId',halign:'center',align:'right'" width="60px">设备编号</th>
               <th data-options="field:'agentCode',halign:'center',align:'left',sortable:true" width="800px">头信息</th>
               <th data-options="field:'content',halign:'center',align:'left',sortable:true" width="600px">内容</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:infoButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>