package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public By searchButton =  By.xpath("//*[@text='Search']/ancestor::android.view.ViewGroup[2]");
    public By locationAllow = By.xpath("//android.widget.Button[@text='While using the app']");

    public void handleLocationAllow(){
        if (isElementVisible(locationAllow)){
            clickOnElement(locationAllow);
        }
    }
}
