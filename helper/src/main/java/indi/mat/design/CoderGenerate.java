package indi.mat.design;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;


public class CoderGenerate {

    static String author = "Mat";

    static String moduleName = "user";

    static String[] tableName = {"t_user", "t_account", "t_trd_party", "t_organization", "t_organization_role", "t_application"};

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"\\code-generator\\code";
        gc.setOutputDir(projectPath + "/src/main/java");
        deleteFile(new File(projectPath));
        String codePath = projectPath+"\\indi\\mat\\design";

        gc.setAuthor(author);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/casbin?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("indi.mat.design");
        mpg.setPackageInfo(pc);
        // 配置模版
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        strategy.setSuperEntityClass("indi.mat.design.model.BaseModel");
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass("indi.mat.design.controller.BaseController");
        strategy.setSuperServiceClass("indi.mat.design.service.base.IBaseService");
        strategy.setSuperServiceImplClass("indi.mat.design.service.base.BaseService");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id","deleted","in_user","in_date","last_edit_user","last_edit_date");
        strategy.setInclude(tableName);
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new NsFreemarkerTemplateEngine(codePath));
        mpg.execute();
    }


    public static boolean deleteFile( File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {

            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }

        return dirFile.delete();
    }
}
