package `in`.terrum.terrumadminpaneltesting.challenges

import `in`.terrum.terrumadminpaneltesting.BASE_URL
import `in`.terrum.terrumadminpaneltesting.testdata.sentences
import `in`.terrum.terrumadminpaneltesting.utils.generateRandomNumber
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory


class ChallengesPage(private val driver: WebDriver) {

    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 15), this)
    }

    @FindBy(xpath = "//input[@name='name']")
    lateinit var challengeNameInputField: WebElement

    @FindBy(xpath = "//textarea[@name='description']")
    lateinit var challengeDescriptionInputField: WebElement

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div/form/div[3]/button")
    lateinit var challengeStartDateBtn: WebElement

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div/form/div[4]/button")
    lateinit var challengeEndDateBtn: WebElement

    @FindBy(xpath = "//input[@type='file']")
    lateinit var challengeImageInputField: WebElement

    @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/div[2]/button[1]")
    lateinit var calendarPrevMonthBtn: WebElement

    @FindBy(xpath = "//button[@name='next-month']")
    lateinit var calendarNextMonthBtn: WebElement

    @FindBy(xpath = "//button[text()='15']")
    lateinit var fifteenthDay: WebElement

    @FindBy(xpath = "//button[text()='20']")
    lateinit var twentiethDay: WebElement

    @FindBy(xpath = "//button[text()='Add challenge']")
    lateinit var addChallengeBtn: WebElement

    @FindBy(xpath = "//button[text()='Submit']")
    lateinit var submitBtn: WebElement

    fun open() {
        driver.navigate().to("$BASE_URL/admin/challenges")
    }

    fun navigateToCreateChallenge() {
        addChallengeBtn.click()
    }

    fun inputCorrectDetailsWithoutImage() {
        val randomNumber = generateRandomNumber()
        challengeNameInputField.sendKeys("Challenge $randomNumber")
        challengeDescriptionInputField.sendKeys(sentences.random())
        challengeStartDateBtn.click()
        calendarNextMonthBtn.click()
        fifteenthDay.click()
        val actions = Actions(driver)
        actions.sendKeys(Keys.ESCAPE).perform()
        Thread.sleep(1000)
        challengeEndDateBtn.click()
        calendarNextMonthBtn.click()
        twentiethDay.click()
    }

    fun inputImage() {
        challengeImageInputField.sendKeys("/Users/abhishek/Downloads/profile.png")
    }

    fun clickOnSubmit() {
        submitBtn.click()
    }

}