package com.mellon.codegen;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.SimpleFormatter;

public class VelocityGenerator {
    public static void generateCode() throws IOException {

        // 初始化并取得Velocity引擎
        VelocityEngine ve = new VelocityEngine();
        // 读取architecture文件属性。


        Properties prop = new Properties();
        try {
            prop.load(VelocityGenerator.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        prop.setProperty(Velocity.ENCODING_DEFAULT, prop.getProperty("encoding"));
        prop.setProperty(Velocity.INPUT_ENCODING, prop.getProperty("encoding"));
        prop.setProperty(Velocity.OUTPUT_ENCODING, prop.getProperty("encoding"));
        prop.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE,
            IncludeRelativePath.class.getName());
        prop.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        ve.init(prop);

        // 取得velocity的上下文context
        VelocityContext context = new VelocityContext(prop);


        Set<String> tergetFiles = new HashSet<String>();
        String[] fileArray = prop.getProperty("targetFiles").split(",");
        for (int i = 0; i < fileArray.length; i++) {
            tergetFiles.add(fileArray[i].toLowerCase());
        }


        String[] tables = prop.getProperty("tables").split(",");
        //TODO 循环遍历tables对每个表生成svc,controller.
        for (int i = 0; i < tables.length; i++) {
            String camelName = transferTableNameToCamelName(tables[i]);
            String pascalName = transferTableNameToPascalName(tables[i]);

            context.put("camelName", camelName);
            context.put("pascalName", pascalName);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowDate = sdf.format((new Date()));
            context.put("nowDate", nowDate);
//            System.out.println(tables[i]+":"+camelName+":"+pascalName);
            //TODO 删除可能存在的文件。
//            String serviceInterfaceName="I"+table.substring(0,1).toUpperCase()+table.substring(1)+"Service";
//            System.out.println(serviceInterfaceName);
            //对每种想要生成的文件进行生成。
            String inputFile = null;
            String outputPath = null;
            File outputDir = null;
            String outputFile = null;
//            String topLevelPackagePath = ;
            for (int j = 0; j < fileArray.length; j++) {
                switch (fileArray[j].toLowerCase()) {
                    case "controller":
                        inputFile = prop.getProperty("templeteDir") + "/" + "ControllerTemplate.vm";
                        outputPath = prop.getProperty("projectLocation") + "/" + prop.getProperty("componentName")
                            + "-controller" + prop.getProperty("javaCodeFolder") + "/" + (prop.getProperty("topLevelPackage")
                            + prop.getProperty("controllerPackage")).replaceAll("\\.", "/");
                        outputDir = new File(outputPath);
                        if (!outputDir.exists()) {
                            outputDir.mkdirs();
                        }
                        context.put("package", prop.getProperty("topLevelPackage"));
                        outputFile = outputPath + "/" + pascalName + "Controller.java";

                        merge(ve, context, inputFile, outputFile);

                        break;
                    case "serviceimpl":
                        inputFile = prop.getProperty("templeteDir") + "/" + "ServiceImplTemplate.vm";
                        outputPath = prop.getProperty("projectLocation") + "/" + prop.getProperty("componentName")
                            + "-impl" + prop.getProperty("javaCodeFolder") + "/" + (prop.getProperty("topLevelPackage")
                            + prop.getProperty("serviceImplPackage")).replaceAll("\\.", "/");
                        outputDir = new File(outputPath);
                        if (!outputDir.exists()) {
                            outputDir.mkdirs();
                        }
                        context.put("package", prop.getProperty("topLevelPackage"));
                        outputFile = outputPath + "/" + pascalName + "ServiceImpl.java";
                        merge(ve, context, inputFile, outputFile);
                        break;

                    case "service":
                        inputFile = prop.getProperty("templeteDir") + "/" + "ServiceTemplate.vm";
                        outputPath = prop.getProperty("projectLocation") + "/" + prop.getProperty("componentName")
                            + "-svc" + prop.getProperty("javaCodeFolder") + "/" + (prop.getProperty("topLevelPackage")
                            + prop.getProperty("servicePackage")).replaceAll("\\.", "/");
                        outputDir = new File(outputPath);
                        if (!outputDir.exists()) {
                            outputDir.mkdirs();
                        }
                        context.put("package", prop.getProperty("topLevelPackage"));
                        outputFile = outputPath + "/" + pascalName + "Service.java";

                        merge(ve, context, inputFile, outputFile);
                        break;
                    case "js":

                        break;
                    case "jsp":

                        break;
                    case "vo":
                        inputFile = prop.getProperty("templeteDir") + "/" + "VOTemplate.vm";
                        outputPath = prop.getProperty("projectLocation") + "/" + prop.getProperty("componentName")
                                + "-domain" + prop.getProperty("javaCodeFolder") + "/" + (prop.getProperty("topLevelPackage")
                                + prop.getProperty("voPackage")).replaceAll("\\.", "/");
                        outputDir = new File(outputPath);
                        if (!outputDir.exists()) {
                            outputDir.mkdirs();
                        }
                        context.put("package", prop.getProperty("topLevelPackage"));
                        outputFile = outputPath + "/" + pascalName + "VO.java";

                        merge(ve, context, inputFile, outputFile);
                        break;

                    default:
                        break;
                }

            }
//            String serviceName="";
//            String controllerName = "";
//            String domainName="";
//            String variableName="";
        }

        //TODO 指示模板位置与生成文件的位置
        //TODO 根据domain生成svc controller等
    }

    /**
     * 功能描述: 把包含下划线的名字转化为首字母大写的大驼峰命名<br>
     * 〈功能详细描述〉
     *
     * @param tableName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String transferTableNameToPascalName(String tableName) {
        String camelName = transferTableNameToCamelName(tableName);
        return camelName.substring(0, 1).toUpperCase() + camelName.substring(1, camelName.length());
    }

    /**
     * 功能描述: 把含有下划线_的表名字转为java编码风格的小驼峰名字，首字母小写，下划线去掉紧跟一个大写<br>
     * 〈功能详细描述〉
     *
     * @param tableName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String transferTableNameToCamelName(String tableName) {
        String camelName = tableName + "";
        while (camelName.contains("_")) {
            int index = camelName.indexOf("_");
            if (camelName.length() <= 1) {
                camelName = "";
            } else if (camelName.startsWith("_")) {
                camelName = camelName.substring(1, camelName.length());
            } else if (camelName.endsWith("_")) {
                camelName = camelName.substring(0, camelName.length() - 1);
            } else {
                camelName = camelName.substring(0, index) + camelName.substring(index + 1, index + 2).toUpperCase() + camelName.substring(index + 2);
            }
        }
        return camelName.substring(0, 1).toLowerCase() + camelName.substring(1, camelName.length());
    }


    // 转换输出
    public static void merge(VelocityEngine ve, VelocityContext context,
                             String inputFile, String outputFile) throws IOException {
        // 输出流
        StringWriter writer = new StringWriter();
        // 取得velocity的模版
        Template t = ve.getTemplate(inputFile);
        // 转换输出
        t.merge(context, writer);
        FileOutputStream out = new FileOutputStream(new File(outputFile));
        String outputString = writer.toString();
        /* temp = temp.substring(1); */
        outputString = outputString.replace("JQ", "$");
        System.out.println(outputString);
        out.write(outputString.getBytes());
        out.close();
        writer.close();
    }
}
