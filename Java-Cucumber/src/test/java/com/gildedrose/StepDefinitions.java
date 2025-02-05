package com.gildedrose;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    private Item[] items = new Item[1];
    private GildedRose app;

    @Given("The item as {string} with quality {int}")
    public void initial_item_and_quality_is(String name, int value) {
        items[0] = new Item(name, 0, value);
        app = new GildedRose(items);
    }
    
    @Given("The item as {string} with sellby {int} and quality {int}")
    public void initial_item_and_sellby_and_quality_is(String name, int sellIn, int value) {
        items[0] = new Item(name, sellIn, value);
        app = new GildedRose(items);
    }

    @When("I update the quality")
    public void i_update_the_quality() {
        app.updateQuality();
    }

    @Then("I should get item name as {string}")
    public void i_should_get_item_name(String expected) {
        assertEquals(expected, app.items[0].name);
    }

    @Then("I should get item quality as {int}")
    public void i_should_get_item_and_quality_as(int expected) {
        assertEquals(expected, app.items[0].quality);
    }
}

