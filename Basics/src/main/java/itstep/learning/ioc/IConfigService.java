package itstep.learning.ioc;

import java.nio.file.Path;

public interface IConfigService {
    void setConfigFile(Path path);
    String getParameter(String name);
}
