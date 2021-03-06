<%@ include file="/inc/page/begin.inc" %>

<HTML>

<!-- Html Header Initialize ------------------------------->
<HEAD>
<js:meta/>
<js:css/>
<js:js top='Y'/>
<jh:title caption='Table'/>
</HEAD>

<SCRIPT language='javascript'>
function showPage(sPage){
   if(sPage == 'a'){
      id_query.style.display = 'none';
      id_query_info.style.display = 'none';
      id_advanced.style.display = 'block';
      id_advanced_info.style.display = 'block';
   }else if(sPage == 'q'){
      id_query.style.display = 'block';
      id_query_info.style.display = 'block';
      id_advanced.style.display = 'none';
      id_advanced_info.style.display = 'none';
   }
   WindowDlgManager.search.careCase = frmConsole.case_value.checked;
   frmConsole.where.value = WindowDlgManager.search.whereSql();
   frmConsole.order.value = WindowDlgManager.search.orderSql();
}
// ------------------------------------------------------------
function FWindowDlgManager(){
   this.className = 'FWindowDlgManager';
   // Attribute
   this.datasetNode = null;
   this.search = null;
   this.winCtl = null;
   this.dsCtl = null;
   this.editors = new Array();
   // Html
   this.linkHTML = null;
   this.linkHTable = null;
   // Event
   this.onEventInitialize = mgr_sch_onEventInitialize;
   this.onEventKeydown = mgr_sch_onEventKeydown;
   // Method
   this.createElement = mgr_schdl_createElement;
   this.doSearch = mgr_schdl_doSearch;
   this.save = mgr_schdl_save;
   this.clear = mgr_schdl_clear;
   this.refreshSearch = mgr_schdl_refreshSearch;
   this.refresh = mgr_schdl_refresh;
   this.createCtl = mgr_schdl_createCtl;
   this.createCtlText = mgr_schdl_createCtlText;
   return this;
}
IEngine.register('WindowDlgManager', 'FWindowDlgManager');
// ------------------------------------------------------------
function mgr_schdl_createElement(sTag){
   return document.createElement(sTag);
}
// ------------------------------------------------------------
function mgr_sch_onEventInitialize(){
   this.linkHTML = id_search;
   this.winCtl = dialogArguments['winctl'];
   this.dsCtl = dialogArguments['dsctl'];
   this.search = dialogArguments['search'];
   SearchManager = dialogArguments['SearchManager'];
   alert(this.winCtl + ' - ' + this.dsCtl);
   if(!this.winCtl || !this.dsCtl){
      return false;
   }
   this.refreshSearch();
   this.refresh();
   if(this.editors.length > 0){
      this.editors[0].focus();
   }
}
// ------------------------------------------------------------
function mgr_sch_onEventKeydown(oCWin){
   var nKeyCode = oCWin.event.keyCode;
   if(nKeyCode == IKeyCode.ESC){
      window.close();
   }else if(nKeyCode == IKeyCode.ENTER){
      WindowDlgManager.doSearch();
   }
}
// ------------------------------------------------------------
function mgr_schdl_doSearch(){
   window.focus();
   dialogArguments['result'] = 'ok';
   window.close()
}
// ------------------------------------------------------------
function mgr_schdl_save(){
   var sSearch = prompt('Save this search:', '');
   if(!IString.isEmpty(sSearch)){
      SearchManager.saveSearch(this.winCtl.name, this.dsCtl.name, sSearch, this.search);
   }
}
// ------------------------------------------------------------
function mgr_schdl_clear(){
   this.activeSearchNode = IXML.createNode('Search');
   this.refresh();
}
// ------------------------------------------------------------
function mgr_schdl_refreshSearch(){
   var oSelect = id_search;
   var nCount = oSelect.childNodes.length;
   for(var n=nCount-1; n>=0; n--){
      oSelect.childNodes[n].removeNode(true)
   }
   var oSl = SearchManager.findSearchList(this.winCtl.name, this.dsCtl.name);
   if(oSl){
      for(var n=0; n<oSl.size(); n++){
         var oSearch = oSl.value(n);
         var oOption = this.createElement('OPTION');
         oOption.value = oSearch.name;
         oOption.innerText = oSearch.name;
         oSelect.appendChild(oOption);
      }
   }
}
// ------------------------------------------------------------
function mgr_schdl_refresh(){
   document.body.disabled = true;
   if(this.linkHTable){
      this.linkHTML.removeChild(this.linkHTable);
   }

   this.linkHTable = document.createElement('TABLE');
   this.linkHTML.insertBefore(this.linkHTable);

   var oCtls = this.dsCtl.dsControls;
   for(var n=0; n<oCtls.length; n++){
      var oCtl = oCtls[n];
      var sType = oCtl.type;
      if(oCtl.searchAble){
         if(sType == 'edit' || sType == 'number' || sType == 'selcombobox' ||
               sType == 'datepicker' || sType == 'checkbox' || sType == 'column' ||
               sType == 'radiobutton' || sType == 'combobox' || sType == 'memo'){
            this.createCtl(oCtl);
         }
      }
   }
   document.body.disabled = false;
}
function mgr_schdl_createCtl(oCtl){
   var oHRow = this.linkHTable.insertRow();

   var oHTltCell = oHRow.insertCell();
   oHTltCell.innerText = IString.nvl(IString.nvl(oCtl.label, oCtl.dataName), oCtl.name);

   var oHValCell = oHRow.insertCell();
   var sType = oCtl.config.attribute('type').toLowerCase();
   this.createCtlText(oHValCell, oCtl);

   var oHSrtOrdCell = oHRow.insertCell();
   var oHSrdOrdCtl = document.createElement('INPUT');
   oHSrdOrdCtl.className = 'comNumber';
   oHSrdOrdCtl.size = 2;
   oHSrdOrdCtl.maxLength = 2;
   oHSrtOrdCell.insertBefore(oHSrdOrdCtl);

   var oHSrtCell = oHRow.insertCell();
   var oSrtSel = document.createElement('SELECT');
   oSrtSel.className = 'comComboBox';
   var oHO1 = document.createElement('OPTION');
   oSrtSel.insertBefore(oHO1);
   var oHO2 = document.createElement('OPTION');
   oHO2.value = 'ASC';
   oHO2.innerText = 'ASC';
   oSrtSel.insertBefore(oHO2);
   var oHO3 = document.createElement('OPTION');
   oHO3.value = 'DESC';
   oHO3.innerText = 'DESC';
   oSrtSel.insertBefore(oHO3);
   oHSrtCell.insertBefore(oSrtSel);

   oSrtSel.linkCfg = oCtl;
   oSrtSel.linkCtl = this;
   oSrtSel.onchange = function(){
      WindowDlgManager.search.field(this.linkCfg.dataName).setOrder(this.value);
   };

   oSrtSel.value = this.search.field(oCtl.dataName).order();
}
function mgr_schdl_createCtlText(oHCell, oCtl){
   var oHCtl = document.createElement('INPUT');
   this.editors.push(oHCtl);
   oHCtl.type = 'text';
   oHCtl.value = this.search.field(oCtl.dataName).value();
   oHCtl.linkCfg = oCtl;
   oHCtl.linkCtl = this;
   if(oHCell){
      oHCell.insertBefore(oHCtl);
   }
   oHCtl.onchange = mgr_schdl_text_change;
}
function mgr_schdl_text_change(){
   WindowDlgManager.search.field(this.linkCfg.dataName).setValue(this.value);
}
</SCRIPT>

<js:body styleClass='frmWork' jstop='Y' scroll='no'>
<js:form name='frmConsole'>

<TABLE width='100%' height='100%' border='0' cellspacing='0' cellpadding='4'>
<TR><TD colspan='2' height='20' style="filter:progid:DXImageTransform.Microsoft.Gradient(gradienttype=1, startcolorstr=blue, endcolorstr=#FFFFFF);">
   <FONT color='#FFFFFF'><B>Data Search</B></FONT>
</TD></TR>
<TR valign='top'>
   <TD width='100%'>
      <TABLE width='100%' height='100%' border='0' cellspacing='0' cellpadding='4'>
         <TR><TD height='40px'>
            Save Queries
            <SELECT id='id_search' style='width:100%'></SELECT>
         </TD></TR>
         <TR height='20px'><TD valign='top'>
            <TABLE width='100%' border='0' cellspacing='0' cellpadding='0'><TR>
               <TD id='id_query'>Query | <FONT color='blue' onclick="showPage('a')" style='cursor:hand'>Advanced</FONT></TD>
               <TD id='id_advanced' style='display:none'><FONT color='blue' onclick="showPage('q')" style='cursor:hand'>Query</FONT> | Advanced</TD>
               <TD align='right'><INPUT name='case_value' type='checkbox' class='comCheckBox' checked onclick='showPage()'> Case sensitive</TD>
            </TR></TABLE>
         </TD></TR>
         <TR id='id_query_info'><TD valign='top'>
            <TABLE width='100%' height='100%' border='0' cellspacing='1' cellpadding='4' bgcolor='#666666'>
               <TR valign='top' bgcolor='#FFFFFF'><TD>
                  <DIV id='id_search'></DIV>
               </TD></TR>
            </TABLE>
         </TD></TR>
         <TR id='id_advanced_info' style='display:none'><TD valign='top'>
            <TABLE width='100%' height='100%' border='0' cellspacing='1' cellpadding='2'>
               <TR height='18px'><TD>
                  SQL Where Expression
               </TD></TR>
               <TR><TD>
                  <TEXTAREA name='where' style='width:100%;height:100%'></TEXTAREA>
               </TD></TR>
               <TR height='18px'><TD>
                  SQL Order By Expression
               </TD></TR>
               <TR valign='top' height='60px'><TD>
                  <TEXTAREA name='order' style='width:100%;height:100%'></TEXTAREA>
               </TD></TR>
            </TABLE>
         </TD></TR>
      </TABLE>
   </TD>
   <TD width='200px'>
      <TABLE width='100%' border='0' cellspacing='0' cellpadding='4'>
         <TR><TD><jh:button caption='trs:button.ok|OK' width='100px' action='WindowDlgManager.doSearch()'/></TD></TR>
         <TR><TD><jh:button caption='trs:button.cancel|Cancel' width='100px' action='window.close()'/></TD></TR>
         <TR><TD><jh:button caption='trs:button.clear|Clear' width='100px' action='WindowDlgManager.clear()'/></TD></TR>
         <TR><TD><jh:button caption='trs:button.count|Count' width='100px'/></TD></TR>
         <TR><TD><jh:img src='/res/img/n.gif'/></TD></TR>
         <TR><TD><jh:button caption='trs:button.save|Save' width='100px' action='WindowDlgManager.save()'/></TD></TR>
         <TR><TD><jh:button caption='trs:button.remove|Remove' width='100px' action='WindowDlgManager.remove()'/></TD></TR>
      </TABLE>
   </TD>
<TR>
</TABLE>

</js:form>
</js:body>
</HTML>

<%@ include file="/inc/page/end.inc" %>
