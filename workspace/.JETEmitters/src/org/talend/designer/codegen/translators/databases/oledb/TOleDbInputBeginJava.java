package org.talend.designer.codegen.translators.databases.oledb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TOleDbInputBeginJava
{
  protected static String nl;
  public static synchronized TOleDbInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOleDbInputBeginJava result = new TOleDbInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            StringBuilder ";
  protected final String TEXT_11 = " = new StringBuilder();";
  protected final String TEXT_12 = NL + "            ";
  protected final String TEXT_13 = ".append(\"Parameters:\");";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"";
  protected final String TEXT_16 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_17 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_18 = NL + "                    ";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "                ";
  protected final String TEXT_23 = ".append(\" | \");";
  protected final String TEXT_24 = NL + "            StringBuilder ";
  protected final String TEXT_25 = " = new StringBuilder();    ";
  protected final String TEXT_26 = NL + "                    ";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                    if(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " == null){";
  protected final String TEXT_33 = NL + "                        ";
  protected final String TEXT_34 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_35 = NL + "                        ";
  protected final String TEXT_36 = ".append(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "                    }   ";
  protected final String TEXT_39 = NL + "                ";
  protected final String TEXT_40 = ".append(\"|\");";
  protected final String TEXT_41 = NL + "org.talend.net.Object conn_";
  protected final String TEXT_42 = " = org.talend.net.Object.createInstance(";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = ", " + NL + "new java.lang.Object[] { ";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = " " + NL + "});" + NL;
  protected final String TEXT_47 = NL + "conn_";
  protected final String TEXT_48 = ".invokeGeneric(\"Open\");";
  protected final String TEXT_49 = NL + NL + "org.talend.net.Object cmd_";
  protected final String TEXT_50 = " = org.talend.net.Object.createInstance(";
  protected final String TEXT_51 = ",\"System.Data.OleDb.OleDbCommand\"," + NL + "new java.lang.Object[] { ";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = NL + ", " + NL + "conn_";
  protected final String TEXT_54 = " " + NL + "});" + NL + "" + NL + "org.talend.net.Object reader_";
  protected final String TEXT_55 = " = cmd_";
  protected final String TEXT_56 = ".invoke(\"ExecuteReader\");";
  protected final String TEXT_57 = NL + "               //";
  protected final String TEXT_58 = NL + "               Integer id";
  protected final String TEXT_59 = "_";
  protected final String TEXT_60 = " = (Integer)reader_";
  protected final String TEXT_61 = ".invokeGeneric(\"GetOrdinal\"," + NL + "               new java.lang.Object[] { \"";
  protected final String TEXT_62 = "\" });" + NL + "                ";
  protected final String TEXT_63 = NL + "class TypeConverter_";
  protected final String TEXT_64 = " {" + NL + "    void doConversion(Object val, Object targetStruct, String colName) {" + NL + "            try {" + NL + "            java.lang.reflect.Field f = targetStruct.getClass().getField(colName);" + NL + "            f.setAccessible(true);" + NL + "            f.set(targetStruct,val);" + NL + "          } catch (java.lang.Exception ex) {" + NL + "            throw new RuntimeException(\"Can not convert value of type: \"+val.getClass().getName()+\" to target column\");" + NL + "          }" + NL + "    }" + NL + "}" + NL + "Boolean oBool_";
  protected final String TEXT_65 = " = (Boolean)reader_";
  protected final String TEXT_66 = ".invokeGeneric(\"Read\");" + NL + "boolean bool_";
  protected final String TEXT_67 = " = oBool_";
  protected final String TEXT_68 = " != null && oBool_";
  protected final String TEXT_69 = ".booleanValue();" + NL + "java.lang.Object val_";
  protected final String TEXT_70 = ";" + NL + "int nb_line_";
  protected final String TEXT_71 = " = 0;" + NL + "while (bool_";
  protected final String TEXT_72 = ") {" + NL + "    nb_line_";
  protected final String TEXT_73 = "++;";
  protected final String TEXT_74 = NL + "     ";
  protected final String TEXT_75 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_17);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    
                }   
                
    stringBuffer.append(TEXT_22);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_23);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_25);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
                }else{
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    
                }
                
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
   CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    LogUtil logtpl = new LogUtil(node);
    String connUrl = ElementParameterParser.getValue(node,"__DBNAME__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
    String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    String assemblyName = ElementParameterParser.getValue(node,"__ASSEMBLY_NAME__");
    String className = ElementParameterParser.getValue(node,"__CLASS_NAME__");
     boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    List<IMetadataTable> metadatas = node.getMetadataList();

     logtpl.info("\"Try to create an OleDb instance with assembly name: \"",assemblyName,"\", driver class name: \"",className,"\", connection string: \"",connUrl,"\".\""); 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(assemblyName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connUrl);
    stringBuffer.append(TEXT_46);
     
logtpl.info("\"Created an OleDb instance successfully.\"");
logtpl.info("\"Try to open an OleDb connection.\""); 

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
     logtpl.info("\"Open an OleDb connection successfully.\""); 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(assemblyName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
IMetadataTable metadata = metadatas.get(0);
    List<? extends IConnection> connsout = node.getOutgoingConnections();
    
    List<IMetadataColumn> columnsout = metadata.getListColumns();
    String populateOutput = "";
    String outName = null;
     if (connsout != null) {
        for (int i = 0; i < connsout.size(); i++) {
            IConnection connout = connsout.get(i);
            if (connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
               outName = connout.getName();               
               for (int j = 0; j < columnsout.size(); j++) {
                    IMetadataColumn columnout = columnsout.get(j);
               
    stringBuffer.append(TEXT_57);
    stringBuffer.append(columnout.getTalendType());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columnout.getLabel());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columnout.getLabel());
    stringBuffer.append(TEXT_62);
    
               populateOutput += "val_"+cid+" = reader_"+cid+".invokeGeneric(\"GetValue\","
                  + "new java.lang.Object[] { id"+columnout.getLabel()+"_"+cid+" });\nnew TypeConverter_"+cid+"().doConversion(val_"+cid+","+connout.getName()+",\""+columnout.getLabel()+"\");\n";
                  
        if (columnout.getTalendType().equals("id_String")) {
            boolean whetherTrimCol = false;
                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
                    for(Map<String, String> trimColumn : trimColumnList) {
                        if(columnout.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
                            if(("true").equals(trimColumn.get("TRIM"))) {
                                whetherTrimCol = true;
                                break;
                            }
                        }
                    }
                }
                
                if(whetherTrimAllCol || whetherTrimCol) {
                    populateOutput += connout.getName()+"."+columnout.getLabel()+" = "+connout.getName()+"."+columnout.getLabel()+".trim();\n";
                }
                
        }                   
               }
             }
         }
     }     

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
     logtpl.debug("\"Try to retrieve record \"",logtpl.var("nb_line"),"\".\""); 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(populateOutput);
    stringBuffer.append(TEXT_75);
    return stringBuffer.toString();
  }
}
