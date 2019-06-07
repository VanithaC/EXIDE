package com.prakat.Exide.TestScripts;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.prakat.Exide.Pages.HomePage;
import com.prakat.Exide.Pages.LoginPage;
import com.prakat.Exide.Pages.ProductSelection;
import com.prakat.Generic.Helper.BaseTest;
import com.prakat.Generic.Helper.DropdownHelper;
import com.prakat.Generic.Helper.ExcelHelper;
import com.prakat.Generic.Helper.ScreenshotHelper;
import com.prakat.Generic.Helper.WaitHelper;
@Listeners(ScreenshotHelper.class)
public class ClickOnAddNew extends BaseTest{
	
	@Test
	public void ClickAddNew() throws IOException, Throwable {
		BaseTest.logger=BaseTest.report.createTest("Click on add new");
		WaitHelper wait=new WaitHelper();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		wait.implicitWait(30);
		xlib=new ExcelHelper();
		sel=new ProductSelection(driver);
		drop=new DropdownHelper();

		loginPage.login();
		
		try {
		WebElement AddNewBtn=homePage.getAddNewBtn();
		wait.waitForElementPresent(AddNewBtn, 15);
		homePage.getAddNewBtn().click();
		//loginPage.getSkipForMobileLink().click();
		//String actTitle = driver.getTitle();
		//Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		//System.out.println("Login success");
		
		
		//sel.getSingleProduct().click();

		String productName=xlib.getExcelData("ProductName", 1, 0);
		System.out.println(productName);
		//WebElement SelectProductSearch=sel.getSelectProductSearch();

		sel.getSelectProductSearch().sendKeys(productName);
		//wait.waitForElementPresent(SelectProductSearch, 20);
		Thread.sleep(10000);
		sel.getSelectProductSearch().sendKeys(Keys.ARROW_DOWN);
		sel.getSelectProductSearch().sendKeys(Keys.ENTER);
		
		String proposalNo=xlib.getExcelData("ProductName", 1, 1);
		System.out.println(proposalNo);
		sel.getProposalFormNo().sendKeys(proposalNo);
		Thread.sleep(20000);
		sel.getSaveProceedBtn().click();

			
		logger.pass("Login success");
		}
		finally {
			//driver.close();
		}

	}
	
/*	@Test
	public void SelectProduct() throws IOException, Throwable {
		xlib=new ExcelHelper();
		try {
		ProductSelection sel=new ProductSelection();
		sel.getSingleProduct().click();
		String productName=xlib.getExcelData("ProductName", 1, 0);
		sel.getSelectProductSearch().sendKeys(productName);
	}
		finally {
			driver.close();
		}*/

}

