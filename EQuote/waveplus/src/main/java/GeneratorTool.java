import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorTool {
    public static void main(String[] args) { 
    		 /* java.util.Random r=new java.util.Random(19); 
    		  for(int i=0;i<10;i++){ 
    		    System.out.println(Math.abs(r.nextLong())); 
    		  }  */
        shell();
    }

    private static void shell() {
        List<String> warnings = new ArrayList<String>();
        try { 
            String configFilePath = System.getProperty("user.dir").concat("/target/classes/conf/mybatis/generatorConfig.xml");
            System.out.println("加载配置文件===" + configFilePath);
            boolean overwrite = true;
            File configFile = new File(configFilePath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            ProgressCallback progressCallback = new VerboseProgressCallback();
            // myBatisGenerator.generate(null);
            myBatisGenerator.generate(progressCallback);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (String warning : warnings) {
            System.out.println(warning);
        }
        
        System.out.println("end *********************");
    }
}