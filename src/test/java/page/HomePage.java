package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    String HOMEBUTTON = "//h1[contains(text(),'Home')]";
    String PRODUTOSBUTTON = "//h1[contains(text(),'Produtos')]";
    String PESSOASBUTTON = "//h1[contains(text(),'Pessoas')]";
    String OPERACOESBUTTON = "//h1[contains(text(),'Operações')]";
    String FINANCEIROBUTTON = "//h1[contains(text(),'Financeiro')]";
    String PROMOCOESBUTTON = "//li[contains(text(),'Promoções')]";
    String COMUNICACAOBUTTON = "//h1[contains(text(),'Comunicação')]";
    String CONFIGURACOESBUTTON = "//h1[contains(text(),'Configurações')]";
    String SAIRBUTTON = "//h1[contains(text(),'Sair')]";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBttnHome(){
        driver.findElement(By.xpath(HOMEBUTTON)).click();
    }

    public void clickBttnProdutos(){
        driver.findElement(By.xpath(PRODUTOSBUTTON)).click();
    }

    public void clickBttnPessoas(){
        driver.findElement(By.xpath(PESSOASBUTTON)).click();
    }

    public void clickBttnOperacoes(){
        driver.findElement(By.xpath(OPERACOESBUTTON)).click();
    }

    public void clickBttnFinanceiro(){
        driver.findElement(By.xpath(FINANCEIROBUTTON)).click();
    }

    public void clickBttnPromocoes(){
        driver.findElement(By.xpath(PROMOCOESBUTTON)).click();
    }

    public void clickBttnComunicacao(){
        driver.findElement(By.xpath(COMUNICACAOBUTTON)).click();
    }

    public void clickBttnConfiguracoes(){
        driver.findElement(By.xpath(CONFIGURACOESBUTTON)).click();
    }

    public void clickBttnSair(){
        driver.findElement(By.xpath(SAIRBUTTON)).click();
    }
}
