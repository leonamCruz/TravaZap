package org.cruz.trava.zap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TravaZap {
    private WebDriver zap;
    private static final String URL_DA_TRAVA = "https://travazap.xyz/wp-content/uploads/2022/07/coringa-fodidor-travazap.xyz_.txt";
    private static final String USER_SELECTED = "//*[@id=\"pane-side\"]/div[2]/div/div/div[8]/div/div/div/div[1]/div";
    private static final String BOX_MESSAGE = "/html/body/div[1]/div/div/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p";
    private static final String XPATH_DA_TRAVA = "/html/body/pre";

    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        zap = new ChromeDriver();
        copiarTrava();
        zap.get("https://web.whatsapp.com");
    }
    private void copiarTrava(){
        zap.get(URL_DA_TRAVA);
        Actions actions = new Actions(zap);
        zap.findElement(By.xpath(XPATH_DA_TRAVA)).click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        actions = new Actions(zap);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
    }
    private void contador(){
        int i = 30;
        while (i >= 0){
            try {
                Thread.sleep(1000);
                System.out.println("Você tem " + i + " segundos para logar");
                i--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void abrirContato(){
        zap.findElement(By.xpath(USER_SELECTED)).click();
    }

    private void clickNaMensagem(){
        zap.findElement(By.xpath(BOX_MESSAGE)).click();
    }

    private void lacoDeMensagens(){
        Actions actions = new Actions(zap);
        clickNaMensagem();
        for(int i = 0; i < 10; i++){
            actions.keyDown(Keys.CONTROL);
            actions.sendKeys("v");
            actions.keyUp(Keys.CONTROL);
            actions.build().perform();
            try {
                System.out.println("Aguarde...");
                Thread.sleep(25000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zap.findElement(By.xpath(BOX_MESSAGE)).sendKeys(Keys.ENTER);
        }
        System.out.println("Obrigado por travar o zap da rapaziada");
    }
    public void zapTravaTudo() {
        setup();
        contador();

        try {
            abrirContato();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Houve alguma falha...");
            System.exit(0);
        }
        lacoDeMensagens();
    }
}