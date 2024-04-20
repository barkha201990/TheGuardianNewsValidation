package com.TheGuardianNews.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;
import com.TheGuardianNews.pages.TheGuardianNewsPage;
import com.TheGuardianNews.services.NewsValidationService;

public class NewsStepDefinitions {
	private NewsValidationService articleValidationService;
    private TheGuardianNewsPage firstArticle;
    private boolean isValid;

    public NewsStepDefinitions() {
        this.articleValidationService = new NewsValidationService();
    }

    @Given("User open theguardian news page")
    public void user_open_theguardian_news_page() {
        articleValidationService.openGuardianNewsPage();
    }

    @When("User retrieve the first news article")
    public void user_retrieve_the_first_news_article() {
        firstArticle = articleValidationService.getFirstArticle();
    }

    @When("User search for similar news articles on the web")
    public void user_search_for_similar_news_articles_on_the_web() {
        isValid = articleValidationService.validateArticle(firstArticle);
    }

    @Then("the first article should be considered valid if two or more similar articles are found")
    public void the_first_article_should_be_considered_valid_if_two_or_more_similar_articles_are_found() {
        assertTrue("The article should be considered valid.", isValid);
    }
}
