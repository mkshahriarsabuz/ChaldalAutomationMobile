package pages;

import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

    public By searchProductInputBox = By.xpath("//android.widget.EditText[@text=\"Search Products\"]");
    public By product = By.xpath("//android.widget.TextView[@text=\"Colgate Charcoal Gold 360 Toothbrush\"]");
    public By shoppingBagButton = By.xpath("//android.widget.TextView[@text=\"\uF1D8\"]");

}

