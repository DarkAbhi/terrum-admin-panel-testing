package `in`.terrum.terrumadminpaneltesting.brands

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


class BrandsPageTest {

    private lateinit var driver: WebDriver
    private lateinit var loginPage: LoginPage
    private lateinit var brandsPage: BrandsPage

    @BeforeMethod
    private fun setup() {
        driver = ChromeDriver()
        loginPage = LoginPage(driver)
        brandsPage = BrandsPage(driver)
        loginPage.open()
    }

    @Test
    private fun testCreateBrand() {
        loginPage.inputCorrectCredentials()
        val wait = WebDriverWait(driver, Duration.ofSeconds(5))
        wait.until(ExpectedConditions.titleIs("Dashboard"))
        assert(driver.currentUrl == "$BASE_URL/admin/dashboard")
        brandsPage.open()
        wait.until(ExpectedConditions.titleIs("Brands"))
        brandsPage.navigateToCreateBrand()
        wait.until(ExpectedConditions.titleIs("Create brand"))
        brandsPage.inputAndSubmitCorrectBrandData()
        wait.until(ExpectedConditions.titleIs("Brands"))
        assert(driver.currentUrl.replace("\\?.*".toRegex(), "") == "${BASE_URL}/admin/brands")
    }

    @AfterMethod
    private fun tearDown() {
        driver.quit()
    }

}