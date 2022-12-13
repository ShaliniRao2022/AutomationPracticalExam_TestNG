package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage (WebDriver driver) {
		
		this.driver = driver;
	}
	
		
	public void clickWebElement(WebElement element)
	{
		element.click();
	}
	
	public static int generateRandomNumber(int boundaryNum)
	{
		Random r=new Random();
		return r.nextInt(boundaryNum);
	}
	
	public String getCurrentURLForPage()
	{
		return driver.getCurrentUrl();
	}
	
	public void waitForOptionsInDropdown(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, By.tagName("option")));
	}
	
	public List<String> getOptionsFromDropdown(WebElement element)
	{

		Select sel=new Select(element);
		List<String> list = new ArrayList<String>();
		List<WebElement> lw=sel.getOptions();
		for(WebElement w:lw) {
			if(!(w.getText().equals("None")))
			{
				list.add(w.getText());
							}
		}
		return list;
	}
	
}
