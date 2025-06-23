package org.USRINFOTECH.pageobjects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium .*;


public class HRAdminCreateCycle {


        private WebDriver driver;

        // Constructor
        public HRAdminCreateCycle(WebDriver driver) {
            this.driver = driver;
        }

        // Locators
        private By goalPlanManagementLink = By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]");
        private By addGoalPlanButton = By.id("addGoalPlan");
        private By goalPlanNameField = By.id("goalPlanName");
        private By fromDateInput = By.cssSelector("input.form-control.dpd1");
        private By toDateInput = By.cssSelector("input.form-control.dpd2");
        private By datepickerSwitch = By.xpath("//th[@class='datepicker-switch']");
        private By nextMonthButton = By.xpath("//th[@class='next']");

        private By ratingScaleField = By.xpath("//input[@placeholder='Select Rating Scale']");
        private By ratingScaleDropdown = By.xpath("//div[@class='selectize-dropdown-content']");

        private By groupRadioButton = By.id("selectGroupRadio");
        private By empGroupField = By.xpath("//input[@placeholder='Select Target Employees Group for this Plan']");
        private By employeeGroupList = By.cssSelector("span.name");

        private By isActiveCheckbox = By.id("isActive");
        private By isWeightageBasedCheckbox = By.id("isWeightageBased");
        private By submitButton = By.id("submit_btn_action");

        // Actions

        public void goToGoalPlanSection() {
            scroll(0, 1800);
            driver.findElement(goalPlanManagementLink).click();
        }

        public void clickAddGoalPlan() {
            driver.findElement(addGoalPlanButton).click();
        }

        public void enterGoalPlanName(String name) {
            driver.findElement(goalPlanNameField).sendKeys(name);
        }

        public void selectDateRange(LocalDate fromDate, LocalDate toDate) throws InterruptedException {
            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");

            // From Date
            driver.findElement(fromDateInput).click();
            selectDate(fromDate.format(monthYearFormatter), fromDate.format(dayFormatter));

            // To Date
            driver.findElement(toDateInput).click();
            selectDate(toDate.format(monthYearFormatter), toDate.format(dayFormatter));
        }

        private void selectDate(String month, String day) throws InterruptedException {
            String displayedMonth = driver.findElement(datepickerSwitch).getText();
            while (!displayedMonth.equals(month)) {
                driver.findElement(nextMonthButton).click();
                displayedMonth = driver.findElement(datepickerSwitch).getText();
            }
            driver.findElement(By.xpath("//td[@class='day' and text()='" + day + "']")).click();
        }

        public void selectRatingScale(String ratingScale) throws InterruptedException {
            scroll(0, 500);
            driver.findElement(ratingScaleField).sendKeys(ratingScale);
            driver.findElement(ratingScaleDropdown).click();
        }

        public void selectEmployeeGroup(String empGroup) throws InterruptedException {
            scroll(0, 1000);
            driver.findElement(groupRadioButton).click();
            driver.findElement(empGroupField).sendKeys(empGroup);

            WebElement element = driver.findElement(employeeGroupList);
            if (element.getText().contains(empGroup)) {
                element.click();
            }
        }

        public void activateGoalPlan() {
            driver.findElement(isActiveCheckbox).click();
            driver.findElement(isWeightageBasedCheckbox).click();
        }

        public void submitGoalPlan() {
            driver.findElement(submitButton).click();
        }

        public boolean isGoalPlanVisible(String goalPlanName) {
            try {
                return driver.findElement(By.xpath("//td[contains(text(),'" + goalPlanName + "')]")).isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        // Utility method
        private void scroll(int x, int y) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
        }
    }
