package org.mo.cloud.editor.core.message.base;

import org.mo.cloud.editor.core.message.common.XObjectFace;
import org.mo.cloud.editor.core.message.common.XObjectSource;
import org.mo.cloud.editor.core.message.common.XValidationFace;
import org.mo.com.lang.FMultiString;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.lang.face.AName;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlObject;
import org.mo.com.xml.IXmlObject;

//============================================================
// <T>数据项对象的XML节点基类。</T>
//============================================================
public abstract class XBaseMessageItem
      extends FXmlObject
      implements
         XObjectFace,
         XValidationFace,
         XObjectSource
{
   // 名称定义
   public static final String NAME = "Item";

   //============================================================
   // <T>获得名称定义。</T>
   //
   // @return 名称定义
   //============================================================
   public String name(){
      return NAME;
   }

   //============================================================
   // <T>判断是否指定名称。</T>
   //
   // @param name 名称
   // @return 是否指定
   //============================================================
   public static boolean isName(String name){
      return NAME.equals(name);
   }

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param xobject 对象
   // @return 是否指定
   //============================================================
   public static boolean isInstance(IXmlObject xobject){
      return NAME.equals(xobject.name());
   }

   // 名称的名称定义
   public static final String PTY_NAME = "name";

   // 标签的名称定义
   public static final String PTY_LABEL = "label";

   // 有效性的名称定义
   public static final String PTY_IS_VALID = "is_valid";

   // 注释的名称定义
   public static final String PTY_NOTE = "note";

   // 非空检查的名称定义
   public static final String PTY_VALID_EMPTY = "valid_empty";

   // 最小长度检查的名称定义
   public static final String PTY_VALID_LENGTH_MIN = "valid_length_min";

   // 最大长度检查的名称定义
   public static final String PTY_VALID_LENGTH_MAX = "valid_length_max";

   // 最小值检查的名称定义
   public static final String PTY_VALID_VALUE_MIN = "valid_value_min";

   // 最大值检查的名称定义
   public static final String PTY_VALID_VALUE_MAX = "valid_value_max";

   // 最小长度包含检查的名称定义
   public static final String PTY_VALID_LENGTH_MIN_EQ = "valid_length_min_eq";

   // 最大长度包含检查的名称定义
   public static final String PTY_VALID_LENGTH_MAX_EQ = "valid_length_max_eq";

   // 有效格式检查的名称定义
   public static final String PTY_VALID_FORMAT_VALID = "valid_format_valid";

   // 无效格式检查的名称定义
   public static final String PTY_VALID_FORMAT_INVALID = "valid_format_invalid";

   // 时间日期检查的名称定义
   public static final String PTY_VALID_DATETIME = "valid_datetime";

   // 日期检查的名称定义
   public static final String PTY_VALID_DATE = "valid_date";

   // 时间检查的名称定义
   public static final String PTY_VALID_TIME = "valid_time";

   // 特殊检查的名称定义
   public static final String PTY_VALID_SPECIAL = "valid_special";

   // 服务器的名称定义
   public static final String PTY_IS_SERVER = "is_server";

   // 服务器CPP代码的名称定义
   public static final String PTY_IS_SERVER_CPP = "is_server_cpp";

   // 服务器JAVA代码的名称定义
   public static final String PTY_IS_SERVER_JAVA = "is_server_java";

   // 客户端的名称定义
   public static final String PTY_IS_CLIENT = "is_client";

   // 客户端CPP代码的名称定义
   public static final String PTY_IS_CLIENT_CPP = "is_client_cpp";

   // 客户端AS代码的名称定义
   public static final String PTY_IS_CLIENT_AS = "is_client_as";

   // 客户端CS代码的名称定义
   public static final String PTY_IS_CLIENT_CS = "is_client_cs";

   // 客户端JAVA代码的名称定义
   public static final String PTY_IS_CLIENT_JAVA = "is_client_java";

   // 类型的名称定义
   public static final String PTY_TYPE = "type";

   // 内容的名称定义
   public static final String PTY_VALUE = "value";

   // 热键的名称定义
   public static final String PTY_HOTKEY = "hotkey";

   // 类型的名称定义
   public static final String PTY_TYPE_CD = "type_cd";

   // 类型名称的名称定义
   public static final String PTY_TYPE_NAME = "type_name";

   // CS类型的名称定义
   public static final String PTY_TYPE_CS = "type_cs";

   // AS类型的名称定义
   public static final String PTY_TYPE_AS = "type_as";

   // 集合的名称定义
   public static final String PTY_IS_COLLECTION = "is_collection";

   // 节点的名称定义
   public static final String PTY_IS_NODE = "is_node";

   // 数据大小的名称定义
   public static final String PTY_DATA_SIZE = "data_size";

   // 数据默认值的名称定义
   public static final String PTY_DATA_DEFAULT = "data_default";

   // 名称的定义
   @AName("name")
   protected String _name;

   // 标签的定义
   @AName("label")
   protected String _label;

   // 有效性的定义
   @AName("is_valid")
   protected Boolean _isValid = Boolean.FALSE;

   // 注释的定义
   @AName("note")
   protected FMultiString _note = new FMultiString();

   // 非空检查的定义
   @AName("valid_empty")
   protected String _validEmpty;

   // 最小长度检查的定义
   @AName("valid_length_min")
   protected Boolean _validLengthMin = Boolean.FALSE;

   // 最大长度检查的定义
   @AName("valid_length_max")
   protected FMultiString _validLengthMax = new FMultiString();

   // 最小值检查的定义
   @AName("valid_value_min")
   protected String _validValueMin;

   // 最大值检查的定义
   @AName("valid_value_max")
   protected String _validValueMax;

   // 最小长度包含检查的定义
   @AName("valid_length_min_eq")
   protected String _validLengthMinEq;

   // 最大长度包含检查的定义
   @AName("valid_length_max_eq")
   protected String _validLengthMaxEq;

   // 有效格式检查的定义
   @AName("valid_format_valid")
   protected String _validFormatValid;

   // 无效格式检查的定义
   @AName("valid_format_invalid")
   protected String _validFormatInvalid;

   // 时间日期检查的定义
   @AName("valid_datetime")
   protected String _validDatetime;

   // 日期检查的定义
   @AName("valid_date")
   protected String _validDate;

   // 时间检查的定义
   @AName("valid_time")
   protected String _validTime;

   // 特殊检查的定义
   @AName("valid_special")
   protected String _validSpecial;

   // 服务器的定义
   @AName("is_server")
   protected String _isServer;

   // 服务器CPP代码的定义
   @AName("is_server_cpp")
   protected String _isServerCpp;

   // 服务器JAVA代码的定义
   @AName("is_server_java")
   protected String _isServerJava;

   // 客户端的定义
   @AName("is_client")
   protected String _isClient;

   // 客户端CPP代码的定义
   @AName("is_client_cpp")
   protected String _isClientCpp;

   // 客户端AS代码的定义
   @AName("is_client_as")
   protected String _isClientAs;

   // 客户端CS代码的定义
   @AName("is_client_cs")
   protected String _isClientCs;

   // 客户端JAVA代码的定义
   @AName("is_client_java")
   protected String _isClientJava;

   // 类型的定义
   @AName("type")
   protected String _type;

   // 内容的定义
   @AName("value")
   protected String _value;

   // 热键的定义
   @AName("hotkey")
   protected String _hotkey;

   // 类型的定义
   @AName("type_cd")
   protected String _typeCd;

   // 类型名称的定义
   @AName("type_name")
   protected String _typeName;

   // CS类型的定义
   @AName("type_cs")
   protected String _typeCs;

   // AS类型的定义
   @AName("type_as")
   protected String _typeAs;

   // 集合的定义
   @AName("is_collection")
   protected String _isCollection;

   // 节点的定义
   @AName("is_node")
   protected String _isNode;

   // 数据大小的定义
   @AName("data_size")
   protected String _dataSize;

   // 数据默认值的定义
   @AName("data_default")
   protected String _dataDefault;

   //============================================================
   // <T>获得名称的内容。</T>
   //
   // @return 名称
   //============================================================
   public String getName(){
      return _name;
   }

   //============================================================
   // <T>设置名称的内容。</T>
   //
   // @param value 名称
   //============================================================
   public void setName(String value){
      _name = value;
   }

   //============================================================
   // <T>获得标签的内容。</T>
   //
   // @return 标签
   //============================================================
   public String getLabel(){
      return _label;
   }

   //============================================================
   // <T>设置标签的内容。</T>
   //
   // @param value 标签
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public Boolean getIsValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setIsValid(Boolean value){
      _isValid = value;
   }

   //============================================================
   // <T>获得注释的内容。</T>
   //
   // @return 注释
   //============================================================
   public String getNote(){
      return _note.get();
   }

   //============================================================
   // <T>设置注释的内容。</T>
   //
   // @param value 注释
   //============================================================
   public void setNote(String value){
      _note.set(value);
   }

   //============================================================
   // <T>获得非空检查的内容。</T>
   //
   // @return 非空检查
   //============================================================
   public String getValidEmpty(){
      return _validEmpty;
   }

   //============================================================
   // <T>设置非空检查的内容。</T>
   //
   // @param value 非空检查
   //============================================================
   public void setValidEmpty(String value){
      _validEmpty = value;
   }

   //============================================================
   // <T>获得最小长度检查的内容。</T>
   //
   // @return 最小长度检查
   //============================================================
   public Boolean getValidLengthMin(){
      return _validLengthMin;
   }

   //============================================================
   // <T>设置最小长度检查的内容。</T>
   //
   // @param value 最小长度检查
   //============================================================
   public void setValidLengthMin(Boolean value){
      _validLengthMin = value;
   }

   //============================================================
   // <T>获得最大长度检查的内容。</T>
   //
   // @return 最大长度检查
   //============================================================
   public String getValidLengthMax(){
      return _validLengthMax.get();
   }

   //============================================================
   // <T>设置最大长度检查的内容。</T>
   //
   // @param value 最大长度检查
   //============================================================
   public void setValidLengthMax(String value){
      _validLengthMax.set(value);
   }

   //============================================================
   // <T>获得最小值检查的内容。</T>
   //
   // @return 最小值检查
   //============================================================
   public String getValidValueMin(){
      return _validValueMin;
   }

   //============================================================
   // <T>设置最小值检查的内容。</T>
   //
   // @param value 最小值检查
   //============================================================
   public void setValidValueMin(String value){
      _validValueMin = value;
   }

   //============================================================
   // <T>获得最大值检查的内容。</T>
   //
   // @return 最大值检查
   //============================================================
   public String getValidValueMax(){
      return _validValueMax;
   }

   //============================================================
   // <T>设置最大值检查的内容。</T>
   //
   // @param value 最大值检查
   //============================================================
   public void setValidValueMax(String value){
      _validValueMax = value;
   }

   //============================================================
   // <T>获得最小长度包含检查的内容。</T>
   //
   // @return 最小长度包含检查
   //============================================================
   public String getValidLengthMinEq(){
      return _validLengthMinEq;
   }

   //============================================================
   // <T>设置最小长度包含检查的内容。</T>
   //
   // @param value 最小长度包含检查
   //============================================================
   public void setValidLengthMinEq(String value){
      _validLengthMinEq = value;
   }

   //============================================================
   // <T>获得最大长度包含检查的内容。</T>
   //
   // @return 最大长度包含检查
   //============================================================
   public String getValidLengthMaxEq(){
      return _validLengthMaxEq;
   }

   //============================================================
   // <T>设置最大长度包含检查的内容。</T>
   //
   // @param value 最大长度包含检查
   //============================================================
   public void setValidLengthMaxEq(String value){
      _validLengthMaxEq = value;
   }

   //============================================================
   // <T>获得有效格式检查的内容。</T>
   //
   // @return 有效格式检查
   //============================================================
   public String getValidFormatValid(){
      return _validFormatValid;
   }

   //============================================================
   // <T>设置有效格式检查的内容。</T>
   //
   // @param value 有效格式检查
   //============================================================
   public void setValidFormatValid(String value){
      _validFormatValid = value;
   }

   //============================================================
   // <T>获得无效格式检查的内容。</T>
   //
   // @return 无效格式检查
   //============================================================
   public String getValidFormatInvalid(){
      return _validFormatInvalid;
   }

   //============================================================
   // <T>设置无效格式检查的内容。</T>
   //
   // @param value 无效格式检查
   //============================================================
   public void setValidFormatInvalid(String value){
      _validFormatInvalid = value;
   }

   //============================================================
   // <T>获得时间日期检查的内容。</T>
   //
   // @return 时间日期检查
   //============================================================
   public String getValidDatetime(){
      return _validDatetime;
   }

   //============================================================
   // <T>设置时间日期检查的内容。</T>
   //
   // @param value 时间日期检查
   //============================================================
   public void setValidDatetime(String value){
      _validDatetime = value;
   }

   //============================================================
   // <T>获得日期检查的内容。</T>
   //
   // @return 日期检查
   //============================================================
   public String getValidDate(){
      return _validDate;
   }

   //============================================================
   // <T>设置日期检查的内容。</T>
   //
   // @param value 日期检查
   //============================================================
   public void setValidDate(String value){
      _validDate = value;
   }

   //============================================================
   // <T>获得时间检查的内容。</T>
   //
   // @return 时间检查
   //============================================================
   public String getValidTime(){
      return _validTime;
   }

   //============================================================
   // <T>设置时间检查的内容。</T>
   //
   // @param value 时间检查
   //============================================================
   public void setValidTime(String value){
      _validTime = value;
   }

   //============================================================
   // <T>获得特殊检查的内容。</T>
   //
   // @return 特殊检查
   //============================================================
   public String getValidSpecial(){
      return _validSpecial;
   }

   //============================================================
   // <T>设置特殊检查的内容。</T>
   //
   // @param value 特殊检查
   //============================================================
   public void setValidSpecial(String value){
      _validSpecial = value;
   }

   //============================================================
   // <T>获得服务器的内容。</T>
   //
   // @return 服务器
   //============================================================
   public String getIsServer(){
      return _isServer;
   }

   //============================================================
   // <T>设置服务器的内容。</T>
   //
   // @param value 服务器
   //============================================================
   public void setIsServer(String value){
      _isServer = value;
   }

   //============================================================
   // <T>获得服务器CPP代码的内容。</T>
   //
   // @return 服务器CPP代码
   //============================================================
   public String getIsServerCpp(){
      return _isServerCpp;
   }

   //============================================================
   // <T>设置服务器CPP代码的内容。</T>
   //
   // @param value 服务器CPP代码
   //============================================================
   public void setIsServerCpp(String value){
      _isServerCpp = value;
   }

   //============================================================
   // <T>获得服务器JAVA代码的内容。</T>
   //
   // @return 服务器JAVA代码
   //============================================================
   public String getIsServerJava(){
      return _isServerJava;
   }

   //============================================================
   // <T>设置服务器JAVA代码的内容。</T>
   //
   // @param value 服务器JAVA代码
   //============================================================
   public void setIsServerJava(String value){
      _isServerJava = value;
   }

   //============================================================
   // <T>获得客户端的内容。</T>
   //
   // @return 客户端
   //============================================================
   public String getIsClient(){
      return _isClient;
   }

   //============================================================
   // <T>设置客户端的内容。</T>
   //
   // @param value 客户端
   //============================================================
   public void setIsClient(String value){
      _isClient = value;
   }

   //============================================================
   // <T>获得客户端CPP代码的内容。</T>
   //
   // @return 客户端CPP代码
   //============================================================
   public String getIsClientCpp(){
      return _isClientCpp;
   }

   //============================================================
   // <T>设置客户端CPP代码的内容。</T>
   //
   // @param value 客户端CPP代码
   //============================================================
   public void setIsClientCpp(String value){
      _isClientCpp = value;
   }

   //============================================================
   // <T>获得客户端AS代码的内容。</T>
   //
   // @return 客户端AS代码
   //============================================================
   public String getIsClientAs(){
      return _isClientAs;
   }

   //============================================================
   // <T>设置客户端AS代码的内容。</T>
   //
   // @param value 客户端AS代码
   //============================================================
   public void setIsClientAs(String value){
      _isClientAs = value;
   }

   //============================================================
   // <T>获得客户端CS代码的内容。</T>
   //
   // @return 客户端CS代码
   //============================================================
   public String getIsClientCs(){
      return _isClientCs;
   }

   //============================================================
   // <T>设置客户端CS代码的内容。</T>
   //
   // @param value 客户端CS代码
   //============================================================
   public void setIsClientCs(String value){
      _isClientCs = value;
   }

   //============================================================
   // <T>获得客户端JAVA代码的内容。</T>
   //
   // @return 客户端JAVA代码
   //============================================================
   public String getIsClientJava(){
      return _isClientJava;
   }

   //============================================================
   // <T>设置客户端JAVA代码的内容。</T>
   //
   // @param value 客户端JAVA代码
   //============================================================
   public void setIsClientJava(String value){
      _isClientJava = value;
   }

   //============================================================
   // <T>获得类型的内容。</T>
   //
   // @return 类型
   //============================================================
   public String getType(){
      return _type;
   }

   //============================================================
   // <T>设置类型的内容。</T>
   //
   // @param value 类型
   //============================================================
   public void setType(String value){
      _type = value;
   }

   //============================================================
   // <T>获得内容的内容。</T>
   //
   // @return 内容
   //============================================================
   public String getValue(){
      return _value;
   }

   //============================================================
   // <T>设置内容的内容。</T>
   //
   // @param value 内容
   //============================================================
   public void setValue(String value){
      _value = value;
   }

   //============================================================
   // <T>获得热键的内容。</T>
   //
   // @return 热键
   //============================================================
   public String getHotkey(){
      return _hotkey;
   }

   //============================================================
   // <T>设置热键的内容。</T>
   //
   // @param value 热键
   //============================================================
   public void setHotkey(String value){
      _hotkey = value;
   }

   //============================================================
   // <T>获得类型的内容。</T>
   //
   // @return 类型
   //============================================================
   public String getTypeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置类型的内容。</T>
   //
   // @param value 类型
   //============================================================
   public void setTypeCd(String value){
      _typeCd = value;
   }

   //============================================================
   // <T>获得类型名称的内容。</T>
   //
   // @return 类型名称
   //============================================================
   public String getTypeName(){
      return _typeName;
   }

   //============================================================
   // <T>设置类型名称的内容。</T>
   //
   // @param value 类型名称
   //============================================================
   public void setTypeName(String value){
      _typeName = value;
   }

   //============================================================
   // <T>获得CS类型的内容。</T>
   //
   // @return CS类型
   //============================================================
   public String getTypeCs(){
      return _typeCs;
   }

   //============================================================
   // <T>设置CS类型的内容。</T>
   //
   // @param value CS类型
   //============================================================
   public void setTypeCs(String value){
      _typeCs = value;
   }

   //============================================================
   // <T>获得AS类型的内容。</T>
   //
   // @return AS类型
   //============================================================
   public String getTypeAs(){
      return _typeAs;
   }

   //============================================================
   // <T>设置AS类型的内容。</T>
   //
   // @param value AS类型
   //============================================================
   public void setTypeAs(String value){
      _typeAs = value;
   }

   //============================================================
   // <T>获得集合的内容。</T>
   //
   // @return 集合
   //============================================================
   public String getIsCollection(){
      return _isCollection;
   }

   //============================================================
   // <T>设置集合的内容。</T>
   //
   // @param value 集合
   //============================================================
   public void setIsCollection(String value){
      _isCollection = value;
   }

   //============================================================
   // <T>获得节点的内容。</T>
   //
   // @return 节点
   //============================================================
   public String getIsNode(){
      return _isNode;
   }

   //============================================================
   // <T>设置节点的内容。</T>
   //
   // @param value 节点
   //============================================================
   public void setIsNode(String value){
      _isNode = value;
   }

   //============================================================
   // <T>获得数据大小的内容。</T>
   //
   // @return 数据大小
   //============================================================
   public String getDataSize(){
      return _dataSize;
   }

   //============================================================
   // <T>设置数据大小的内容。</T>
   //
   // @param value 数据大小
   //============================================================
   public void setDataSize(String value){
      _dataSize = value;
   }

   //============================================================
   // <T>获得数据默认值的内容。</T>
   //
   // @return 数据默认值
   //============================================================
   public String getDataDefault(){
      return _dataDefault;
   }

   //============================================================
   // <T>设置数据默认值的内容。</T>
   //
   // @param value 数据默认值
   //============================================================
   public void setDataDefault(String value){
      _dataDefault = value;
   }

   //============================================================
   // <T>内部获得内容置信息。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   public String innerGet(String name){
      if(RString.isEmpty(name)){
         return null;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         return getName();
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         return getLabel();
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         return RBoolean.toString(getIsValid());
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         return getNote();
      }else if(PTY_VALID_EMPTY.equalsIgnoreCase(name)){
         return getValidEmpty();
      }else if(PTY_VALID_LENGTH_MIN.equalsIgnoreCase(name)){
         return RBoolean.toString(getValidLengthMin());
      }else if(PTY_VALID_LENGTH_MAX.equalsIgnoreCase(name)){
         return getValidLengthMax();
      }else if(PTY_VALID_VALUE_MIN.equalsIgnoreCase(name)){
         return getValidValueMin();
      }else if(PTY_VALID_VALUE_MAX.equalsIgnoreCase(name)){
         return getValidValueMax();
      }else if(PTY_VALID_LENGTH_MIN_EQ.equalsIgnoreCase(name)){
         return getValidLengthMinEq();
      }else if(PTY_VALID_LENGTH_MAX_EQ.equalsIgnoreCase(name)){
         return getValidLengthMaxEq();
      }else if(PTY_VALID_FORMAT_VALID.equalsIgnoreCase(name)){
         return getValidFormatValid();
      }else if(PTY_VALID_FORMAT_INVALID.equalsIgnoreCase(name)){
         return getValidFormatInvalid();
      }else if(PTY_VALID_DATETIME.equalsIgnoreCase(name)){
         return getValidDatetime();
      }else if(PTY_VALID_DATE.equalsIgnoreCase(name)){
         return getValidDate();
      }else if(PTY_VALID_TIME.equalsIgnoreCase(name)){
         return getValidTime();
      }else if(PTY_VALID_SPECIAL.equalsIgnoreCase(name)){
         return getValidSpecial();
      }else if(PTY_IS_SERVER.equalsIgnoreCase(name)){
         return getIsServer();
      }else if(PTY_IS_SERVER_CPP.equalsIgnoreCase(name)){
         return getIsServerCpp();
      }else if(PTY_IS_SERVER_JAVA.equalsIgnoreCase(name)){
         return getIsServerJava();
      }else if(PTY_IS_CLIENT.equalsIgnoreCase(name)){
         return getIsClient();
      }else if(PTY_IS_CLIENT_CPP.equalsIgnoreCase(name)){
         return getIsClientCpp();
      }else if(PTY_IS_CLIENT_AS.equalsIgnoreCase(name)){
         return getIsClientAs();
      }else if(PTY_IS_CLIENT_CS.equalsIgnoreCase(name)){
         return getIsClientCs();
      }else if(PTY_IS_CLIENT_JAVA.equalsIgnoreCase(name)){
         return getIsClientJava();
      }else if(PTY_TYPE.equalsIgnoreCase(name)){
         return getType();
      }else if(PTY_VALUE.equalsIgnoreCase(name)){
         return getValue();
      }else if(PTY_HOTKEY.equalsIgnoreCase(name)){
         return getHotkey();
      }else if(PTY_TYPE_CD.equalsIgnoreCase(name)){
         return getTypeCd();
      }else if(PTY_TYPE_NAME.equalsIgnoreCase(name)){
         return getTypeName();
      }else if(PTY_TYPE_CS.equalsIgnoreCase(name)){
         return getTypeCs();
      }else if(PTY_TYPE_AS.equalsIgnoreCase(name)){
         return getTypeAs();
      }else if(PTY_IS_COLLECTION.equalsIgnoreCase(name)){
         return getIsCollection();
      }else if(PTY_IS_NODE.equalsIgnoreCase(name)){
         return getIsNode();
      }else if(PTY_DATA_SIZE.equalsIgnoreCase(name)){
         return getDataSize();
      }else if(PTY_DATA_DEFAULT.equalsIgnoreCase(name)){
         return getDataDefault();
      }
      return null;
   }

   //============================================================
   // <T>内部设置内容置信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   public void innerSet(String name,
                        String value){
      if(RString.isEmpty(name)){
         return;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         setName(value);
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         setLabel(value);
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         setIsValid(RBoolean.parse(value));
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         setNote(value);
      }else if(PTY_VALID_EMPTY.equalsIgnoreCase(name)){
         setValidEmpty(value);
      }else if(PTY_VALID_LENGTH_MIN.equalsIgnoreCase(name)){
         setValidLengthMin(RBoolean.parse(value));
      }else if(PTY_VALID_LENGTH_MAX.equalsIgnoreCase(name)){
         setValidLengthMax(value);
      }else if(PTY_VALID_VALUE_MIN.equalsIgnoreCase(name)){
         setValidValueMin(value);
      }else if(PTY_VALID_VALUE_MAX.equalsIgnoreCase(name)){
         setValidValueMax(value);
      }else if(PTY_VALID_LENGTH_MIN_EQ.equalsIgnoreCase(name)){
         setValidLengthMinEq(value);
      }else if(PTY_VALID_LENGTH_MAX_EQ.equalsIgnoreCase(name)){
         setValidLengthMaxEq(value);
      }else if(PTY_VALID_FORMAT_VALID.equalsIgnoreCase(name)){
         setValidFormatValid(value);
      }else if(PTY_VALID_FORMAT_INVALID.equalsIgnoreCase(name)){
         setValidFormatInvalid(value);
      }else if(PTY_VALID_DATETIME.equalsIgnoreCase(name)){
         setValidDatetime(value);
      }else if(PTY_VALID_DATE.equalsIgnoreCase(name)){
         setValidDate(value);
      }else if(PTY_VALID_TIME.equalsIgnoreCase(name)){
         setValidTime(value);
      }else if(PTY_VALID_SPECIAL.equalsIgnoreCase(name)){
         setValidSpecial(value);
      }else if(PTY_IS_SERVER.equalsIgnoreCase(name)){
         setIsServer(value);
      }else if(PTY_IS_SERVER_CPP.equalsIgnoreCase(name)){
         setIsServerCpp(value);
      }else if(PTY_IS_SERVER_JAVA.equalsIgnoreCase(name)){
         setIsServerJava(value);
      }else if(PTY_IS_CLIENT.equalsIgnoreCase(name)){
         setIsClient(value);
      }else if(PTY_IS_CLIENT_CPP.equalsIgnoreCase(name)){
         setIsClientCpp(value);
      }else if(PTY_IS_CLIENT_AS.equalsIgnoreCase(name)){
         setIsClientAs(value);
      }else if(PTY_IS_CLIENT_CS.equalsIgnoreCase(name)){
         setIsClientCs(value);
      }else if(PTY_IS_CLIENT_JAVA.equalsIgnoreCase(name)){
         setIsClientJava(value);
      }else if(PTY_TYPE.equalsIgnoreCase(name)){
         setType(value);
      }else if(PTY_VALUE.equalsIgnoreCase(name)){
         setValue(value);
      }else if(PTY_HOTKEY.equalsIgnoreCase(name)){
         setHotkey(value);
      }else if(PTY_TYPE_CD.equalsIgnoreCase(name)){
         setTypeCd(value);
      }else if(PTY_TYPE_NAME.equalsIgnoreCase(name)){
         setTypeName(value);
      }else if(PTY_TYPE_CS.equalsIgnoreCase(name)){
         setTypeCs(value);
      }else if(PTY_TYPE_AS.equalsIgnoreCase(name)){
         setTypeAs(value);
      }else if(PTY_IS_COLLECTION.equalsIgnoreCase(name)){
         setIsCollection(value);
      }else if(PTY_IS_NODE.equalsIgnoreCase(name)){
         setIsNode(value);
      }else if(PTY_DATA_SIZE.equalsIgnoreCase(name)){
         setDataSize(value);
      }else if(PTY_DATA_DEFAULT.equalsIgnoreCase(name)){
         setDataDefault(value);
      }
   }

   //============================================================
   // <T>加载设置信息。</T>
   //
   // @param config 设置信息
   // @param type 类型
   //============================================================
   public void loadConfig(FXmlNode config,
                          EXmlConfig type){
      super.loadConfig(config, type);
      if(EXmlConfig.Full == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            _note.unpack(config.get(PTY_NOTE));
         }
         if(config.contains("valid_empty")){
            setValidEmpty(config.get(PTY_VALID_EMPTY));
         }
         if(config.contains("valid_length_min")){
            setValidLengthMin(RBoolean.parse(config.get(PTY_VALID_LENGTH_MIN)));
         }
         if(config.contains("valid_length_max")){
            _validLengthMax.unpack(config.get(PTY_VALID_LENGTH_MAX));
         }
         if(config.contains("valid_value_min")){
            setValidValueMin(config.get(PTY_VALID_VALUE_MIN));
         }
         if(config.contains("valid_value_max")){
            setValidValueMax(config.get(PTY_VALID_VALUE_MAX));
         }
         if(config.contains("valid_length_min_eq")){
            setValidLengthMinEq(config.get(PTY_VALID_LENGTH_MIN_EQ));
         }
         if(config.contains("valid_length_max_eq")){
            setValidLengthMaxEq(config.get(PTY_VALID_LENGTH_MAX_EQ));
         }
         if(config.contains("valid_format_valid")){
            setValidFormatValid(config.get(PTY_VALID_FORMAT_VALID));
         }
         if(config.contains("valid_format_invalid")){
            setValidFormatInvalid(config.get(PTY_VALID_FORMAT_INVALID));
         }
         if(config.contains("valid_datetime")){
            setValidDatetime(config.get(PTY_VALID_DATETIME));
         }
         if(config.contains("valid_date")){
            setValidDate(config.get(PTY_VALID_DATE));
         }
         if(config.contains("valid_time")){
            setValidTime(config.get(PTY_VALID_TIME));
         }
         if(config.contains("valid_special")){
            setValidSpecial(config.get(PTY_VALID_SPECIAL));
         }
         if(config.contains("is_server")){
            setIsServer(config.get(PTY_IS_SERVER));
         }
         if(config.contains("is_server_cpp")){
            setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
         }
         if(config.contains("is_server_java")){
            setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
         }
         if(config.contains("is_client")){
            setIsClient(config.get(PTY_IS_CLIENT));
         }
         if(config.contains("is_client_cpp")){
            setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
         }
         if(config.contains("is_client_as")){
            setIsClientAs(config.get(PTY_IS_CLIENT_AS));
         }
         if(config.contains("is_client_cs")){
            setIsClientCs(config.get(PTY_IS_CLIENT_CS));
         }
         if(config.contains("is_client_java")){
            setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
         }
         if(config.contains("type")){
            setType(config.get(PTY_TYPE));
         }
         if(config.contains("value")){
            setValue(config.get(PTY_VALUE));
         }
         if(config.contains("hotkey")){
            setHotkey(config.get(PTY_HOTKEY));
         }
         if(config.contains("type_cd")){
            setTypeCd(config.get(PTY_TYPE_CD));
         }
         if(config.contains("type_name")){
            setTypeName(config.get(PTY_TYPE_NAME));
         }
         if(config.contains("type_cs")){
            setTypeCs(config.get(PTY_TYPE_CS));
         }
         if(config.contains("type_as")){
            setTypeAs(config.get(PTY_TYPE_AS));
         }
         if(config.contains("is_collection")){
            setIsCollection(config.get(PTY_IS_COLLECTION));
         }
         if(config.contains("is_node")){
            setIsNode(config.get(PTY_IS_NODE));
         }
         if(config.contains("data_size")){
            setDataSize(config.get(PTY_DATA_SIZE));
         }
         if(config.contains("data_default")){
            setDataDefault(config.get(PTY_DATA_DEFAULT));
         }
      }else if(EXmlConfig.Simple == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("valid_empty")){
            setValidEmpty(config.get(PTY_VALID_EMPTY));
         }
         if(config.contains("valid_length_min")){
            setValidLengthMin(RBoolean.parse(config.get(PTY_VALID_LENGTH_MIN)));
         }
         if(config.contains("valid_length_max")){
            setValidLengthMax(config.get(PTY_VALID_LENGTH_MAX));
         }
         if(config.contains("valid_value_min")){
            setValidValueMin(config.get(PTY_VALID_VALUE_MIN));
         }
         if(config.contains("valid_value_max")){
            setValidValueMax(config.get(PTY_VALID_VALUE_MAX));
         }
         if(config.contains("valid_length_min_eq")){
            setValidLengthMinEq(config.get(PTY_VALID_LENGTH_MIN_EQ));
         }
         if(config.contains("valid_length_max_eq")){
            setValidLengthMaxEq(config.get(PTY_VALID_LENGTH_MAX_EQ));
         }
         if(config.contains("valid_format_valid")){
            setValidFormatValid(config.get(PTY_VALID_FORMAT_VALID));
         }
         if(config.contains("valid_format_invalid")){
            setValidFormatInvalid(config.get(PTY_VALID_FORMAT_INVALID));
         }
         if(config.contains("valid_datetime")){
            setValidDatetime(config.get(PTY_VALID_DATETIME));
         }
         if(config.contains("valid_date")){
            setValidDate(config.get(PTY_VALID_DATE));
         }
         if(config.contains("valid_time")){
            setValidTime(config.get(PTY_VALID_TIME));
         }
         if(config.contains("valid_special")){
            setValidSpecial(config.get(PTY_VALID_SPECIAL));
         }
         if(config.contains("is_server")){
            setIsServer(config.get(PTY_IS_SERVER));
         }
         if(config.contains("is_server_cpp")){
            setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
         }
         if(config.contains("is_server_java")){
            setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
         }
         if(config.contains("is_client")){
            setIsClient(config.get(PTY_IS_CLIENT));
         }
         if(config.contains("is_client_cpp")){
            setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
         }
         if(config.contains("is_client_as")){
            setIsClientAs(config.get(PTY_IS_CLIENT_AS));
         }
         if(config.contains("is_client_cs")){
            setIsClientCs(config.get(PTY_IS_CLIENT_CS));
         }
         if(config.contains("is_client_java")){
            setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
         }
         if(config.contains("type")){
            setType(config.get(PTY_TYPE));
         }
         if(config.contains("value")){
            setValue(config.get(PTY_VALUE));
         }
         if(config.contains("hotkey")){
            setHotkey(config.get(PTY_HOTKEY));
         }
         if(config.contains("type_cd")){
            setTypeCd(config.get(PTY_TYPE_CD));
         }
         if(config.contains("type_name")){
            setTypeName(config.get(PTY_TYPE_NAME));
         }
         if(config.contains("type_cs")){
            setTypeCs(config.get(PTY_TYPE_CS));
         }
         if(config.contains("type_as")){
            setTypeAs(config.get(PTY_TYPE_AS));
         }
         if(config.contains("is_collection")){
            setIsCollection(config.get(PTY_IS_COLLECTION));
         }
         if(config.contains("is_node")){
            setIsNode(config.get(PTY_IS_NODE));
         }
         if(config.contains("data_size")){
            setDataSize(config.get(PTY_DATA_SIZE));
         }
         if(config.contains("data_default")){
            setDataDefault(config.get(PTY_DATA_DEFAULT));
         }
      }else if(EXmlConfig.Value == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("valid_empty")){
            setValidEmpty(config.get(PTY_VALID_EMPTY));
         }
         if(config.contains("valid_length_min")){
            setValidLengthMin(RBoolean.parse(config.get(PTY_VALID_LENGTH_MIN)));
         }
         if(config.contains("valid_length_max")){
            setValidLengthMax(config.get(PTY_VALID_LENGTH_MAX));
         }
         if(config.contains("valid_value_min")){
            setValidValueMin(config.get(PTY_VALID_VALUE_MIN));
         }
         if(config.contains("valid_value_max")){
            setValidValueMax(config.get(PTY_VALID_VALUE_MAX));
         }
         if(config.contains("valid_length_min_eq")){
            setValidLengthMinEq(config.get(PTY_VALID_LENGTH_MIN_EQ));
         }
         if(config.contains("valid_length_max_eq")){
            setValidLengthMaxEq(config.get(PTY_VALID_LENGTH_MAX_EQ));
         }
         if(config.contains("valid_format_valid")){
            setValidFormatValid(config.get(PTY_VALID_FORMAT_VALID));
         }
         if(config.contains("valid_format_invalid")){
            setValidFormatInvalid(config.get(PTY_VALID_FORMAT_INVALID));
         }
         if(config.contains("valid_datetime")){
            setValidDatetime(config.get(PTY_VALID_DATETIME));
         }
         if(config.contains("valid_date")){
            setValidDate(config.get(PTY_VALID_DATE));
         }
         if(config.contains("valid_time")){
            setValidTime(config.get(PTY_VALID_TIME));
         }
         if(config.contains("valid_special")){
            setValidSpecial(config.get(PTY_VALID_SPECIAL));
         }
         if(config.contains("is_server")){
            setIsServer(config.get(PTY_IS_SERVER));
         }
         if(config.contains("is_server_cpp")){
            setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
         }
         if(config.contains("is_server_java")){
            setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
         }
         if(config.contains("is_client")){
            setIsClient(config.get(PTY_IS_CLIENT));
         }
         if(config.contains("is_client_cpp")){
            setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
         }
         if(config.contains("is_client_as")){
            setIsClientAs(config.get(PTY_IS_CLIENT_AS));
         }
         if(config.contains("is_client_cs")){
            setIsClientCs(config.get(PTY_IS_CLIENT_CS));
         }
         if(config.contains("is_client_java")){
            setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
         }
         if(config.contains("type")){
            setType(config.get(PTY_TYPE));
         }
         if(config.contains("value")){
            setValue(config.get(PTY_VALUE));
         }
         if(config.contains("hotkey")){
            setHotkey(config.get(PTY_HOTKEY));
         }
         if(config.contains("type_cd")){
            setTypeCd(config.get(PTY_TYPE_CD));
         }
         if(config.contains("type_name")){
            setTypeName(config.get(PTY_TYPE_NAME));
         }
         if(config.contains("type_cs")){
            setTypeCs(config.get(PTY_TYPE_CS));
         }
         if(config.contains("type_as")){
            setTypeAs(config.get(PTY_TYPE_AS));
         }
         if(config.contains("is_collection")){
            setIsCollection(config.get(PTY_IS_COLLECTION));
         }
         if(config.contains("is_node")){
            setIsNode(config.get(PTY_IS_NODE));
         }
         if(config.contains("data_size")){
            setDataSize(config.get(PTY_DATA_SIZE));
         }
         if(config.contains("data_default")){
            setDataDefault(config.get(PTY_DATA_DEFAULT));
         }
      }else if(EXmlConfig.Default == type){
         if(RString.isEmpty(getValidValueMin())){
            if(config.contains("valid_value_min")){
               setValidValueMin(config.get(PTY_VALID_VALUE_MIN));
            }
         }
         if(RString.isEmpty(getValidValueMax())){
            if(config.contains("valid_value_max")){
               setValidValueMax(config.get(PTY_VALID_VALUE_MAX));
            }
         }
         if(RString.isEmpty(getValidLengthMinEq())){
            if(config.contains("valid_length_min_eq")){
               setValidLengthMinEq(config.get(PTY_VALID_LENGTH_MIN_EQ));
            }
         }
         if(RString.isEmpty(getValidLengthMaxEq())){
            if(config.contains("valid_length_max_eq")){
               setValidLengthMaxEq(config.get(PTY_VALID_LENGTH_MAX_EQ));
            }
         }
         if(RString.isEmpty(getValidFormatValid())){
            if(config.contains("valid_format_valid")){
               setValidFormatValid(config.get(PTY_VALID_FORMAT_VALID));
            }
         }
         if(RString.isEmpty(getValidFormatInvalid())){
            if(config.contains("valid_format_invalid")){
               setValidFormatInvalid(config.get(PTY_VALID_FORMAT_INVALID));
            }
         }
         if(RString.isEmpty(getValidDatetime())){
            if(config.contains("valid_datetime")){
               setValidDatetime(config.get(PTY_VALID_DATETIME));
            }
         }
         if(RString.isEmpty(getValidDate())){
            if(config.contains("valid_date")){
               setValidDate(config.get(PTY_VALID_DATE));
            }
         }
         if(RString.isEmpty(getValidTime())){
            if(config.contains("valid_time")){
               setValidTime(config.get(PTY_VALID_TIME));
            }
         }
         if(RString.isEmpty(getValidSpecial())){
            if(config.contains("valid_special")){
               setValidSpecial(config.get(PTY_VALID_SPECIAL));
            }
         }
         if(RString.isEmpty(getIsServer())){
            if(config.contains("is_server")){
               setIsServer(config.get(PTY_IS_SERVER));
            }
         }
         if(RString.isEmpty(getIsServerCpp())){
            if(config.contains("is_server_cpp")){
               setIsServerCpp(config.get(PTY_IS_SERVER_CPP));
            }
         }
         if(RString.isEmpty(getIsServerJava())){
            if(config.contains("is_server_java")){
               setIsServerJava(config.get(PTY_IS_SERVER_JAVA));
            }
         }
         if(RString.isEmpty(getIsClient())){
            if(config.contains("is_client")){
               setIsClient(config.get(PTY_IS_CLIENT));
            }
         }
         if(RString.isEmpty(getIsClientCpp())){
            if(config.contains("is_client_cpp")){
               setIsClientCpp(config.get(PTY_IS_CLIENT_CPP));
            }
         }
         if(RString.isEmpty(getIsClientAs())){
            if(config.contains("is_client_as")){
               setIsClientAs(config.get(PTY_IS_CLIENT_AS));
            }
         }
         if(RString.isEmpty(getIsClientCs())){
            if(config.contains("is_client_cs")){
               setIsClientCs(config.get(PTY_IS_CLIENT_CS));
            }
         }
         if(RString.isEmpty(getIsClientJava())){
            if(config.contains("is_client_java")){
               setIsClientJava(config.get(PTY_IS_CLIENT_JAVA));
            }
         }
         if(RString.isEmpty(getTypeCd())){
            if(config.contains("type_cd")){
               setTypeCd(config.get(PTY_TYPE_CD));
            }
         }
         if(RString.isEmpty(getTypeName())){
            if(config.contains("type_name")){
               setTypeName(config.get(PTY_TYPE_NAME));
            }
         }
         if(RString.isEmpty(getTypeCs())){
            if(config.contains("type_cs")){
               setTypeCs(config.get(PTY_TYPE_CS));
            }
         }
         if(RString.isEmpty(getTypeAs())){
            if(config.contains("type_as")){
               setTypeAs(config.get(PTY_TYPE_AS));
            }
         }
         if(RString.isEmpty(getIsCollection())){
            if(config.contains("is_collection")){
               setIsCollection(config.get(PTY_IS_COLLECTION));
            }
         }
         if(RString.isEmpty(getIsNode())){
            if(config.contains("is_node")){
               setIsNode(config.get(PTY_IS_NODE));
            }
         }
         if(RString.isEmpty(getDataSize())){
            if(config.contains("data_size")){
               setDataSize(config.get(PTY_DATA_SIZE));
            }
         }
         if(RString.isEmpty(getDataDefault())){
            if(config.contains("data_default")){
               setDataDefault(config.get(PTY_DATA_DEFAULT));
            }
         }
      }
   }

   //============================================================
   // <T>保存设置信息。</T>
   //
   // @param config 设置信息
   // @param type 类型
   //============================================================
   public void saveConfig(FXmlNode config,
                          EXmlConfig type){
      config.setName(NAME);
      super.saveConfig(config, type);
      if(EXmlConfig.Full == type){
         if(RString.isNotEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(RString.isNotEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         String note = _note.pack().toString();
         if(RString.isNotEmpty(note)){
            config.set(PTY_NOTE, note);
         }
         if(RString.isNotEmpty(getValidEmpty())){
            config.set(PTY_VALID_EMPTY, getValidEmpty());
         }
         if(RBoolean.parse(getValidLengthMin())){
            config.set(PTY_VALID_LENGTH_MIN, RBoolean.toString(getValidLengthMin()));
         }
         String validLengthMax = _validLengthMax.pack().toString();
         if(RString.isNotEmpty(validLengthMax)){
            config.set(PTY_VALID_LENGTH_MAX, validLengthMax);
         }
         if(RString.isNotEmpty(getValidValueMin())){
            config.set(PTY_VALID_VALUE_MIN, getValidValueMin());
         }
         if(RString.isNotEmpty(getValidValueMax())){
            config.set(PTY_VALID_VALUE_MAX, getValidValueMax());
         }
         if(RString.isNotEmpty(getValidLengthMinEq())){
            config.set(PTY_VALID_LENGTH_MIN_EQ, getValidLengthMinEq());
         }
         if(RString.isNotEmpty(getValidLengthMaxEq())){
            config.set(PTY_VALID_LENGTH_MAX_EQ, getValidLengthMaxEq());
         }
         if(RString.isNotEmpty(getValidFormatValid())){
            config.set(PTY_VALID_FORMAT_VALID, getValidFormatValid());
         }
         if(RString.isNotEmpty(getValidFormatInvalid())){
            config.set(PTY_VALID_FORMAT_INVALID, getValidFormatInvalid());
         }
         if(RString.isNotEmpty(getValidDatetime())){
            config.set(PTY_VALID_DATETIME, getValidDatetime());
         }
         if(RString.isNotEmpty(getValidDate())){
            config.set(PTY_VALID_DATE, getValidDate());
         }
         if(RString.isNotEmpty(getValidTime())){
            config.set(PTY_VALID_TIME, getValidTime());
         }
         if(RString.isNotEmpty(getValidSpecial())){
            config.set(PTY_VALID_SPECIAL, getValidSpecial());
         }
         if(RString.isNotEmpty(getIsServer())){
            config.set(PTY_IS_SERVER, getIsServer());
         }
         if(RString.isNotEmpty(getIsServerCpp())){
            config.set(PTY_IS_SERVER_CPP, getIsServerCpp());
         }
         if(RString.isNotEmpty(getIsServerJava())){
            config.set(PTY_IS_SERVER_JAVA, getIsServerJava());
         }
         if(RString.isNotEmpty(getIsClient())){
            config.set(PTY_IS_CLIENT, getIsClient());
         }
         if(RString.isNotEmpty(getIsClientCpp())){
            config.set(PTY_IS_CLIENT_CPP, getIsClientCpp());
         }
         if(RString.isNotEmpty(getIsClientAs())){
            config.set(PTY_IS_CLIENT_AS, getIsClientAs());
         }
         if(RString.isNotEmpty(getIsClientCs())){
            config.set(PTY_IS_CLIENT_CS, getIsClientCs());
         }
         if(RString.isNotEmpty(getIsClientJava())){
            config.set(PTY_IS_CLIENT_JAVA, getIsClientJava());
         }
         if(RString.isNotEmpty(getType())){
            config.set(PTY_TYPE, getType());
         }
         if(RString.isNotEmpty(getValue())){
            config.set(PTY_VALUE, getValue());
         }
         if(RString.isNotEmpty(getHotkey())){
            config.set(PTY_HOTKEY, getHotkey());
         }
         if(RString.isNotEmpty(getTypeCd())){
            config.set(PTY_TYPE_CD, getTypeCd());
         }
         if(RString.isNotEmpty(getTypeName())){
            config.set(PTY_TYPE_NAME, getTypeName());
         }
         if(RString.isNotEmpty(getTypeCs())){
            config.set(PTY_TYPE_CS, getTypeCs());
         }
         if(RString.isNotEmpty(getTypeAs())){
            config.set(PTY_TYPE_AS, getTypeAs());
         }
         if(RString.isNotEmpty(getIsCollection())){
            config.set(PTY_IS_COLLECTION, getIsCollection());
         }
         if(RString.isNotEmpty(getIsNode())){
            config.set(PTY_IS_NODE, getIsNode());
         }
         if(RString.isNotEmpty(getDataSize())){
            config.set(PTY_DATA_SIZE, getDataSize());
         }
         if(RString.isNotEmpty(getDataDefault())){
            config.set(PTY_DATA_DEFAULT, getDataDefault());
         }
      }else if(EXmlConfig.Simple == type){
         if(RString.isNotEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(RString.isNotEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         if(RString.isNotEmpty(getNote())){
            config.set(PTY_NOTE, getNote());
         }
         if(RString.isNotEmpty(getValidEmpty())){
            config.set(PTY_VALID_EMPTY, getValidEmpty());
         }
         if(RBoolean.parse(getValidLengthMin())){
            config.set(PTY_VALID_LENGTH_MIN, RBoolean.toString(getValidLengthMin()));
         }
         if(RString.isNotEmpty(getValidLengthMax())){
            config.set(PTY_VALID_LENGTH_MAX, getValidLengthMax());
         }
         if(RString.isNotEmpty(getValidValueMin())){
            config.set(PTY_VALID_VALUE_MIN, getValidValueMin());
         }
         if(RString.isNotEmpty(getValidValueMax())){
            config.set(PTY_VALID_VALUE_MAX, getValidValueMax());
         }
         if(RString.isNotEmpty(getValidLengthMinEq())){
            config.set(PTY_VALID_LENGTH_MIN_EQ, getValidLengthMinEq());
         }
         if(RString.isNotEmpty(getValidLengthMaxEq())){
            config.set(PTY_VALID_LENGTH_MAX_EQ, getValidLengthMaxEq());
         }
         if(RString.isNotEmpty(getValidFormatValid())){
            config.set(PTY_VALID_FORMAT_VALID, getValidFormatValid());
         }
         if(RString.isNotEmpty(getValidFormatInvalid())){
            config.set(PTY_VALID_FORMAT_INVALID, getValidFormatInvalid());
         }
         if(RString.isNotEmpty(getValidDatetime())){
            config.set(PTY_VALID_DATETIME, getValidDatetime());
         }
         if(RString.isNotEmpty(getValidDate())){
            config.set(PTY_VALID_DATE, getValidDate());
         }
         if(RString.isNotEmpty(getValidTime())){
            config.set(PTY_VALID_TIME, getValidTime());
         }
         if(RString.isNotEmpty(getValidSpecial())){
            config.set(PTY_VALID_SPECIAL, getValidSpecial());
         }
         if(RString.isNotEmpty(getIsServer())){
            config.set(PTY_IS_SERVER, getIsServer());
         }
         if(RString.isNotEmpty(getIsServerCpp())){
            config.set(PTY_IS_SERVER_CPP, getIsServerCpp());
         }
         if(RString.isNotEmpty(getIsServerJava())){
            config.set(PTY_IS_SERVER_JAVA, getIsServerJava());
         }
         if(RString.isNotEmpty(getIsClient())){
            config.set(PTY_IS_CLIENT, getIsClient());
         }
         if(RString.isNotEmpty(getIsClientCpp())){
            config.set(PTY_IS_CLIENT_CPP, getIsClientCpp());
         }
         if(RString.isNotEmpty(getIsClientAs())){
            config.set(PTY_IS_CLIENT_AS, getIsClientAs());
         }
         if(RString.isNotEmpty(getIsClientCs())){
            config.set(PTY_IS_CLIENT_CS, getIsClientCs());
         }
         if(RString.isNotEmpty(getIsClientJava())){
            config.set(PTY_IS_CLIENT_JAVA, getIsClientJava());
         }
         if(RString.isNotEmpty(getType())){
            config.set(PTY_TYPE, getType());
         }
         if(RString.isNotEmpty(getValue())){
            config.set(PTY_VALUE, getValue());
         }
         if(RString.isNotEmpty(getHotkey())){
            config.set(PTY_HOTKEY, getHotkey());
         }
         if(RString.isNotEmpty(getTypeCd())){
            config.set(PTY_TYPE_CD, getTypeCd());
         }
         if(RString.isNotEmpty(getTypeName())){
            config.set(PTY_TYPE_NAME, getTypeName());
         }
         if(RString.isNotEmpty(getTypeCs())){
            config.set(PTY_TYPE_CS, getTypeCs());
         }
         if(RString.isNotEmpty(getTypeAs())){
            config.set(PTY_TYPE_AS, getTypeAs());
         }
         if(RString.isNotEmpty(getIsCollection())){
            config.set(PTY_IS_COLLECTION, getIsCollection());
         }
         if(RString.isNotEmpty(getIsNode())){
            config.set(PTY_IS_NODE, getIsNode());
         }
         if(RString.isNotEmpty(getDataSize())){
            config.set(PTY_DATA_SIZE, getDataSize());
         }
         if(RString.isNotEmpty(getDataDefault())){
            config.set(PTY_DATA_DEFAULT, getDataDefault());
         }
      }else if(EXmlConfig.Value == type){
         String sName = getName();
         if(RString.isNotEmpty(sName)){
            config.set(PTY_NAME, sName);
         }
         String sLabel = getLabel();
         if(RString.isNotEmpty(sLabel)){
            config.set(PTY_LABEL, sLabel);
         }
         Boolean bIsValid = getIsValid();
         if(RBoolean.parse(bIsValid)){
            config.set(PTY_IS_VALID, RBoolean.toString(bIsValid));
         }
         String sNote = getNote();
         if(RString.isNotEmpty(sNote)){
            config.set(PTY_NOTE, sNote);
         }
         String sValidEmpty = getValidEmpty();
         if(RString.isNotEmpty(sValidEmpty)){
            config.set(PTY_VALID_EMPTY, sValidEmpty);
         }
         Boolean bValidLengthMin = getValidLengthMin();
         if(RBoolean.parse(bValidLengthMin)){
            config.set(PTY_VALID_LENGTH_MIN, RBoolean.toString(bValidLengthMin));
         }
         String sValidLengthMax = getValidLengthMax();
         if(RString.isNotEmpty(sValidLengthMax)){
            config.set(PTY_VALID_LENGTH_MAX, sValidLengthMax);
         }
         String sValidValueMin = getValidValueMin();
         if(RString.isNotEmpty(sValidValueMin)){
            config.set(PTY_VALID_VALUE_MIN, sValidValueMin);
         }
         String sValidValueMax = getValidValueMax();
         if(RString.isNotEmpty(sValidValueMax)){
            config.set(PTY_VALID_VALUE_MAX, sValidValueMax);
         }
         String sValidLengthMinEq = getValidLengthMinEq();
         if(RString.isNotEmpty(sValidLengthMinEq)){
            config.set(PTY_VALID_LENGTH_MIN_EQ, sValidLengthMinEq);
         }
         String sValidLengthMaxEq = getValidLengthMaxEq();
         if(RString.isNotEmpty(sValidLengthMaxEq)){
            config.set(PTY_VALID_LENGTH_MAX_EQ, sValidLengthMaxEq);
         }
         String sValidFormatValid = getValidFormatValid();
         if(RString.isNotEmpty(sValidFormatValid)){
            config.set(PTY_VALID_FORMAT_VALID, sValidFormatValid);
         }
         String sValidFormatInvalid = getValidFormatInvalid();
         if(RString.isNotEmpty(sValidFormatInvalid)){
            config.set(PTY_VALID_FORMAT_INVALID, sValidFormatInvalid);
         }
         String sValidDatetime = getValidDatetime();
         if(RString.isNotEmpty(sValidDatetime)){
            config.set(PTY_VALID_DATETIME, sValidDatetime);
         }
         String sValidDate = getValidDate();
         if(RString.isNotEmpty(sValidDate)){
            config.set(PTY_VALID_DATE, sValidDate);
         }
         String sValidTime = getValidTime();
         if(RString.isNotEmpty(sValidTime)){
            config.set(PTY_VALID_TIME, sValidTime);
         }
         String sValidSpecial = getValidSpecial();
         if(RString.isNotEmpty(sValidSpecial)){
            config.set(PTY_VALID_SPECIAL, sValidSpecial);
         }
         String sIsServer = getIsServer();
         if(RString.isNotEmpty(sIsServer)){
            config.set(PTY_IS_SERVER, sIsServer);
         }
         String sIsServerCpp = getIsServerCpp();
         if(RString.isNotEmpty(sIsServerCpp)){
            config.set(PTY_IS_SERVER_CPP, sIsServerCpp);
         }
         String sIsServerJava = getIsServerJava();
         if(RString.isNotEmpty(sIsServerJava)){
            config.set(PTY_IS_SERVER_JAVA, sIsServerJava);
         }
         String sIsClient = getIsClient();
         if(RString.isNotEmpty(sIsClient)){
            config.set(PTY_IS_CLIENT, sIsClient);
         }
         String sIsClientCpp = getIsClientCpp();
         if(RString.isNotEmpty(sIsClientCpp)){
            config.set(PTY_IS_CLIENT_CPP, sIsClientCpp);
         }
         String sIsClientAs = getIsClientAs();
         if(RString.isNotEmpty(sIsClientAs)){
            config.set(PTY_IS_CLIENT_AS, sIsClientAs);
         }
         String sIsClientCs = getIsClientCs();
         if(RString.isNotEmpty(sIsClientCs)){
            config.set(PTY_IS_CLIENT_CS, sIsClientCs);
         }
         String sIsClientJava = getIsClientJava();
         if(RString.isNotEmpty(sIsClientJava)){
            config.set(PTY_IS_CLIENT_JAVA, sIsClientJava);
         }
         String sType = getType();
         if(RString.isNotEmpty(sType)){
            config.set(PTY_TYPE, sType);
         }
         String sValue = getValue();
         if(RString.isNotEmpty(sValue)){
            config.set(PTY_VALUE, sValue);
         }
         String sHotkey = getHotkey();
         if(RString.isNotEmpty(sHotkey)){
            config.set(PTY_HOTKEY, sHotkey);
         }
         String sTypeCd = getTypeCd();
         if(RString.isNotEmpty(sTypeCd)){
            config.set(PTY_TYPE_CD, sTypeCd);
         }
         String sTypeName = getTypeName();
         if(RString.isNotEmpty(sTypeName)){
            config.set(PTY_TYPE_NAME, sTypeName);
         }
         String sTypeCs = getTypeCs();
         if(RString.isNotEmpty(sTypeCs)){
            config.set(PTY_TYPE_CS, sTypeCs);
         }
         String sTypeAs = getTypeAs();
         if(RString.isNotEmpty(sTypeAs)){
            config.set(PTY_TYPE_AS, sTypeAs);
         }
         String sIsCollection = getIsCollection();
         if(RString.isNotEmpty(sIsCollection)){
            config.set(PTY_IS_COLLECTION, sIsCollection);
         }
         String sIsNode = getIsNode();
         if(RString.isNotEmpty(sIsNode)){
            config.set(PTY_IS_NODE, sIsNode);
         }
         String sDataSize = getDataSize();
         if(RString.isNotEmpty(sDataSize)){
            config.set(PTY_DATA_SIZE, sDataSize);
         }
         String sDataDefault = getDataDefault();
         if(RString.isNotEmpty(sDataDefault)){
            config.set(PTY_DATA_DEFAULT, sDataDefault);
         }
      }else if(EXmlConfig.Default == type){
         String sValidValueMin = getValidValueMin();
         if(RString.isNotEmpty(sValidValueMin)){
            config.set(PTY_VALID_VALUE_MIN, sValidValueMin);
         }
         String sValidValueMax = getValidValueMax();
         if(RString.isNotEmpty(sValidValueMax)){
            config.set(PTY_VALID_VALUE_MAX, sValidValueMax);
         }
         String sValidLengthMinEq = getValidLengthMinEq();
         if(RString.isNotEmpty(sValidLengthMinEq)){
            config.set(PTY_VALID_LENGTH_MIN_EQ, sValidLengthMinEq);
         }
         String sValidLengthMaxEq = getValidLengthMaxEq();
         if(RString.isNotEmpty(sValidLengthMaxEq)){
            config.set(PTY_VALID_LENGTH_MAX_EQ, sValidLengthMaxEq);
         }
         String sValidFormatValid = getValidFormatValid();
         if(RString.isNotEmpty(sValidFormatValid)){
            config.set(PTY_VALID_FORMAT_VALID, sValidFormatValid);
         }
         String sValidFormatInvalid = getValidFormatInvalid();
         if(RString.isNotEmpty(sValidFormatInvalid)){
            config.set(PTY_VALID_FORMAT_INVALID, sValidFormatInvalid);
         }
         String sValidDatetime = getValidDatetime();
         if(RString.isNotEmpty(sValidDatetime)){
            config.set(PTY_VALID_DATETIME, sValidDatetime);
         }
         String sValidDate = getValidDate();
         if(RString.isNotEmpty(sValidDate)){
            config.set(PTY_VALID_DATE, sValidDate);
         }
         String sValidTime = getValidTime();
         if(RString.isNotEmpty(sValidTime)){
            config.set(PTY_VALID_TIME, sValidTime);
         }
         String sValidSpecial = getValidSpecial();
         if(RString.isNotEmpty(sValidSpecial)){
            config.set(PTY_VALID_SPECIAL, sValidSpecial);
         }
         String sIsServer = getIsServer();
         if(RString.isNotEmpty(sIsServer)){
            config.set(PTY_IS_SERVER, sIsServer);
         }
         String sIsServerCpp = getIsServerCpp();
         if(RString.isNotEmpty(sIsServerCpp)){
            config.set(PTY_IS_SERVER_CPP, sIsServerCpp);
         }
         String sIsServerJava = getIsServerJava();
         if(RString.isNotEmpty(sIsServerJava)){
            config.set(PTY_IS_SERVER_JAVA, sIsServerJava);
         }
         String sIsClient = getIsClient();
         if(RString.isNotEmpty(sIsClient)){
            config.set(PTY_IS_CLIENT, sIsClient);
         }
         String sIsClientCpp = getIsClientCpp();
         if(RString.isNotEmpty(sIsClientCpp)){
            config.set(PTY_IS_CLIENT_CPP, sIsClientCpp);
         }
         String sIsClientAs = getIsClientAs();
         if(RString.isNotEmpty(sIsClientAs)){
            config.set(PTY_IS_CLIENT_AS, sIsClientAs);
         }
         String sIsClientCs = getIsClientCs();
         if(RString.isNotEmpty(sIsClientCs)){
            config.set(PTY_IS_CLIENT_CS, sIsClientCs);
         }
         String sIsClientJava = getIsClientJava();
         if(RString.isNotEmpty(sIsClientJava)){
            config.set(PTY_IS_CLIENT_JAVA, sIsClientJava);
         }
         String sTypeCd = getTypeCd();
         if(RString.isNotEmpty(sTypeCd)){
            config.set(PTY_TYPE_CD, sTypeCd);
         }
         String sTypeName = getTypeName();
         if(RString.isNotEmpty(sTypeName)){
            config.set(PTY_TYPE_NAME, sTypeName);
         }
         String sTypeCs = getTypeCs();
         if(RString.isNotEmpty(sTypeCs)){
            config.set(PTY_TYPE_CS, sTypeCs);
         }
         String sTypeAs = getTypeAs();
         if(RString.isNotEmpty(sTypeAs)){
            config.set(PTY_TYPE_AS, sTypeAs);
         }
         String sIsCollection = getIsCollection();
         if(RString.isNotEmpty(sIsCollection)){
            config.set(PTY_IS_COLLECTION, sIsCollection);
         }
         String sIsNode = getIsNode();
         if(RString.isNotEmpty(sIsNode)){
            config.set(PTY_IS_NODE, sIsNode);
         }
         String sDataSize = getDataSize();
         if(RString.isNotEmpty(sDataSize)){
            config.set(PTY_DATA_SIZE, sDataSize);
         }
         String sDataDefault = getDataDefault();
         if(RString.isNotEmpty(sDataDefault)){
            config.set(PTY_DATA_DEFAULT, sDataDefault);
         }
      }
   }
}
