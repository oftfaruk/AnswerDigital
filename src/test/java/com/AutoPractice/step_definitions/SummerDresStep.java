package com.AutoPractice.step_definitions;

import com.AutoPractice.pages.SummerDresses;
import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.ConfigurationReader;
import com.AutoPractice.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SummerDresStep {
    SummerDresses summer=new SummerDresses();
    @When("User  hover and selects {string} under {string} options")
    public void user_hover_and_selects_under_options(String module, String tab) {
        Driver.get().get(ConfigurationReader.get("url"));
        summer.navigationMenu(tab,module);
    }


    @Then("User views {string} from the Summer Collection")
    public void user_views_from_the_Summer_Collection(String expectedText) {
        BrowserUtils.waitFor(2);
        BrowserUtils.scrollToElement(summer.printedSummerDress);
        BrowserUtils.waitFor(1);
        Assert.assertEquals(expectedText,summer.printedSummerDress.getText());


    }




}
