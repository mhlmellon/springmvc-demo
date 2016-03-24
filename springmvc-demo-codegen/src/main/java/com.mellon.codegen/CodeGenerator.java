package com.mellon.codegen;

import java.io.IOException;
import java.sql.SQLException;

import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

public class CodeGenerator {
    public static void main(String[] args) throws InvalidConfigurationException, SQLException, IOException, InterruptedException, XMLParserException {
        OurBatisGenerator.generateCode();
        VelocityGenerator.generateCode();
    }

}
