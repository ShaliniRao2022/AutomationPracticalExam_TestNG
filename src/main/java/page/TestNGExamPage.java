package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestNGExamPage extends BasePage {
	
	WebDriver driver;

		
	public TestNGExamPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(how = How.NAME, using = "categorydata")WebElement textboxElement;
	@FindBy(how = How.CSS, using = "input[value='Add category']")WebElement addCategoryButtonElement;
	@FindBy(how = How.CSS, using = "a:last-of-type>span")WebElement lastAddedCategoryElement ;
	@FindBy(how=How.NAME,using="due_month")WebElement selectMonthElement ;
	
	
	public void addTextInTextbox (String text) {
		
		textboxElement.sendKeys(text);
			
	}
	
	
	public void clickOnAddCategoryButton() {
		
		clickWebElement(addCategoryButtonElement);
	}
	
		
	public String checkIfLastAddedCategoryIsDisplayed(String text)
	{		System.out.println(lastAddedCategoryElement.getText());
			return lastAddedCategoryElement.getText();
		
	}
	
	public String getCurrentURLForPage()
	{
		return super.getCurrentURLForPage();
	}
	
		
	public List<String> getMonths()	{
		
		super.waitForOptionsInDropdown(selectMonthElement);
		return super.getOptionsFromDropdown(selectMonthElement);
	}
	
	
	public List<String> getTextOfMonths(){
		
		List<String> al = new ArrayList<String>();
		al.add("Jan");
		al.add("Feb");
		al.add("Mar");
		al.add("Apr");
		al.add("May");
		al.add("Jun");
		al.add("Jul");
		al.add("Aug");
		al.add("Sep");
		al.add("Oct");
		al.add("Nov");
		al.add("Dec");
		return al;
		
	}
	
	

}
