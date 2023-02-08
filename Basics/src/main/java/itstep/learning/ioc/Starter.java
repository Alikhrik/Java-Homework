package itstep.learning.ioc;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Starter {
    @Inject
    private Service1 service1;
    @Inject
    private Service1 service1v2;

    @Inject
    private Service2 service2;
    @Inject
    private Service2 service2v2;

    @Inject
    private IService3 service3;

    @Inject
    @Named("v1")
    private IService4 service4v1;
    @Inject
    @Named("v2")
    private IService4 service4v2;

    @Inject
    @Named("MySqlConnectionString")
    private String myCs;
    @Inject
    @Named("OracleConnectionString")
    private String oreCs;

    @Inject
    CtrDemo ctrDemo;

    @Inject IConfigService config;

    public void run() {
        System.out.println("DI demo");
        service1.show();
        service1v2.show();

        service2.show();
        service2v2.show();

        service3.show();

        service4v1.show();
        service4v2.show();

        System.out.println(myCs);
        System.out.println(oreCs);

        ctrDemo.show();


        Path conf_file_path = Paths.get("config.ini");
        config.setConfigFile(conf_file_path);

        String par = config.getParameter("key");

        System.out.println(par);
    }
}
      