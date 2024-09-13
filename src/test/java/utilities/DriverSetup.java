package utilities;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverSetup {

    private static final ThreadLocal<AndroidDriver> LOCAL_DRIVER = new ThreadLocal<>();
    public static void setDriver(AndroidDriver driver) {
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    public static AndroidDriver getDriver() {
        return LOCAL_DRIVER.get();
    }


    public static AndroidDriver getApp(String appFileName) throws MalformedURLException {
        File f = new File("src/test/resources/apk");
        File apk = new File(f, appFileName);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "SM M015G");
        desiredCapabilities.setCapability("udid", "R8KNA00APMJ");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:app", apk.getAbsolutePath());
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        return new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    public static void openApp(String appName) throws MalformedURLException {
        AndroidDriver driver = getApp(appName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        setDriver(driver);
    }

    public static void quitDriver(Scenario scenario){
        takeScreenShootOnFailedCase(scenario);
        getDriver().quit();
    }

    public static void takeScreenShootOnFailedCase(Scenario scenario){
        if (scenario.isFailed()){
            String name = scenario.getName().replaceAll(" ", "_");
            byte[] source =  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", name);
        }

    }
}