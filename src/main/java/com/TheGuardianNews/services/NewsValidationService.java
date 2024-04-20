package com.TheGuardianNews.services;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.TheGuardianNews.pages.TheGuardianNewsPage;
import com.TheGuardianNews.util.WebDriverUtil;

public class NewsValidationService {
	private WebDriver driver;
    private final String GUARDIAN_NEWS_URL = "https://www.theguardian.com/tone/news";
    
    public NewsValidationService() {
    	this.driver = WebDriverUtil.getWebDriverInstance();
    }
    
    public void openGuardianNewsPage() {
        driver.get(GUARDIAN_NEWS_URL);
    }
    
    public TheGuardianNewsPage getFirstArticle() {
        WebElement firstArticleElement = driver.findElement(By.xpath("(//a[@class='u-faux-block-link__overlay js-headline-text'])[1]")); // xpath for first news artical
        String title = firstArticleElement.getText();
        String url = firstArticleElement.getAttribute("href");
        
        return new TheGuardianNewsPage(title, url);
    }
    
    public boolean validateArticle(TheGuardianNewsPage article) {
        // web search on Google to search for similar articles
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(article.getTitle());
        searchBox.submit();
        
        // Check for similar articles
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".rJSR9b"));
        
        // Filter the results for articles from other sources
        List<String> articleLinks = searchResults.stream()
                                                 .map(result -> result.getAttribute("href"))
                                                 .collect(Collectors.toList());
        
        // Consider the article valid if there are two or more similar articles
        return articleLinks.size() >= 2;
    }
}
