package orangehrm_test_cases;

import java.io.IOException;

import org.testng.annotations.*;

import orangehrm_base_class.Base_Class;
import orangehrm_page_objects.Login_Page;
import orangehrm_utilities.XLUtils;

public class LoginPage extends Base_Class {

	@Test(dataProvider = "LoginData")
	public void login(String user_name, String pass_word) throws InterruptedException, IOException {

		Login_Page loginpage = new Login_Page(driver);
		loginpage.username(user_name);
		Thread.sleep(4000);
		loginpage.password(pass_word);
		Thread.sleep(4000);
		loginpage.login();
		Thread.sleep(4000);
		Base_Class.captureScreenshot(driver, "HomePage");
		Thread.sleep(4000);
		loginpage.userid();
		Thread.sleep(4000);
		loginpage.logout();
		Thread.sleep(4000);
		Base_Class.captureScreenshot(driver, "LoginPage");
		Thread.sleep(4000);

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "./Test_Data\\LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
