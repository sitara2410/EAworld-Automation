package org.sample.pages;

import com.google.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EAWorldPage  extends MainPage 
{
	WebDriver driver;
  /*  @Inject
    public EAWorldPage(WebDriver driver, WebElement menuButton) 
    {
        super(driver);
    }*/
	@Inject
   public EAWorldPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(css=".eaw-navigation__toggle") private WebElement menuButton;

    //@FindBy(css = ".fa.fa-fw.fa-search") private WebElement searchButton;
    
    //#site-header > ul > li:nth-child(1) > div > a > i

    public void searchButtonclick()
    {
    	driver.navigate().to("https://eaworld.ea.com/");
    WebElement searchButton = driver.findElement(By.cssSelector(".fa.fa-fw.fa-search"));    
    	searchButton.click();
        System.out.println("Sitara!");
        try {
            Thread.sleep(5000); // This is for Hard wait on page for 5 secs
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
