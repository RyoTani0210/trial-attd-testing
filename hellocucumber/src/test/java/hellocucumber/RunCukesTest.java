package hellocucumber;

// import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.platform.suite.api.ConfigurationParameter;
// import org.junit.platform.suite.api.SelectClasspathResource;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("hellocucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCukesTest {

}

