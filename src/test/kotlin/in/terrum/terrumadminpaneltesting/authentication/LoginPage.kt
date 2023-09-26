package `in`.terrum.terrumadminpaneltesting.authentication

import `in`.terrum.terrumadminpaneltesting.BASE_URL
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

/**
 * The `LoginPage` class represents a page object for handling interactions with a login page in a web application.
 *
 * @param driver The WebDriver instance used for interacting with the web page.
 */
class LoginPage(private val driver: WebDriver) {

    /**
     * Initializes the `LoginPage` object and sets up the WebElements using Selenium's PageFactory.
     *
     */
    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 15), this)
    }

    /**
     * WebElement representing the email input field on the login page.
     */
    @FindBy(xpath = "//input[@type='email']")
    lateinit var emailInput: WebElement

    /**
     * WebElement representing the password input field on the login page.
     */
    @FindBy(xpath = "//input[@type='password']")
    lateinit var passwordInput: WebElement

    /**
     * WebElement representing the login button on the login page.
     */
    @FindBy(xpath = "//button[text()='Login']")
    lateinit var loginButton: WebElement

    /**
     * WebElement representing the message for an invalid email on the login page.
     */
    @FindBy(xpath = "//p[text()='Invalid email']")
    lateinit var invalidEmailText: WebElement

    /**
     * WebElement representing the toast message for invalid email/password combination on the login page.
     */
    @FindBy(xpath = "//div[text()='Invalid Email/password']")
    lateinit var invalidEmailPasswordToastText: WebElement

    /**
     * Opens the login page by navigating to the BASE_URL.
     */
    fun open() {
        driver.get(BASE_URL)
    }

    /**
     * Enters correct credentials (email and password) and clicks the login button.
     */
    fun inputCorrectCredentials() {
        emailInput.sendKeys("ikutestmail@gmail.com")
        passwordInput.sendKeys("qwertyuiop8")
        loginButton.click()
    }

    /**
     * Enters incorrect credentials (email and password) and clicks the login button.
     */
    fun inputIncorrectCredentials() {
        emailInput.sendKeys("incorrectemail@gmail.com")
        passwordInput.sendKeys("pointblank9")
        loginButton.click()
    }
}