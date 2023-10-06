package `in`.terrum.terrumadminpaneltesting.brands

import `in`.terrum.terrumadminpaneltesting.BASE_URL
import `in`.terrum.terrumadminpaneltesting.utils.generateRandomNumber
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

class BrandsPage(private val driver: WebDriver) {
    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 15), this)
    }

    @FindBy(xpath = "//button[text()='Add brand']")
    lateinit var addBrandBtn: WebElement

    @FindBy(xpath = "//input[@name='name']")
    lateinit var nameInputField: WebElement

    @FindBy(xpath = "//input[@name='website']")
    lateinit var websiteInputField: WebElement

    @FindBy(xpath = "//button[text()='Create']")
    lateinit var createBtn: WebElement


    fun open() {
        driver.navigate().to("${BASE_URL}/admin/brands")
    }

    fun navigateToCreateBrand() {
        addBrandBtn.click()
    }

    fun inputAndSubmitCorrectBrandData() {
        val randomNumber = generateRandomNumber()
        nameInputField.sendKeys("Brand $randomNumber")
        websiteInputField.sendKeys("https://brand${randomNumber}.com")
        createBtn.click()
    }

}