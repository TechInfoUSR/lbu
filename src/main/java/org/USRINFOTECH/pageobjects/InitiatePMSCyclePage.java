package org.USRINFOTECH.pageobjects;

import java.util.*;

import org.USRINFOTECH.utility.ScrollHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InitiatePMSCyclePage {

    private WebDriver driver;
    private Properties prop;



    // Constructor
    public InitiatePMSCyclePage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }

    // Locators
    private By tabWeightTab = By.xpath("//a[@data-toggle='tab' and @href='#sectionWeightTab']");
    private By addNewRowLink = By.xpath("//a[@ng-click='addNewRow = true']");
    private By selectGroupDropdown = By.id("select2-chosen-2");
    private By groupSearchField = By.id("s2id_autogen2_search");
    private By insertButton = By.xpath("//a[contains(text(),'Insert')]");
    private By initiateReviewCycleButton = By.xpath("//*[@class='btn btn-default btn-xs' and @ng-click='initiateReviewCycleForGroup(eg.weightageGroupId)']");
    private By okButton = By.xpath("//button[contains(text(),'OK')]");

    private By objectiveWeightageField = By.xpath("//input[@ng-model='newEligibleGroup.objectiveWeightage']");
    private By coreValueWeightageField = By.xpath("//input[@ng-model='newEligibleGroup.coreValueWeightage']");
    private By jobCompetencyWeightageField = By.xpath("//input[@ng-model='newEligibleGroup.jobCompetencyWeightage']");
    private By behaviorWeightageField = By.xpath("//input[@ng-model='newEligibleGroup.behaviorWeightage']");
    private By leadershipWeightageField = By.xpath("//input[@ng-model='newEligibleGroup.leadershipWeightage']");

    // Flow config locators
    private By flowConfigIcon = By.xpath("//img[@src='asssets/media/images/cute-clipart/30/000000/ruler.png']");
    private By showTypeRadio = By.xpath("(//input[@name='flowConfigShowType'])[1]");
    private By saveFlowConfigButton = By.xpath("//*[@id='flow_config_form']/table/tbody/tr[38]/td/button");

    private By terminateFlowCheckbox = By.id("terminateflow");
    private By toggleOverallCheckbox = By.id("toggle_overallempmgrcomments");
    private By empOverallCommentCheckbox = By.id("employee_overall_comments");
    private By mgrOverallCommentCheckbox = By.id("manager_overall_comments");
    private By PMSCycle = By.xpath("(//h3[contains(text(),'Performance Review Cycle Management')])[1]");

    // ========== Actions ==========

    public void ClickONPMS(){
        WebElement element = driver.findElement(PMSCycle);
        ScrollHelper.scrollUntilElementVisible(driver, element);  // ← call the method here
        element.click();
    }

    public void openCycle(String cycleName) {
        driver.findElement(By.xpath("//span[contains(text(),'" + cycleName + "')]")).click();
    }

    public void goToWeightTab() {
        driver.findElement(tabWeightTab).click();
    }

    public void addGroupAndWeightage(String groupName) throws InterruptedException {
        driver.findElement(addNewRowLink).click();
        driver.findElement(selectGroupDropdown).click();
        driver.findElement(groupSearchField).sendKeys(groupName);
        driver.findElement(By.xpath("//div[contains(text(),'" + groupName + "')]")).click();
    }

    public void enterWeightages(String objective, String core, String job, String behavior, String leadership) {
        driver.findElement(objectiveWeightageField).sendKeys(objective);
        driver.findElement(coreValueWeightageField).sendKeys(core);
        driver.findElement(jobCompetencyWeightageField).sendKeys(job);
        driver.findElement(behaviorWeightageField).sendKeys(behavior);
        driver.findElement(leadershipWeightageField).sendKeys(leadership);
    }

    public void insertAndInitiate() {
        driver.findElement(insertButton).click();
        driver.findElement(initiateReviewCycleButton).click();
        driver.findElement(okButton).click();
    }

    public void enableFlowConfig() throws InterruptedException {
        driver.findElement(flowConfigIcon).click();
        driver.findElement(showTypeRadio).click();

        driver.findElement(terminateFlowCheckbox).click();
        driver.findElement(toggleOverallCheckbox).click();
        driver.findElement(empOverallCommentCheckbox).click();
        driver.findElement(mgrOverallCommentCheckbox).click();

        driver.findElement(saveFlowConfigButton).click();
        Thread.sleep(2000);
    }

    public boolean isCycleInitiated() {
        try {
            return driver.findElement(By.xpath("//tr[@class='ng-scope']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
