package edu.isen.jee.memory.Web;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MemoryWebTest {
	private WebDriver driver;
	private MemoryWebPage page;
	private final static int CARD_NUMBER = 16;

	@Before
	public void doBefore() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// Navigate to the right place
		driver.get("http://localhost:9090/memory/index.jsp");
		page = PageFactory.initElements(driver, MemoryWebPage.class);
	}

	@After
	public void doAfter() {
		driver.quit();
	}

	@Test
	public void itCanBrowseThePage() throws Exception {
		assertThat(page.hasBoard()).isTrue();
		assertThat(page.getNumberOfCard()).isEqualTo(CARD_NUMBER);
		assertThat(page.hasResetButton()).isTrue();
	}

	@Test
	public void aPlayerMayPlayACard() throws Exception {
		int card = RandomUtils.nextInt(CARD_NUMBER);
		assertThat(page.isCardFaceUp(card)).isEqualTo(false);
		page.play(card);
		assertThat(page.isCardFaceUp(card)).isEqualTo(true);
	}
	
	@Test
	public void theScoreIncrement() throws Exception{
		assertThat(page.getScore(0)).isEqualTo(0);
		assertThat(page.getScore(1)).isEqualTo(0);
		page.play(RandomUtils.nextInt(CARD_NUMBER));
		assertThat(page.getScore(0)).isEqualTo(2);
		assertThat(page.getScore(1)).isEqualTo(0);
	}

	@Test
	public void aGameMayBeReset() throws Exception {
		int card = RandomUtils.nextInt(CARD_NUMBER);
		page.play(card);
		page.reset();
		assertThat(page.isCardFaceUp(card)).isEqualTo(false);
	}
}
