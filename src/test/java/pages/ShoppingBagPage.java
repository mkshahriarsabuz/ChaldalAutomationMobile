package pages;

import org.openqa.selenium.By;

public class ShoppingBagPage extends  BasePage{


    public By productMinusButton = By.xpath("//android.widget.TextView[contains(@text, 'Toothbrush')]/following-sibling::android.view.ViewGroup[2])[last()]");
    public By bodyText = By.xpath("//android.widget.TextView[@text=\"Nothing to see here\"]");

}
