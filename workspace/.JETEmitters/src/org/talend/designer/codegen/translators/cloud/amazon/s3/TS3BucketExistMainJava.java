package org.talend.designer.codegen.translators.cloud.amazon.s3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3BucketExistMainJava
{
  protected static String nl;
  public static synchronized TS3BucketExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3BucketExistMainJava result = new TS3BucketExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Get an free connection from \" + \"";
  protected final String TEXT_8 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    " + NL + "    \t\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "\t\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_20 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_24 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t\tString masterKey_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "; " + NL + "\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_28 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(masterKey_";
  protected final String TEXT_29 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_30 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_31 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_32 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_33 = ");" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\t\t";
  protected final String TEXT_35 = " " + NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_36 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_37 = ");" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "; " + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t" + NL + "\t\t\tcom.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_42 = " = new com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider(kms_cmk_";
  protected final String TEXT_43 = ");" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t";
  protected final String TEXT_45 = " " + NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_46 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "; " + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_52 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(smk_";
  protected final String TEXT_53 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_54 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_56 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_57 = ");" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\tjava.io.File keyFile_";
  protected final String TEXT_59 = " = new java.io.File(";
  protected final String TEXT_60 = ");" + NL + "\t\t\t\tjava.io.FileInputStream keyfis_";
  protected final String TEXT_61 = " = null;" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_62 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_63 = " = new java.io.FileInputStream(keyFile_";
  protected final String TEXT_64 = ");" + NL + "\t\t\t        byte[] encodedPrivateKey_";
  protected final String TEXT_65 = " = new byte[(int)keyFile_";
  protected final String TEXT_66 = ".length()];" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_67 = ".read(encodedPrivateKey_";
  protected final String TEXT_68 = ");" + NL + "\t\t\t        symmetricKey_";
  protected final String TEXT_69 = " = new javax.crypto.spec.SecretKeySpec(encodedPrivateKey_";
  protected final String TEXT_70 = ", \"AES\");" + NL + "\t\t        } finally {" + NL + "\t\t        \tif(keyfis_";
  protected final String TEXT_71 = "!=null) {" + NL + "\t\t        \t\tkeyfis_";
  protected final String TEXT_72 = ".close();" + NL + "\t\t        \t}" + NL + "\t\t        }" + NL + "\t\t        " + NL + "\t\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_73 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_74 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_75 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_76 = ");" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\tjava.io.File filePublicKey_";
  protected final String TEXT_78 = " = new java.io.File(";
  protected final String TEXT_79 = ");" + NL + "\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_80 = " = null;" + NL + "\t\t\tbyte[] encodedPublicKey_";
  protected final String TEXT_81 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t        fis_";
  protected final String TEXT_82 = " = new java.io.FileInputStream(filePublicKey_";
  protected final String TEXT_83 = ");" + NL + "\t\t        encodedPublicKey_";
  protected final String TEXT_84 = " = new byte[(int) filePublicKey_";
  protected final String TEXT_85 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_86 = ".read(encodedPublicKey_";
  protected final String TEXT_87 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_88 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_89 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.io.File filePrivateKey_";
  protected final String TEXT_90 = " = new java.io.File(";
  protected final String TEXT_91 = ");" + NL + "\t        byte[] encodedPrivateKey_";
  protected final String TEXT_92 = " = null;" + NL + "\t        try {" + NL + "\t\t        fis_";
  protected final String TEXT_93 = " = new java.io.FileInputStream(filePrivateKey_";
  protected final String TEXT_94 = ");" + NL + "\t\t        encodedPrivateKey_";
  protected final String TEXT_95 = " = new byte[(int) filePrivateKey_";
  protected final String TEXT_96 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_97 = ".read(encodedPrivateKey_";
  protected final String TEXT_98 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_99 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_100 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.security.KeyFactory keyFactory_";
  protected final String TEXT_101 = " = java.security.KeyFactory.getInstance(\"";
  protected final String TEXT_102 = "\");" + NL + "\t        " + NL + "\t        java.security.spec.X509EncodedKeySpec publicKeySpec_";
  protected final String TEXT_103 = " = new java.security.spec.X509EncodedKeySpec(" + NL + "\t                encodedPublicKey_";
  protected final String TEXT_104 = ");" + NL + "\t        java.security.PublicKey publicKey_";
  protected final String TEXT_105 = " = keyFactory_";
  protected final String TEXT_106 = ".generatePublic(publicKeySpec_";
  protected final String TEXT_107 = ");" + NL + "\t" + NL + "\t        java.security.spec.PKCS8EncodedKeySpec privateKeySpec_";
  protected final String TEXT_108 = " = new java.security.spec.PKCS8EncodedKeySpec(" + NL + "\t                encodedPrivateKey_";
  protected final String TEXT_109 = ");" + NL + "\t        java.security.PrivateKey privateKey_";
  protected final String TEXT_110 = " = keyFactory_";
  protected final String TEXT_111 = ".generatePrivate(privateKeySpec_";
  protected final String TEXT_112 = ");" + NL + "\t" + NL + "\t        java.security.KeyPair asymmetricKey_";
  protected final String TEXT_113 = " = new java.security.KeyPair(publicKey_";
  protected final String TEXT_114 = ", privateKey_";
  protected final String TEXT_115 = ");" + NL + "\t        " + NL + "\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_116 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(asymmetricKey_";
  protected final String TEXT_117 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_118 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_119 = ");" + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_121 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_123 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_124 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_129 = " = ";
  protected final String TEXT_130 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_132 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_133 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_135 = ".set";
  protected final String TEXT_136 = "(";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\tcc_";
  protected final String TEXT_139 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_140 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_141 = ");" + NL + "\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_143 = " = new com.amazonaws.services.s3.AmazonS3EncryptionClient(" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = "credentials_";
  protected final String TEXT_145 = "credentialsProvider_";
  protected final String TEXT_146 = "," + NL + "\t\t\t\t\tencryptionMaterialsProvider_";
  protected final String TEXT_147 = ", " + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_148 = "," + NL + "\t\t\t\t\tnew com.amazonaws.services.s3.model.CryptoConfiguration()" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\t.withAwsKmsRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_150 = "))" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_153 = " = new com.amazonaws.services.s3.AmazonS3Client(" + NL + "\t\t\t\t\t";
  protected final String TEXT_154 = "credentials_";
  protected final String TEXT_155 = "credentialsProvider_";
  protected final String TEXT_156 = "," + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_157 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_159 = " = new com.amazonaws.services.s3.AmazonS3EncryptionClient(" + NL + "\t\t\t\t\t";
  protected final String TEXT_160 = "credentials_";
  protected final String TEXT_161 = "credentialsProvider_";
  protected final String TEXT_162 = ", " + NL + "\t\t\t\t\tencryptionMaterialsProvider_";
  protected final String TEXT_163 = "," + NL + "\t\t\t\t\tnew com.amazonaws.services.s3.model.CryptoConfiguration()" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t.withAwsKmsRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_165 = "))" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_168 = " = new com.amazonaws.services.s3.AmazonS3Client(" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = "credentials_";
  protected final String TEXT_170 = "credentialsProvider_";
  protected final String TEXT_171 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\tconn_";
  protected final String TEXT_173 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_174 = "));" + NL + "\t\t";
  protected final String TEXT_175 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_176 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\tboolean bucketExist_";
  protected final String TEXT_178 = "=false;" + NL + "\ttry{" + NL + "\t\tbucketExist_";
  protected final String TEXT_179 = " = conn_";
  protected final String TEXT_180 = ".doesBucketExist(";
  protected final String TEXT_181 = ");" + NL + "\t\t";
  protected final String TEXT_182 = "\t" + NL + "\t\t\tif(bucketExist_";
  protected final String TEXT_183 = "){" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_184 = " - Bucket \"+";
  protected final String TEXT_185 = "+\" exists.\");" + NL + "\t\t\t}else{" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_186 = " - Bucket \"+";
  protected final String TEXT_187 = "+\" does not exist.\");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_188 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_189 = "){" + NL + "\t\t";
  protected final String TEXT_190 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_191 = ");" + NL + "\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_193 = " - \" + e_";
  protected final String TEXT_194 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_196 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_197 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_198 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_199 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_200 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_201 = "_BUCKET_NAME\", ";
  protected final String TEXT_202 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_203 = "_BUCKET_EXIST\", bucketExist_";
  protected final String TEXT_204 = ");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	
    stringBuffer.append(TEXT_2);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	
	boolean set_region = (region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region));
	
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		}
	}else{
	
    stringBuffer.append(TEXT_9);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
		
		boolean inherit_credentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
		if(!inherit_credentials) {
	    	String passwordFieldName = "__SECRET_KEY__";
	    	
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		} else {
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		}
		
		boolean encrypt = "true".equals(ElementParameterParser.getValue(node,"__ENCRYPT__"));
		
		//work for tRedshiftOutputBulk
		String encrypted_key = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY__");
		
		//work for s3 components
		String key_type = ElementParameterParser.getValue(node,"__KEY_TYPE__");
		String algorithm_symmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_SYMMETRIC_MASTER_KEY__");
		String algorithm_asymmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_ASYMMETRIC_MASTER_KEY__");
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String encrypted_key_x509 = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY_X509__");
		String public_key = ElementParameterParser.getValue(node,"__PUBLIC_KEY__");
		String private_key = ElementParameterParser.getValue(node,"__PRIVATE_KEY__");
		
		if(encrypt && cid.startsWith("tRedshift")) {
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(encrypted_key);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		} else if(encrypt && "KMS_CMK".equals(key_type)) {//KMS
		
    stringBuffer.append(TEXT_34);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_CMK__")) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		} else if(encrypt && "SYMMETRIC_MASTER_KEY".equals(key_type)) {//symmetric master key
			if("AES".equals(algorithm_symmetric_master_key) && "BASE64".equals(encoding)) {
			
    stringBuffer.append(TEXT_44);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_BASE64__")) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
			} else if("AES".equals(algorithm_symmetric_master_key) && "X509".equals(encoding)) {
			
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(encrypted_key_x509);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			}
		} else if(encrypt && "ASYMMETRIC_MASTER_KEY".equals(key_type)) {//asymmetric master key
		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(public_key);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(private_key);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(algorithm_asymmetric_master_key);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
		}
		
		if(configClient && clientConfiguration.size()>0){
		
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_127);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_130);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_133);
    
				}else{
				
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_137);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
			}
			
			if(encrypt) {
			
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    if(!inherit_credentials) {
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    } else {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    if("KMS_CMK".equals(key_type) && set_region) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    
			} else {
			
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(!inherit_credentials) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    } else {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
			}
		}else{
			if(encrypt) {
			
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if(!inherit_credentials) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    } else {
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if("KMS_CMK".equals(key_type) && set_region) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    
			} else {
			
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    if(!inherit_credentials) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    } else {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_171);
    
			}
		}
		if(set_region){
		
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_174);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
		}
	}
	
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_181);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_187);
    
		}
		
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
			}
			
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
		}
		
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    return stringBuffer.toString();
  }
}
