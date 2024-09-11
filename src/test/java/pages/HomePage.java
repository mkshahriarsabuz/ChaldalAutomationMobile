package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public By searchButton =  By.xpath("//*[@text='Search']/ancestor::android.view.ViewGroup[2]");

}
