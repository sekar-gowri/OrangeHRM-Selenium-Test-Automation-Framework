package orangehrm_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//created page object class for login page using page factory
public class Login_Page {

	public WebDriver local_driver;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement txt_Username;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement txt_Password;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement btn_Login;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")
	WebElement user_id;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]")
	WebElement logout;

	public void username(String uname) {
		txt_Username.sendKeys(uname);
	}

	public void password(String pwd) {
		txt_Password.sendKeys(pwd);
	}

	public void login() {
		btn_Login.click();
	}

	public void userid() {
		user_id.click();
	}

	public void logout() {
		logout.click();
	}

	public Login_Page(WebDriver remote_driver) {

		local_driver = remote_driver;
		PageFactory.initElements(remote_driver, this);

	}

}
