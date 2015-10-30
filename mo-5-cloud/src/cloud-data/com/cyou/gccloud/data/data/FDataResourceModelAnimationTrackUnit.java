package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>资源模型动画跟踪表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataResourceModelAnimationTrackUnit
      extends FLogicUnit
{
   // 存储字段对象标识的定义。
   private long __ouid;

   // 字段对象标识的定义。
   protected long _ouid;

   // 存储字段有效性的定义。
   private boolean __ovld;

   // 字段有效性的定义。
   protected boolean _ovld;

   // 存储字段全局唯一标识的定义。
   private String __guid;

   // 字段全局唯一标识的定义。
   protected String _guid;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段项目编号的定义。
   private long __projectId;

   // 字段项目编号的定义。
   protected long _projectId;

   // 存储字段模型编号的定义。
   private long __modelId;

   // 字段模型编号的定义。
   protected long _modelId;

   // 存储字段网格编号的定义。
   private long __meshId;

   // 字段网格编号的定义。
   protected long _meshId;

   // 存储字段骨骼编号的定义。
   private long __skeletonId;

   // 字段骨骼编号的定义。
   protected long _skeletonId;

   // 存储字段动画编号的定义。
   private long __animationId;

   // 字段动画编号的定义。
   protected long _animationId;

   // 存储字段骨头索引的定义。
   private int __boneIndex;

   // 字段骨头索引的定义。
   protected int _boneIndex;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段帧间隔的定义。
   private int __frameTick;

   // 字段帧间隔的定义。
   protected int _frameTick;

   // 存储字段帧数量的定义。
   private int __frameCount;

   // 字段帧数量的定义。
   protected int _frameCount;

   // 存储字段帧总长的定义。
   private int __frameTotal;

   // 字段帧总长的定义。
   protected int _frameTotal;

   // 存储字段备注的定义。
   private String __note;

   // 字段备注的定义。
   protected String _note;

   // 存储字段创建用户标识的定义。
   private long __createUserId;

   // 字段创建用户标识的定义。
   protected long _createUserId;

   // 存储字段创建日期的定义。
   private TDateTime __createDate = new TDateTime();

   // 字段创建日期的定义。
   protected TDateTime _createDate = new TDateTime();

   // 存储字段更新者标识的定义。
   private long __updateUserId;

   // 字段更新者标识的定义。
   protected long _updateUserId;

   // 存储字段更新时间的定义。
   private TDateTime __updateDate = new TDateTime();

   // 字段更新时间的定义。
   protected TDateTime _updateDate = new TDateTime();

   //============================================================
   // <T>构造资源模型动画跟踪表逻辑单元。</T>
   //============================================================
   public FDataResourceModelAnimationTrackUnit(){
   }

   //============================================================
   // <T>判断对象标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOuidChanged(){
      return __ouid != _ouid;
   }

   //============================================================
   // <T>获得对象标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long ouid(){
      return _ouid;
   }

   //============================================================
   // <T>设置对象标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOuid(long value){
      _ouid = value;
   }

   //============================================================
   // <T>判断有效性的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOvldChanged(){
      return __ovld != _ovld;
   }

   //============================================================
   // <T>获得有效性的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean ovld(){
      return _ovld;
   }

   //============================================================
   // <T>设置有效性的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOvld(boolean value){
      _ovld = value;
   }

   //============================================================
   // <T>判断全局唯一标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGuidChanged(){
      return !RString.equals(__guid, _guid);
   }

   //============================================================
   // <T>获得全局唯一标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String guid(){
      return _guid;
   }

   //============================================================
   // <T>设置全局唯一标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGuid(String value){
      _guid = value;
   }

   //============================================================
   // <T>判断用户编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUserIdChanged(){
      return __userId != _userId;
   }

   //============================================================
   // <T>获得用户编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>获得用户编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataPersonUserUnit user(){
      FDataPersonUserLogic logic = _logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit unit = logic.find(_userId);
      return unit;
   }

   //============================================================
   // <T>设置用户编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUserId(long value){
      _userId = value;
   }

   //============================================================
   // <T>判断项目编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProjectIdChanged(){
      return __projectId != _projectId;
   }

   //============================================================
   // <T>获得项目编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long projectId(){
      return _projectId;
   }

   //============================================================
   // <T>获得项目编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataSolutionProjectUnit project(){
      FDataSolutionProjectLogic logic = _logicContext.findLogic(FDataSolutionProjectLogic.class);
      FDataSolutionProjectUnit unit = logic.find(_projectId);
      return unit;
   }

   //============================================================
   // <T>设置项目编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProjectId(long value){
      _projectId = value;
   }

   //============================================================
   // <T>判断模型编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isModelIdChanged(){
      return __modelId != _modelId;
   }

   //============================================================
   // <T>获得模型编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long modelId(){
      return _modelId;
   }

   //============================================================
   // <T>获得模型编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelUnit model(){
      FDataResourceModelLogic logic = _logicContext.findLogic(FDataResourceModelLogic.class);
      FDataResourceModelUnit unit = logic.find(_modelId);
      return unit;
   }

   //============================================================
   // <T>设置模型编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setModelId(long value){
      _modelId = value;
   }

   //============================================================
   // <T>判断网格编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMeshIdChanged(){
      return __meshId != _meshId;
   }

   //============================================================
   // <T>获得网格编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long meshId(){
      return _meshId;
   }

   //============================================================
   // <T>获得网格编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelMeshUnit mesh(){
      FDataResourceModelMeshLogic logic = _logicContext.findLogic(FDataResourceModelMeshLogic.class);
      FDataResourceModelMeshUnit unit = logic.find(_meshId);
      return unit;
   }

   //============================================================
   // <T>设置网格编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMeshId(long value){
      _meshId = value;
   }

   //============================================================
   // <T>判断骨骼编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSkeletonIdChanged(){
      return __skeletonId != _skeletonId;
   }

   //============================================================
   // <T>获得骨骼编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long skeletonId(){
      return _skeletonId;
   }

   //============================================================
   // <T>获得骨骼编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelSkeletonUnit skeleton(){
      FDataResourceModelSkeletonLogic logic = _logicContext.findLogic(FDataResourceModelSkeletonLogic.class);
      FDataResourceModelSkeletonUnit unit = logic.find(_skeletonId);
      return unit;
   }

   //============================================================
   // <T>设置骨骼编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSkeletonId(long value){
      _skeletonId = value;
   }

   //============================================================
   // <T>判断动画编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAnimationIdChanged(){
      return __animationId != _animationId;
   }

   //============================================================
   // <T>获得动画编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long animationId(){
      return _animationId;
   }

   //============================================================
   // <T>获得动画编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelAnimationUnit animation(){
      FDataResourceModelAnimationLogic logic = _logicContext.findLogic(FDataResourceModelAnimationLogic.class);
      FDataResourceModelAnimationUnit unit = logic.find(_animationId);
      return unit;
   }

   //============================================================
   // <T>设置动画编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAnimationId(long value){
      _animationId = value;
   }

   //============================================================
   // <T>判断骨头索引的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBoneIndexChanged(){
      return __boneIndex != _boneIndex;
   }

   //============================================================
   // <T>获得骨头索引的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int boneIndex(){
      return _boneIndex;
   }

   //============================================================
   // <T>设置骨头索引的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBoneIndex(int value){
      _boneIndex = value;
   }

   //============================================================
   // <T>判断代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCodeChanged(){
      return !RString.equals(__code, _code);
   }

   //============================================================
   // <T>获得代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCode(String value){
      _code = value;
   }

   //============================================================
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断帧间隔的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFrameTickChanged(){
      return __frameTick != _frameTick;
   }

   //============================================================
   // <T>获得帧间隔的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int frameTick(){
      return _frameTick;
   }

   //============================================================
   // <T>设置帧间隔的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFrameTick(int value){
      _frameTick = value;
   }

   //============================================================
   // <T>判断帧数量的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFrameCountChanged(){
      return __frameCount != _frameCount;
   }

   //============================================================
   // <T>获得帧数量的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int frameCount(){
      return _frameCount;
   }

   //============================================================
   // <T>设置帧数量的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFrameCount(int value){
      _frameCount = value;
   }

   //============================================================
   // <T>判断帧总长的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFrameTotalChanged(){
      return __frameTotal != _frameTotal;
   }

   //============================================================
   // <T>获得帧总长的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int frameTotal(){
      return _frameTotal;
   }

   //============================================================
   // <T>设置帧总长的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFrameTotal(int value){
      _frameTotal = value;
   }

   //============================================================
   // <T>判断备注的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得备注的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置备注的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNote(String value){
      _note = value;
   }

   //============================================================
   // <T>判断创建用户标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCreateUserIdChanged(){
      return __createUserId != _createUserId;
   }

   //============================================================
   // <T>获得创建用户标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long createUserId(){
      return _createUserId;
   }

   //============================================================
   // <T>设置创建用户标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateUserId(long value){
      _createUserId = value;
   }

   //============================================================
   // <T>判断创建日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCreateDateChanged(){
      return !__createDate.equals(_createDate);
   }

   //============================================================
   // <T>获得创建日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime createDate(){
      return _createDate;
   }

   //============================================================
   // <T>设置创建日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateDate(TDateTime value){
      _createDate = value;
   }

   //============================================================
   // <T>判断更新者标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateUserIdChanged(){
      return __updateUserId != _updateUserId;
   }

   //============================================================
   // <T>获得更新者标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long updateUserId(){
      return _updateUserId;
   }

   //============================================================
   // <T>设置更新者标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateUserId(long value){
      _updateUserId = value;
   }

   //============================================================
   // <T>判断更新时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateDateChanged(){
      return !__updateDate.equals(_updateDate);
   }

   //============================================================
   // <T>获得更新时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime updateDate(){
      return _updateDate;
   }

   //============================================================
   // <T>设置更新时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateDate(TDateTime value){
      _updateDate = value;
   }

   //============================================================
   // <T>根据名称获得内容。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   @Override
   public String get(String name){
      switch(name){
         case "ouid":
            return Long.toString(_ouid);
         case "ovld":
            return RBoolean.toString(_ovld);
         case "guid":
            return _guid;
         case "user_id":
            return Long.toString(_userId);
         case "project_id":
            return Long.toString(_projectId);
         case "model_id":
            return Long.toString(_modelId);
         case "mesh_id":
            return Long.toString(_meshId);
         case "skeleton_id":
            return Long.toString(_skeletonId);
         case "animation_id":
            return Long.toString(_animationId);
         case "bone_index":
            return RInteger.toString(_boneIndex);
         case "code":
            return _code;
         case "label":
            return _label;
         case "frame_tick":
            return RInteger.toString(_frameTick);
         case "frame_count":
            return RInteger.toString(_frameCount);
         case "frame_total":
            return RInteger.toString(_frameTotal);
         case "note":
            return _note;
         case "create_user_id":
            return Long.toString(_createUserId);
         case "create_date":
            return _createDate.toString();
         case "update_user_id":
            return Long.toString(_updateUserId);
         case "update_date":
            return _updateDate.toString();
      }
      return null;
   }

   //============================================================
   // <T>根据名称设置内容。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void set(String name,
                   String value){
      switch(name){
         case "ouid":
            _ouid = RLong.parse(value);
            break;
         case "ovld":
            _ovld = RBoolean.parse(value);
            break;
         case "guid":
            _guid = value;
            break;
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "project_id":
            _projectId = RLong.parse(value);
            break;
         case "model_id":
            _modelId = RLong.parse(value);
            break;
         case "mesh_id":
            _meshId = RLong.parse(value);
            break;
         case "skeleton_id":
            _skeletonId = RLong.parse(value);
            break;
         case "animation_id":
            _animationId = RLong.parse(value);
            break;
         case "bone_index":
            _boneIndex = RInteger.parse(value);
            break;
         case "code":
            _code = value;
            break;
         case "label":
            _label = value;
            break;
         case "frame_tick":
            _frameTick = RInteger.parse(value);
            break;
         case "frame_count":
            _frameCount = RInteger.parse(value);
            break;
         case "frame_total":
            _frameTotal = RInteger.parse(value);
            break;
         case "note":
            _note = value;
            break;
         case "create_user_id":
            _createUserId = RLong.parse(value);
            break;
         case "create_date":
            _createDate.parse(value);
            break;
         case "update_user_id":
            _updateUserId = RLong.parse(value);
            break;
         case "update_date":
            _updateDate.parse(value);
            break;
      }
   }

   //============================================================
   // <T>加载行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void load(FRow row){
      super.load(row);
      for(IStringPair pair : row){
         String name = pair.name();
         String value = pair.value();
         switch(name){
            case "ouid":
               __ouid = RLong.parse(value);
               _ouid = __ouid;
               break;
            case "ovld":
               __ovld = RBoolean.parse(value);
               _ovld = __ovld;
               break;
            case "guid":
               __guid = value;
               _guid = __guid;
               break;
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "project_id":
               __projectId = RLong.parse(value);
               _projectId = __projectId;
               break;
            case "model_id":
               __modelId = RLong.parse(value);
               _modelId = __modelId;
               break;
            case "mesh_id":
               __meshId = RLong.parse(value);
               _meshId = __meshId;
               break;
            case "skeleton_id":
               __skeletonId = RLong.parse(value);
               _skeletonId = __skeletonId;
               break;
            case "animation_id":
               __animationId = RLong.parse(value);
               _animationId = __animationId;
               break;
            case "bone_index":
               __boneIndex = RInteger.parse(value);
               _boneIndex = __boneIndex;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "frame_tick":
               __frameTick = RInteger.parse(value);
               _frameTick = __frameTick;
               break;
            case "frame_count":
               __frameCount = RInteger.parse(value);
               _frameCount = __frameCount;
               break;
            case "frame_total":
               __frameTotal = RInteger.parse(value);
               _frameTotal = __frameTotal;
               break;
            case "note":
               __note = value;
               _note = __note;
               break;
            case "create_user_id":
               __createUserId = RLong.parse(value);
               _createUserId = __createUserId;
               break;
            case "create_date":
               __createDate.parse(value);
               _createDate.assign(__createDate);
               break;
            case "update_user_id":
               __updateUserId = RLong.parse(value);
               _updateUserId = __updateUserId;
               break;
            case "update_date":
               __updateDate.parse(value);
               _updateDate.assign(__updateDate);
               break;
         }
      }
   }

   //============================================================
   // <T>存储行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void save(FRow row){
      super.load(row);
      row.set("ouid", _ouid);
      row.set("ovld", _ovld);
      row.set("guid", _guid);
      row.set("userId", _userId);
      row.set("projectId", _projectId);
      row.set("modelId", _modelId);
      row.set("meshId", _meshId);
      row.set("skeletonId", _skeletonId);
      row.set("animationId", _animationId);
      row.set("boneIndex", _boneIndex);
      row.set("code", _code);
      row.set("label", _label);
      row.set("frameTick", _frameTick);
      row.set("frameCount", _frameCount);
      row.set("frameTotal", _frameTotal);
      row.set("note", _note);
      row.set("createUserId", _createUserId);
      row.set("createDate", _createDate);
      row.set("updateUserId", _updateUserId);
      row.set("updateDate", _updateDate);
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("ouid", RLong.toString(_ouid));
      map.put("ovld", RBoolean.toString(_ovld));
      map.put("guid", _guid);
      map.put("userId", RLong.toString(_userId));
      map.put("projectId", RLong.toString(_projectId));
      map.put("modelId", RLong.toString(_modelId));
      map.put("meshId", RLong.toString(_meshId));
      map.put("skeletonId", RLong.toString(_skeletonId));
      map.put("animationId", RLong.toString(_animationId));
      map.put("boneIndex", RInteger.toString(_boneIndex));
      map.put("code", _code);
      map.put("label", _label);
      map.put("frameTick", RInteger.toString(_frameTick));
      map.put("frameCount", RInteger.toString(_frameCount));
      map.put("frameTotal", RInteger.toString(_frameTotal));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }

   //============================================================
   // <T>反序列化数据到内容。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void unserialize(IDataInput input){
      super.unserialize(input);
      _ouid = input.readInt64();
      _ovld = input.readBoolean();
      _guid = input.readString();
      _userId = input.readInt64();
      _projectId = input.readInt64();
      _modelId = input.readInt64();
      _meshId = input.readInt64();
      _skeletonId = input.readInt64();
      _animationId = input.readInt64();
      _boneIndex = input.readInt32();
      _code = input.readString();
      _label = input.readString();
      _frameTick = input.readInt32();
      _frameCount = input.readInt32();
      _frameTotal = input.readInt32();
      _note = input.readString();
      _createUserId = input.readInt64();
      _createDate.set(input.readInt64());
      _updateUserId = input.readInt64();
      _updateDate.set(input.readInt64());
   }

   //============================================================
   // <T>序列化内容到数据。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      output.writeInt64(_ouid);
      output.writeBoolean(_ovld);
      output.writeString(_guid);
      output.writeInt64(_userId);
      output.writeInt64(_projectId);
      output.writeInt64(_modelId);
      output.writeInt64(_meshId);
      output.writeInt64(_skeletonId);
      output.writeInt64(_animationId);
      output.writeInt32(_boneIndex);
      output.writeString(_code);
      output.writeString(_label);
      output.writeInt32(_frameTick);
      output.writeInt32(_frameCount);
      output.writeInt32(_frameTotal);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }

   //============================================================
   // <T>复制当前对象。</T>
   //
   // @param unit 对象
   // @return 对象
   //============================================================
   @Override
   public void copy(FLogicUnit logicUnit){
      super.copy(logicUnit);
      FDataResourceModelAnimationTrackUnit unit = (FDataResourceModelAnimationTrackUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setUserId(_userId);
      unit.setProjectId(_projectId);
      unit.setModelId(_modelId);
      unit.setMeshId(_meshId);
      unit.setSkeletonId(_skeletonId);
      unit.setAnimationId(_animationId);
      unit.setBoneIndex(_boneIndex);
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setFrameTick(_frameTick);
      unit.setFrameCount(_frameCount);
      unit.setFrameTotal(_frameTotal);
      unit.setNote(_note);
      unit.setCreateUserId(_createUserId);
      unit.createDate().assign(_createDate);
      unit.setUpdateUserId(_updateUserId);
      unit.updateDate().assign(_updateDate);
   }

   //============================================================
   // <T>克隆当前对象。</T>
   //
   // @return 对象
   //============================================================
   @Override
   public FDataResourceModelAnimationTrackUnit clone(){
      FDataResourceModelAnimationTrackUnit unit = RClass.newInstance(FDataResourceModelAnimationTrackUnit.class);
      copy(unit);
      return unit;
   }
}
