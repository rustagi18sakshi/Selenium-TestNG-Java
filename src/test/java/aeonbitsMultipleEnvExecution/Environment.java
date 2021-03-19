package aeonbitsMultipleEnvExecution;

import org.aeonbits.owner.Config;

//Mention the property file name. Property file should be present in "src/main/resource" folder
@Config.Sources({"classpath:${env}.properties"})   
public interface Environment extends Config{

	    String url();

	    String username();

	    String password();

	    @Key("db.hostname")
	    String getDBHostname();

	    @Key("db.port")
	    int getDBPort();

	    @Key("db.username")
	    String getDBUsername();

	    @Key("db.password")
	    String getDBPassword();

}
