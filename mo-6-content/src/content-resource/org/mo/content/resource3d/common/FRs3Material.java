package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResource3dMaterialUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3Material
      extends FRs3Object
{
   // 主题
   protected FRs3Theme _theme;

   // 分组唯一代码
   protected String _groupGuid;

   // 效果代码
   protected String _effectCode;

   // 配置双面
   protected boolean _optionDouble;

   // 透明基础
   protected float _alphaBase;

   // 透明比率
   protected float _alphaRate;

   // 环境颜色
   protected SFloatColor4 _ambientColor = new SFloatColor4();

   // 散射颜色
   protected SFloatColor4 _diffuseColor = new SFloatColor4();

   // 散射视角颜色
   protected SFloatColor4 _diffuseViewColor = new SFloatColor4();

   // 高光颜色
   protected SFloatColor4 _specularColor = new SFloatColor4();

   // 高光级别
   protected float _specularLevel;

   // 高光视角颜色
   protected SFloatColor4 _specularViewColor = new SFloatColor4();

   // 高光视角级别
   protected float _specularViewLevel;

   // 反射颜色
   protected SFloatColor4 _reflectColor = new SFloatColor4();

   // 反射融合
   protected float _reflectMerge;

   // 前折射颜色
   protected SFloatColor4 _refractFrontColor = new SFloatColor4();

   // 后折射颜色
   protected SFloatColor4 _refractBackColor = new SFloatColor4();

   // 发光颜色
   protected SFloatColor4 _emissiveColor = new SFloatColor4();

   // 网格集合
   protected FObjects<FRs3MaterialBitmap> _bitmaps = new FObjects<FRs3MaterialBitmap>(FRs3MaterialBitmap.class);

   // 网格集合
   protected FObjects<FRs3MaterialTexture> _textures = new FObjects<FRs3MaterialTexture>(FRs3MaterialTexture.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Material(){
      _guid = RUuid.makeUniqueId();
   }

   //============================================================
   // <T>获得主题。</T>
   //
   // @return 主题
   //============================================================
   public FRs3Theme theme(){
      return _theme;
   }

   //============================================================
   // <T>设置主题。</T>
   //
   // @param theme 主题
   //============================================================
   public void setTheme(FRs3Theme theme){
      _theme = theme;
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   public String fullCode(){
      return _theme.code() + "|" + _code;
   }

   //============================================================
   // <T>获得分组唯一代码。</T>
   //
   // @return 分组唯一代码
   //============================================================
   public String groupGuid(){
      return _groupGuid;
   }

   //============================================================
   // <T>设置分组唯一代码。</T>
   //
   // @param groupGuid 分组唯一代码
   //============================================================
   public void setGroupGuid(String groupGuid){
      _groupGuid = groupGuid;
   }

   //============================================================
   // <T>获得透明基础。</T>
   //
   // @return 透明基础
   //============================================================
   public float alphaBase(){
      return _alphaBase;
   }

   //============================================================
   // <T>设置透明基础。</T>
   //
   // @param alphaBase 透明基础
   //============================================================
   public void setAlphaBase(float alphaBase){
      _alphaBase = alphaBase;
   }

   //============================================================
   // <T>获得透明比率。</T>
   //
   // @return 透明比率
   //============================================================
   public float alphaRate(){
      return _alphaRate;
   }

   //============================================================
   // <T>设置透明比率。</T>
   //
   // @param alphaRate 透明比率
   //============================================================
   public void setAlphaRate(float alphaRate){
      _alphaRate = alphaRate;
   }

   //============================================================
   // <T>获得环境颜色。</T>
   //
   // @return 环境颜色
   //============================================================
   public SFloatColor4 ambientColor(){
      return _ambientColor;
   }

   //============================================================
   // <T>获得散射颜色。</T>
   //
   // @return 散射颜色
   //============================================================
   public SFloatColor4 diffuseColor(){
      return _diffuseColor;
   }

   //============================================================
   // <T>获得高光颜色。</T>
   //
   // @return 高光颜色
   //============================================================
   public SFloatColor4 specularColor(){
      return _specularColor;
   }

   //============================================================
   // <T>获得高光级别。</T>
   //
   // @return 高光级别
   //============================================================
   public float specularLevel(){
      return _specularLevel;
   }

   //============================================================
   // <T>设置高光级别。</T>
   //
   // @param specularLevel 高光级别
   //============================================================
   public void setSpecularLevel(float specularLevel){
      _specularLevel = specularLevel;
   }

   //============================================================
   // <T>获得反射颜色。</T>
   //
   // @return 反射颜色
   //============================================================
   public SFloatColor4 reflectColor(){
      return _reflectColor;
   }

   //============================================================
   // <T>获得反射合并。</T>
   //
   // @return 反射合并
   //============================================================
   public float reflectMerge(){
      return _reflectMerge;
   }

   //============================================================
   // <T>设置反射合并。</T>
   //
   // @param reflectMerge 反射合并
   //============================================================
   public void setReflectMerge(float reflectMerge){
      _reflectMerge = reflectMerge;
   }

   //============================================================
   // <T>获得折射前颜色。</T>
   //
   // @return 折射前颜色
   //============================================================
   public SFloatColor4 refractFrontColor(){
      return _refractFrontColor;
   }

   //============================================================
   // <T>获得折射后颜色。</T>
   //
   // @return 折射后颜色
   //============================================================
   public SFloatColor4 refractBackColor(){
      return _refractBackColor;
   }

   //============================================================
   // <T>获得发光颜色。</T>
   //
   // @return 发光颜色
   //============================================================
   public SFloatColor4 emissiveColor(){
      return _emissiveColor;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3MaterialBitmap> bitmaps(){
      return _bitmaps;
   }

   //============================================================
   // <T>获得纹理集合。</T>
   //
   // @return 纹理集合
   //============================================================
   public FObjects<FRs3MaterialTexture> textures(){
      return _textures;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出属性
      output.writeString(_groupGuid);
      output.writeString(_effectCode);
      // 输出透明
      output.writeFloat(_alphaBase);
      output.writeFloat(_alphaRate);
      // 输出颜色
      _ambientColor.serialize(output);
      _diffuseColor.serialize(output);
      _diffuseViewColor.serialize(output);
      _specularColor.serialize(output);
      output.writeFloat(_specularLevel);
      _specularViewColor.serialize(output);
      output.writeFloat(_specularViewLevel);
      _reflectColor.serialize(output);
      output.writeFloat(_reflectMerge);
      _refractFrontColor.serialize(output);
      _refractBackColor.serialize(output);
      _emissiveColor.serialize(output);
      // 输出纹理集合
      int textureCount = _textures.count();
      output.writeInt16((short)textureCount);
      for(int i = 0; i < textureCount; i++){
         FRs3MaterialTexture texture = _textures.get(i);
         texture.serialize(output);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取属性
      _groupGuid = xconfig.get("group_guid");
      _effectCode = xconfig.get("effect_code");
      _optionDouble = xconfig.getBoolean("option_double", false);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Alpha")){
            _alphaBase = xnode.getFloat("base");
            _alphaRate = xnode.getFloat("rate");
         }else if(xnode.isName("Ambient")){
            _ambientColor.loadConfig(xnode);
         }else if(xnode.isName("Diffuse")){
            _diffuseColor.loadConfig(xnode);
         }else if(xnode.isName("DiffuseView")){
            _diffuseViewColor.loadConfig(xnode);
         }else if(xnode.isName("Specular")){
            _specularColor.loadConfig(xnode);
            _specularLevel = xnode.getFloat("level");
         }else if(xnode.isName("SpecularView")){
            _specularViewColor.loadConfig(xnode);
            _specularViewLevel = xnode.getFloat("level");
         }else if(xnode.isName("Reflect")){
            _reflectColor.loadConfig(xnode);
            _reflectMerge = xnode.getFloat("merge");
         }else if(xnode.isName("RefractFront")){
            _refractFrontColor.loadConfig(xnode);
         }else if(xnode.isName("RefractBack")){
            _refractBackColor.loadConfig(xnode);
         }else if(xnode.isName("Emissive")){
            _emissiveColor.loadConfig(xnode);
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储属性
      xconfig.set("group_guid", _groupGuid);
      xconfig.set("effect_code", _effectCode);
      xconfig.set("option_double", _optionDouble);
      // 存储透明
      FXmlNode xalpha = xconfig.createNode("Alpha");
      xalpha.set("base", _alphaBase);
      xalpha.set("rate", _alphaRate);
      // 存储颜色
      _ambientColor.saveConfig(xconfig.createNode("Ambient"));
      _diffuseColor.saveConfig(xconfig.createNode("Diffuse"));
      _diffuseViewColor.saveConfig(xconfig.createNode("DiffuseView"));
      FXmlNode xspecular = xconfig.createNode("Specular");
      _specularColor.saveConfig(xspecular);
      xspecular.set("level", _specularLevel);
      FXmlNode xspecularView = xconfig.createNode("SpecularView");
      _specularViewColor.saveConfig(xspecularView);
      xspecularView.set("level", _specularViewLevel);
      FXmlNode xreflect = xconfig.createNode("Reflect");
      _reflectColor.saveConfig(xreflect);
      xreflect.set("merge", _reflectMerge);
      // 存储折射
      FXmlNode xrefractFront = xconfig.createNode("RefractFront");
      _refractFrontColor.saveConfig(xrefractFront);
      FXmlNode xrefractBack = xconfig.createNode("RefractBack");
      _refractBackColor.saveConfig(xrefractBack);
      // 存储发光
      _emissiveColor.saveConfig(xconfig.createNode("Emissive"));
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public String toXml(){
      FXmlNode xconfig = new FXmlNode("Material");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dMaterialUnit unit){
      // 加载配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      this.loadConfig(xdocument.root());
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResource3dMaterialUnit unit){
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setContent(toXml());
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
      _effectCode = xconfig.get("effect_code");
      _optionDouble = xconfig.getBoolean("option_double", false);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Alpha")){
            _alphaBase = xnode.getFloat("base");
            _alphaRate = xnode.getFloat("rate");
         }else if(xnode.isName("Ambient")){
            _ambientColor.importConfig(xnode);
         }else if(xnode.isName("Diffuse")){
            _diffuseColor.importConfig(xnode);
         }else if(xnode.isName("DiffuseView")){
            _diffuseViewColor.importConfig(xnode);
         }else if(xnode.isName("Specular")){
            _specularColor.importConfig(xnode);
            _specularLevel = xnode.getFloat("level");
         }else if(xnode.isName("SpecularView")){
            _specularViewColor.importConfig(xnode);
            _specularViewLevel = xnode.getFloat("level");
         }else if(xnode.isName("Reflect")){
            _reflectColor.importConfig(xnode);
            _reflectMerge = xnode.getFloat("merge");
         }else if(xnode.isName("RefractFront")){
            _refractFrontColor.importConfig(xnode);
         }else if(xnode.isName("RefractBack")){
            _refractBackColor.importConfig(xnode);
         }else if(xnode.isName("Emissive")){
            _emissiveColor.importConfig(xnode);
         }else if(xnode.isName("TextureCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Texture")){
                  FRs3MaterialTexture texture = new FRs3MaterialTexture();
                  texture.setMaterial(this);
                  texture.importConfig(xchild);
                  _textures.push(texture);
               }
            }
         }
      }
   }
}