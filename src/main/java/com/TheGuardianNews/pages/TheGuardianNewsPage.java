package com.TheGuardianNews.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheGuardianNewsPage {
	private WebDriver driver;
	private String title;

    // Define locators
    private By firstNewsArticleLocator = By.xpath("(//a[@class='u-faux-block-link__overlay js-headline-text'])[1]");

    public TheGuardianNewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public TheGuardianNewsPage(String title, String url) {
		// TODO Auto-generated constructor stub
	}
    
    //Method to get the title 
    public String getTitle() {
        return title;
    }
	// Method to get content of the first news article
    public WebElement getFirstNewsArticle() {
        return driver.findElement(firstNewsArticleLocator);
    }

}
