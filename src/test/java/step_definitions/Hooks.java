package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

import static utilities.DriverSetup.openApp;
import static utilities.DriverSetup.quitDriver;


public class Hooks {

    @Before
    public void start() throws MalformedURLException {
        openApp();
    }

    @After
    public void closeDriver(Scenario scenario){
        quitDriver(scenario);
    }

}
