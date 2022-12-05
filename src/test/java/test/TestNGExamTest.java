package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.TestNGExamPage;
import util.BrowserFactory;
import page.BasePage;
public class TestNGExamTest {
		
	WebDriver driver;
	String duplicatedCategory;
	TestNGExamPage testNGExamPage;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.init();
	}
	
	/*TC1: Validate a user is able to add a category and once the category is added it should display.*/
	
	@Test (priority =1)
	public void userShouldBeAbleToAddACategory() {
			
		testNGExamPage = PageFactory.initElements(driver, TestNGExamPage.class);
		String text = "ShaliniR" + BasePage.generateRandomNumber(999);
		duplicatedCategory = text;
		testNGExamPage.addTextInTextbox(text);
		testNGExamPage.clickOnAddCategoryButton();
		Assert.assertEquals(testNGExamPage.checkIfLastAddedCategoryIsDisplayed("abc"), text);
		}
	
	/*TC2: Validate a user is not able to add a duplicated category. 
	 If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."*/
	
	@Test (priority = 2)
	public void userShouldNotBeAbleToDuplicateACategory() {
		
		testNGExamPage.addTextInTextbox(duplicatedCategory);
		testNGExamPage.clickOnAddCategoryButton();
		Assert.assertEquals(testNGExamPage.getCurrentURLForPage(), "https://techfios.com/test/105/todo.php");
	}
	
	/*TC3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.*/
	
	@Test (priority = 3)
	public void userShouldBeAbleToSelectAllTheMonthsInTheDropdown() {
		
		List<String> months= testNGExamPage.getMonths();
		System.out.println(months);
		List<String> text = testNGExamPage.getTextOfMonths();
		System.out.println(text);
		Assert.assertEquals(months,text);
	}
	
	
	
	
	

}
