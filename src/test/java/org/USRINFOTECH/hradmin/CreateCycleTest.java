package org.USRINFOTECH.hradmin;

import org.USRINFOTECH.BaseTest;
import org.USRINFOTECH.pageobjects.HRAdminCreateCycle;
import org.USRINFOTECH.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class CreateCycleTest  extends BaseTest {

    @Test
    public void testCreateGoalPlan() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));

        HRAdminCreateCycle goalPlanPage = new HRAdminCreateCycle(driver);

        goalPlanPage.goToGoalPlanSection();
        goalPlanPage.clickAddGoalPlan();

        String planName =  prop.getProperty("GoalPalnName");
        goalPlanPage.enterGoalPlanName(planName);

        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(3);
        goalPlanPage.selectDateRange(start, end);

        String RatingScale =  prop.getProperty("RatingScale");
        goalPlanPage.selectRatingScale(RatingScale);

        String EmpGroup =  prop.getProperty("EmpGroup");
        goalPlanPage.selectEmployeeGroup(EmpGroup);
        goalPlanPage.activateGoalPlan();
        goalPlanPage.submitGoalPlan();

        Assert.assertTrue(goalPlanPage.isGoalPlanVisible(planName), "Goal Plan not visible in table.");
    }
}