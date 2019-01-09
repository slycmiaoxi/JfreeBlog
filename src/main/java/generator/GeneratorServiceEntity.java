package generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class GeneratorServiceEntity {

    private final static String dbUrl = "jdbc:mysql://rm-uf6tw13vo2gio7511o.mysql.rds.aliyuncs.com:3306/qihai?useUnicode=true&amp;amp;characterEncoding=utf8";
    private final static String username = "root";
    private final static String password = "Jiuying2017";

    @Test
    public void generateCode() {
        generateByTables("dazhuanpan_draw_num");
    }

    private void generateByTables(String... tableNames) {

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\IDEAwork\\QiHai\\QiHaiGame\\src\\main\\java");
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setOpen(true);
        //是否生成 kotlin 代码
        gc.setKotlin(false);
        gc.setAuthor("李勇");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("I%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(tableNames);
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig packageConfig = new PackageConfig()
                .setParent("")
                .setController("controller.base")
                .setEntity("model.base")
                .setMapper("dao.base")
                .setXml("mapper.base")
                .setService("service.base")
                .setServiceImpl("service.impl.base");
        mpg.setPackageInfo(packageConfig);

        // 执行生成
        mpg.execute();

    }

}
