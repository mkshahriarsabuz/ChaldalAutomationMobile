package pages;

import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage{


   public  By addCartButton = By.xpath("(//*[@text='  | each'])[last()]/following-sibling::android.view.ViewGroup[(last()-2)]");
   public  By closeButton = By.xpath("//android.widget.TextView[@text=\"Close\"]");

}
