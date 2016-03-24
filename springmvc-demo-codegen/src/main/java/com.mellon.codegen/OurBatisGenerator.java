package com.mellon.codegen;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OurBatisGenerator {
    public static void generateCode()
            throws InvalidConfigurationException, SQLException, IOException,
            InterruptedException, XMLParserException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        InputStream stream2 = OurBatisGenerator.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(stream2);
        String locationKey = "projectLocation";
        String location = (String) prop.get(locationKey);
        File locationDir = new File(location);
        if(!locationDir.exists()){
            throw new IllegalArgumentException("projectLocation目录不存在，请检查配置");
        }

        InputStream stream = OurBatisGenerator.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(stream);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
