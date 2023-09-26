package `in`.terrum.terrumadminpaneltesting.authentication

import `in`.terrum.terrumadminpaneltesting.BASE_URL
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.time.Duration


class LoginPageTest {

    private lateinit var driver: WebDriver
    private lateinit var loginPage: LoginPage

    @BeforeMethod
    private fun setup() {
        driver = ChromeDriver()
        loginPage = LoginPage(driver)
        loginPage.open()
    }

    @Test
    fun testInvalidEmailPasswordToast() {
        loginPage.inputIncorrectCredentials()
        assert(loginPage.invalidEmailPasswordToastText.isDisplayed)
    }

    @Test
    private fun testLoginWorking() {
        loginPage.inputCorrectCredentials()
        val wait = WebDriverWait(driver, Duration.ofSeconds(5))
        wait.until(ExpectedConditions.titleIs("Dashboard"))
        assert(driver.currentUrl == "$BASE_URL/admin/dashboard")
    }

    @AfterMethod
    private fun tearDown() {
        driver.quit()
    }

}