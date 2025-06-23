package org.USRINFOTECH.hradmin;

import org.USRINFOTECH.BaseTest;
import org.USRINFOTECH.pageobjects.InitiatePMSCyclePage;
import org.USRINFOTECH.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InitiateCycleTest extends BaseTest {

        @Test
        public void testInitiateCycle() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));

            InitiatePMSCyclePage cyclePage = new InitiatePMSCyclePage(driver, prop);
            cyclePage.ClickONPMS();

            String GoalPalnName = prop.getProperty("GoalPalnName");
            cyclePage.openCycle(GoalPalnName);
            cyclePage.goToWeightTab();

            String EmpGroup = prop.getProperty("EmpGroup");
            cyclePage.addGroupAndWeightage(EmpGroup);

            cyclePage.enterWeightages("100", "0", "0", "0", "0");
            cyclePage.insertAndInitiate();

            Assert.assertTrue(cyclePage.isCycleInitiated(), "Cycle was not initiated");
        }
    }

