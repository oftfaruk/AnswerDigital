package com.AutoPractice.step_definitions;

import com.AutoPractice.pages.DashBoard;
import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.ConfigurationReader;
import com.AutoPractice.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class OurStoresStepDef {

    @Given("User is on the {string}")
    public void user_is_on_the(String string) {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        DashBoard dash = new DashBoard();
        BrowserUtils.scrollToElement(dash.ourStores);
        dash.ourStores.click();
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("//button[@class='dismissButton']")).click();

    }

    @When("User see a store from West Palm Beach")
    public void user_see_a_store_from_West_Palm_Beach() {
        WebElement canvasElement = Driver.get().findElement(By.xpath("//div[@id='map']"));
        BrowserUtils.scrollToElement(canvasElement);
        Driver.get().findElement(By.xpath("//button[@title='Zoom out']")).click();
        Driver.get().findElement(By.xpath("//button[@title='Zoom out']")).click();

    }

    @Then("User takes a screenshot")
    public void user_takes_a_screenshot() throws IOException {

        String projectPath = System.getProperty("user.dir");
        File s = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(s, new File(projectPath+"\\screenshots\\screenshotspoints.png"));

    }



}
