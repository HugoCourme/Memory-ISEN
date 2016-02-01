package edu.isen.jee.memory.Web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MemoryWebPage {

	@FindBy(id = "board")
	WebElement board;

	@FindBy(id = "reset")
	WebElement resetButton;
	

	@FindBy(id = "score")
	WebElement score;

	private final String CARD_SELECTOR = "//div[@id='board']/div[contains(@class,'column')]";

	public MemoryWebPage(WebDriver driver) {
		driver.get("http://localhost:9090/memory/index.jsp");
	}

	public void play(int i) {
		getCard(i).click();
	}

	private List<WebElement> getCards() {
		return board.findElements(By.xpath(CARD_SELECTOR));
	}

	public boolean hasBoard() {
		return board.isDisplayed();
	}

	public int getNumberOfCard() {
		return getCards().size();
	}

	public WebElement getCard(int i) {
		return getCards().get(i);
	}

	public boolean isCardFaceUp(int i) {
		return getCard(i).getAttribute("class").contains("disabled");
	}
	
	public int getScore(int player){
		return Integer.parseInt(score.findElements(By.xpath("//div[@class='value']")).get(player).getText());
	}

	public void reset() {
		resetButton.click();
	}

	public boolean hasResetButton() {
		return resetButton.isDisplayed();
	}
}
