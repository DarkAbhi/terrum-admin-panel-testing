package `in`.terrum.terrumadminpaneltesting.challenges

import `in`.terrum.terrumadminpaneltesting.BASE_URL
import `in`.terrum.terrumadminpaneltesting.authentication.LoginPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.time.Duration

class ChallengesPageTest {

    private lateinit var driver: WebDriver
    private lateinit var loginPage: LoginPage
    private lateinit var challengesPage: ChallengesPage

    @BeforeMethod
    private fun setup() {
        driver = ChromeDriver()
        loginPage = LoginPage(driver)
        challengesPage = ChallengesPage(driver)
        loginPage.open()
    }

    @Test
    private fun testCreateChallengeWithoutImage() {
        loginPage.inputCorrectCredentials()
        val wait = WebDriverWait(driver, Duration.ofSeconds(5))
        wait.until(ExpectedConditions.titleIs("Dashboard"))
        assert(driver.currentUrl == "$BASE_URL/admin/dashboard")
        challengesPage.open()
        wait.until(ExpectedConditions.titleIs("Challenges"))
        challengesPage.navigateToCreateChallenge()
        wait.until(ExpectedConditions.titleIs("Create challenge"))
        challengesPage.inputCorrectDetailsWithoutImage()
        challengesPage.clickOnSubmit()
        wait.until(ExpectedConditions.titleIs("Challenges"))
        assert(driver.currentUrl.replace("\\?.*".toRegex(), "") == "$BASE_URL/admin/challenges")
    }

    @Test
    private fun testCreateChallengeWithImage() {
        loginPage.inputCorrectCredentials()
        val wait = WebDriverWait(driver, Duration.ofSeconds(5))
        wait.until(ExpectedConditions.titleIs("Dashboard"))
        assert(driver.currentUrl == "$BASE_URL/admin/dashboard")
        challengesPage.open()
        wait.until(ExpectedConditions.titleIs("Challenges"))
        challengesPage.navigateToCreateChallenge()
        wait.until(ExpectedConditions.titleIs("Create challenge"))
        challengesPage.inputCorrectDetailsWithoutImage()
        challengesPage.inputImage()
        challengesPage.clickOnSubmit()
        wait.until(ExpectedConditions.titleIs("Challenges"))
        assert(driver.currentUrl.replace("\\?.*".toRegex(), "") == "$BASE_URL/admin/challenges")
    }

    @AfterMethod
    private fun tearDown() {
        driver.quit()
    }

}