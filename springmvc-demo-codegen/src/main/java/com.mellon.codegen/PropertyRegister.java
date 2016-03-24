package com.mellon.codegen;

public class PropertyRegister {
	public static final String ENCODING = "UTF-8";
	public static final String ROOT = "D:/all.git/code-generator/code-generator";
	public static final String CONFIG_PATH = ROOT
			+ "/src/main/resources/config/config.properties";
	public static final String TEMPLATE_PATH = "/src/main/resources/config/templates";
	public static final String PACKAGE_NAME = "com.mellon.privilege";

	public static final String CREATE_BASE = ROOT + "/target/CreateFile";
	public static final String WEB_BASE = CREATE_BASE + "/privilege/";
	public static final String COMMON_PACKAGE_NAME = "com.mellon";
	public static final String NEW_PATH = CREATE_BASE + "/"
			+ PACKAGE_NAME.replace(".", "/");

	public static final String VO_PATH = NEW_PATH + "/vo/";
	public static final String CONTROLLER_PATH = NEW_PATH + "/controller/";
	public static final String ISERVICE_PATH = NEW_PATH + "/service/";
	public static final String SERVICE_PATH = NEW_PATH + "/service/impl/";
	public static final String IDAO_PATH = NEW_PATH + "/dao/";
	public static final String DAO_PATH = NEW_PATH + "/dao/impl/";
	public static final String WEB_PATH = WEB_BASE + "/";
	public static final String JS_PATH = WEB_BASE + "/script/";
	public static final String SERVICE_BEAN_CONFIG = CREATE_BASE + "/";
	public static final String SQL_PATH = CREATE_BASE + "/";
	public static final String[] FILE_ARRAY = new String[] { VO_PATH,
			CONTROLLER_PATH, SERVICE_PATH, ISERVICE_PATH, IDAO_PATH, DAO_PATH,
			WEB_PATH, JS_PATH };
	public static final String[][] INPUTFILEARRAY = new String[][] {
			{ "JspTemplate.vm", ".jsp", WEB_PATH, "JSP"},
			{ "JsTemplate.vm", ".js", JS_PATH, "JS"},
			{ "BeanTemplate.vm", ".xml", SERVICE_BEAN_CONFIG, "BEAN"},
			{ "ControllerTemplate.vm", ".java", CONTROLLER_PATH, "CONTROLLER"},
			{ "DAOTemplate.vm", ".java", DAO_PATH, "DAO"},
			{ "IDAOTemplate.vm", ".java", IDAO_PATH, "IDAO"},
			{ "IServiceTemplate.vm", ".java", ISERVICE_PATH, "ISERVICE"},
			{ "ServiceTemplate.vm", ".java", SERVICE_PATH, "SERVICE"},
			{ "VOTemplate.vm", ".java", VO_PATH, "VO"},
			{ "SqlTemplate.vm", ".sql", SQL_PATH, "SQL"}};
}
