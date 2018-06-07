/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egpseleniumgoods;

import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author Nitish Ranjan Bhowmik
 */






public class EgpSeleniumGoods 
{
    public static void main(String[] args) 
    {
        
        System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Gecodriver\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        
        capabilities.setCapability("marionette", true);
        
        Random rand = new Random(); 
        int ii = rand.nextInt(100000); 
        
        try
        {
            WebDriver driver = new FirefoxDriver();
         
            driver.get("http://192.168.3.8:8080/");
            ((JavascriptExecutor) driver).executeScript("return window.stop");
            try
            {
                    driver.manage().window().maximize();
                    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    String currentUrl = driver.getCurrentUrl();

                    //driver.findElement(By.id("txtEmailId"));

                    WebElement email = driver.findElement(By.id("txtEmailId"));
                    email.clear();			

                    WebElement password = driver.findElement(By.name("password"));
                    password.clear();

                    email.sendKeys("pauserrotdormowhs@gmail.com");					
                    password.sendKeys("egp12345");



                    WebElement login = driver.findElement(By.id("btnLogin"));
                    login.submit();


                    String menuPath = "//*[@id='headTabApp']";

                    WebDriverWait wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(menuPath)));  // locating the main menu

                    WebElement menu = driver.findElement(By.xpath(menuPath));
                    Actions builder = new Actions(driver); 
                    builder.moveToElement(menu).build().perform();

                    String dropDownMenuPath = "//ul/li/a[contains(text(),'Create APP')]";

                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDownMenuPath))); 

                    WebElement menuOption = driver.findElement(By.xpath(dropDownMenuPath));
                    builder.moveToElement(menuOption).click().build().perform();

                    //Thread.sleep(1800);
                    String budgetType = "//*[@id='cmbBudgetType']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(budgetType)));
                    Select budgetTypeSelect = new Select(driver.findElement(By.xpath(budgetType)));
                    budgetTypeSelect.selectByIndex(1);


                    driver.findElement(By.xpath("//*[@id='ActivityName']")).sendKeys("TEST_Activitity"+ii);
                    driver.findElement(By.xpath("//*[@id='txtAppCode']")).sendKeys("Letter Ref. No"+ii);


                    String aPPType = "//*[@id='cmbdepoplanWork']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(aPPType)));
                    Select aPPTypeSelect = new Select(driver.findElement(By.xpath(aPPType)));
                    aPPTypeSelect.selectByIndex(3);        

                    login = driver.findElement(By.id("buttonNext"));
                    login.submit();


                    String category = "//*[@id='hrefCPV']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(category)));
                    driver.findElement(By.xpath(category)).click();


                    String procurementCategory = "//*[@id='cmbProcureNature']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(procurementCategory)));
                    Select procurementCategorySelect = new Select(driver.findElement(By.xpath(procurementCategory)));
                    procurementCategorySelect.selectByIndex(1);


                    driver.findElement(By.xpath("//*[@id='txtPackageNo']")).sendKeys("TEST_Package No"+ii);
                    driver.findElement(By.xpath("//*[@id='txtaPackageDesc']")).sendKeys("TEST_Package_Description"+ii);
                    driver.findElement(By.xpath("//*[@id='txtLotNo_1']")).sendKeys("1");
                    driver.findElement(By.xpath("//*[@id='txtLotDesc_1']")).sendKeys("TEST_Lot_Description"+ii);
                    driver.findElement(By.xpath("//*[@id='txtQuantity_1']")).sendKeys("10");
                    driver.findElement(By.xpath("//*[@id='txtUnit_1']")).sendKeys("NOS");
                    WebElement element = driver.findElement(By.xpath("//*[@id='txtEstimateCost_1']"));
                    driver.findElement(By.xpath("//*[@id='txtEstimateCost_1']")).sendKeys("10");

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("$('#txtEstimateCost_1').trigger('change')");


                    String parentWindow = driver.getWindowHandle();
                    System.out.println("before "+driver.getTitle());
                    Set<String> s1 = driver.getWindowHandles();

                    Iterator<String> i1 =  s1.iterator();

                    while(i1.hasNext())
                    {
                        String jsTreePath = "//li[@id='170']/a";

                        String buttonPath = "//*[@id='btnGetCheckedNode']";
                        String childWindow = i1.next();

                        if(!parentWindow.equalsIgnoreCase(childWindow))
                        {
                            driver.switchTo().window(childWindow);

                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jsTreePath)));
                            driver.findElement(By.xpath(jsTreePath)).click();
                            System.out.println("before "+driver.getTitle());
                            //Thread.sleep(1000);
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonPath)));
                            driver.findElement(By.xpath(buttonPath)).click();
                            //driver.close();
                        }
                    }


                    driver.switchTo().window(parentWindow);
                    System.out.println("before "+driver.getTitle());


                    String procurementType = "//*[@id='cmbProcureType']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(procurementType)));
                    Select procurementTypeSelect = new Select(driver.findElement(By.xpath(procurementType)));
                    procurementTypeSelect.selectByIndex(1);

                    String procurementMethod = "//*[@id='cmbProcureMethod']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(procurementMethod)));
                    Select procurementMethodSelect = new Select(driver.findElement(By.xpath(procurementMethod)));
                    procurementMethodSelect.selectByIndex(2);

                    String sourceofFund = "//*[@id='cmbSourceOfFund']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sourceofFund)));
                    Select sourceofFundSelect = new Select(driver.findElement(By.xpath(sourceofFund)));
                    sourceofFundSelect.selectByIndex(2);

                    WebElement login1 = driver.findElement(By.xpath("//*[@id='btnNext']"));

                    login1.click();


                    String datePath = "//*[@id='txtRfqdtadvtift']";


                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date dt = new Date();

                    Calendar cl = Calendar.getInstance();
                    cl.setTime(dt);;
                    cl.add(Calendar.DAY_OF_YEAR, 1);
                    dt=cl.getTime();

                    String str = df.format(dt);

                    System.out.println("the date today is " + str);



                    WebElement date=driver.findElement(By.id("txtRfqdtadvtift"));
                    String dateVal = str;
                    selectDateByJs(driver,date,dateVal);

                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    //jse.executeScript("calculateTotalNoofDays();");
                    js.executeScript("$('#txtRfqdtadvtift').trigger('blur')");


                    driver.findElement(By.xpath("//*[@id='txtRfqexpdtopenNo']")).sendKeys("10");
                    js.executeScript("$('#txtRfqexpdtopenNo').trigger('blur')");
                    driver.findElement(By.xpath("//*[@id='txtRfqdtsubevaRptNo']")).sendKeys("10");
                    js.executeScript("$('#txtRfqdtsubevaRptNo').trigger('blur')");
                    //driver.findElement(By.xpath("//*[@id='txtRfqexpdtopenNo']")).sendKeys("10");
                    js.executeScript("$('#txtRfqexpdtAppawdNo').trigger('blur')");
                    //driver.findElement(By.xpath("//*[@id='txtRfqexpdtopenNo']")).sendKeys("10");
                    js.executeScript("$('#txtRfqexpdtLtrIntAwdNo').trigger('blur')");
                    driver.findElement(By.xpath("//*[@id='txtRfqdtIssNOANo']")).sendKeys("10");
                    js.executeScript("$('#txtRfqdtIssNOANo').trigger('blur')");
                    driver.findElement(By.xpath("//*[@id='txtRfqexpdtSignNo']")).sendKeys("10");
                    js.executeScript("$('#txtRfqexpdtSignNo').trigger('blur')");


                    login = driver.findElement(By.xpath("//*[@id='btnSave']"));


                    login.click();


                    String createWorkflowLink = "//a[contains(@href,'CreateWorkflow.jsp')]";

                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createWorkflowLink))); 

                    menuOption = driver.findElement(By.xpath(createWorkflowLink));
                    builder.moveToElement(menuOption).click().build().perform();



                    String fileProcessingLink = "//a[contains(@href,'FileProcessing.jsp')]";

                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fileProcessingLink))); 

                    menuOption = driver.findElement(By.xpath(fileProcessingLink));
                    builder.moveToElement(menuOption).click().build().perform();        



                    String editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";

                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(editorFramePath)));

                    WebElement editorFrame = driver.findElement(By.xpath(editorFramePath));

                    driver.switchTo().frame(editorFrame);

                    WebElement body = driver.findElement(By.tagName("body"));

                    body.clear(); 
                    body.sendKeys("some text");

                    driver.switchTo().defaultContent();



                    String actionPath = "//*[@id='txtAction']";
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(actionPath)));

                    Select actionPathSelect = new Select(driver.findElement(By.xpath(actionPath)));
                    actionPathSelect.selectByIndex(1);


                    login = driver.findElement(By.xpath("//*[@id='tbnAdd']"));

                    login.click();

                    currentUrl = driver.getCurrentUrl();



                    System.out.println(currentUrl);

                    String appId = grabUrlAppId(currentUrl);
                    System.out.println("Random "+ii);


                    driver.findElement(By.xpath("//a[contains(@href,'Logout.jsp')]")).click();

                    email = driver.findElement(By.id("txtEmailId"));
                    email.clear();			

                    password = driver.findElement(By.name("password"));
                    password.clear();

                    email.sendKeys("hoparotdormowhs@gmail.com");					
                    password.sendKeys("egp12345");

                    login = driver.findElement(By.id("btnLogin"));
                    login.submit();

                    String jqueryGridPath = "//*[@id='list']";

                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jqueryGridPath)));

                    String aPPID = appId+" (APP ID)";    
                    String linkAppID = "";

                    fileProcessingLink = "";

                    String beforeXpath = "//*[@id='list']/tbody/tr[";
                    String afterXpath = "]/td/a";

                    String beforeAppIDXpath = "//*[@id='list']/tbody/tr[";
                    String AfterAppIDXpath = "]/td[4]";

                    WebElement table = driver.findElement(By.id("list")); 
                    List<WebElement> allRows = table.findElements(By.tagName("tr")); 

                    for(int i=1;i<=allRows.size();i++)
                    {
                        linkAppID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();

                        if(linkAppID.equalsIgnoreCase(aPPID))
                        {
                            String s = beforeAppIDXpath+i+AfterAppIDXpath;
                            System.out.println(linkAppID);

                            fileProcessingLink = beforeAppIDXpath+i+"]/td/a[contains(@href,'FileProcessing.jsp')]";

                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fileProcessingLink)));     
                            driver.findElement(By.xpath(fileProcessingLink)).click();
                            break;

                        }
                        //System.out.println(linkAppID);
                    }    

                    //*[@id='list']/tbody/tr[4]/td/a[contains(@href,'FileProcessing.jsp')]
                    editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                    chkEditor(driver, wait, editorFramePath);

                    String dropDownPath = "//*[@id='txtAction']";

                    selectDropdown(driver, wait, dropDownPath, 2);


                    String button = "//*[@id='tbnAdd']";

                    submitButton(driver, button);

                    driver.findElement(By.xpath("//a[contains(@href,'Logout.jsp')]")).click();

                    email = driver.findElement(By.id("txtEmailId"));
                    email.clear();			

                    password = driver.findElement(By.name("password"));
                    password.clear();

                    email.sendKeys("pauserrotdormowhs@gmail.com");					
                    password.sendKeys("egp12345");

                    login = driver.findElement(By.id("btnLogin"));
                    login.submit();


                    menuPath = "//*[@id='headTabApp']";
                    dropDownMenuPath = "//ul/li/a[contains(text(),'My APP')]";

                    dropDownMenuLink(driver, wait, menuPath, dropDownMenuPath, builder);    

                    jqueryGridPath = "//*[@id='list']";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jqueryGridPath)));


                    aPPID = appId;    
                    linkAppID = "";

                    String dashboardLink = "";

                    beforeXpath = "//*[@id='list']/tbody/tr[";
                    afterXpath = "]/td/a";

                    beforeAppIDXpath = "//*[@id='list']/tbody/tr[";
                    AfterAppIDXpath = "]/td[2]";

                    table = driver.findElement(By.id("list")); 
                    allRows = table.findElements(By.tagName("tr")); 

                    for(int i=2;i<allRows.size();i++)
                    {
                        linkAppID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();

                        if(linkAppID.equalsIgnoreCase(aPPID))
                        {
                            String s = beforeAppIDXpath+i+AfterAppIDXpath;
                            System.out.println(linkAppID);

                            dashboardLink = beforeAppIDXpath+i+"]/td/a[contains(@href,'APPDashboard.jsp')]";

                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboardLink)));     
                            driver.findElement(By.xpath(dashboardLink)).click();
                            break;

                        }
                        //System.out.println(linkAppID);
                    }    

                    submitButton(driver, "//a[contains(@href,'APPWorkflowView.jsp')]", wait);

                    //textarea[@id='txtremark']

                    driver.findElement(By.xpath("//textarea[@id='txtremark']")).sendKeys("TEST_Package No");

                    submitButton(driver, "//*[@id=\"btnsubmit\"]", wait);

                    submitButton(driver, "//*[@id=\"resultTable\"]/tbody/tr[2]/td[8]/a[2]", wait);

                    String confirmPath = "//*[@id='popup_ok']";

                    clickTenderPopUp(driver, confirmPath);

                    String url = driver.getCurrentUrl();

                    String tenderId = grabUrlTenderId(url);

                    driver.findElement(By.id("integrityPackcnk")).click();
                    driver.findElement(By.id("chkbidSecDeclaration_0")).click();
                    driver.findElement(By.xpath("//*[@id='txtinvitationRefNo']")).sendKeys("TestSelenium"+tenderId);

                    String dateID = "txtpreQualCloseDate";

                    String ClosingOpeningDate = getDate(driver,dateID,"CloseOpen");

                    jse = (JavascriptExecutor) driver;
                    jse.executeScript("$('#txtpreQualCloseDate').trigger('blur')");

                    String PublicationDateAndTime = getDate(driver,"txttenderpublicationDate","publication");
                    jse.executeScript("$('#txtpreQualCloseDate').trigger('blur')");

                    String LastDateAndTimeBidSecuritySubmission  = getDate(driver,"txtlastDateTenderSub","bidsecurity");
                    jse.executeScript("$('#txtlastDateTenderSub').trigger('blur')");

                    String TenderDocumentsellingdownloadinGDateTime  = getDate(driver,"txttenderLastSellDate","download");
                    jse.executeScript("$('#txttenderLastSellDate').trigger('blur')");

                    String getText = "";


                    editorFramePath = "//*[@id='cke_1_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                    chkEditor(driver, wait, editorFramePath, "Eligibility of Bidder/Consultant");


                    editorFramePath = "//*[@id='cke_2_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                    chkEditor(driver, wait, editorFramePath, "Selenium Webdriver Test Tender: Brief Description of Goods and Related Service :");

                    driver.findElement(By.xpath("//*[@id='locationlot_0']")).sendKeys("PA Office");
                    driver.findElement(By.xpath("//*[@id='tenderSecurityAmount_0']")).sendKeys("1000");



                    String ContractStartDate   = getDate(driver,"startTimeLotNo_0",1);
                    jse.executeScript("$('#startTimeLotNo_0').trigger('blur')");

                    String ContractEndDate    = getDate(driver,"complTimeLotNo_0",2);
                    jse.executeScript("$('#complTimeLotNo_0').trigger('blur')");


                    submitButton(driver, "//*[@id='btnsubmit']", wait);

                    By by = By.xpath("//*[@id='spantxtpreQualCloseDate']/div[@class='reqF_1']");

                    Boolean elementID = FindElement(driver, by, 1);


                    if(elementID == true)
                    {
                        getText = driver.findElement(By.xpath("//*[@id='spantxtpreQualCloseDate']/div[@class='reqF_1']")).getText();
                    }
                    else
                    {
                        by = By.xpath("//*[@id='demoClose']");

                        elementID = FindElement(driver, by, 3);
                        if(elementID == true)
                        {
                            getText = driver.findElement(By.xpath("//*[@id='demoClose']")).getText();
                        }
                    }

                    if(getText.equalsIgnoreCase("Closing and Opening Date can not be weekend!") || getText.equalsIgnoreCase("Weekend!"))
                    {
                        ClosingOpeningDate = getDate(driver, dateID, 43,"CloseOpen",ClosingOpeningDate);

                        jse.executeScript("$('#txtpreQualCloseDate').trigger('blur')");
                        submitButton(driver, "//*[@id='btnsubmit']", wait);
                    }
                    else
                    {
                        submitButton(driver, "//*[@id='btnsubmit']", wait);
                    }

                    driver.findElement(By.xpath("//*[@id='txttenderValidity']")).sendKeys("90");

                    js.executeScript("$('#txttenderValidity').trigger('blur')");
                    driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();

                    submitButton(driver, "//a[contains(@href,'TenderDocPrep.jsp')]", wait);



                String formTenderID="";
                String beforeActionLinkID="";
                String afterActionLinkID="";
                String fromDashBoardLinkID="";
                beforeAppIDXpath = "//table[";
                AfterAppIDXpath = "]/tbody/tr/th[contains(text(),'Form Name 2')]";

                String genearateXpath="";

                //By by;
                Boolean flag = false;
                Boolean discountFrom = false;

                for(int i=1;i<=5;i++)
                {
                    String ss = beforeAppIDXpath+i+AfterAppIDXpath;
                    by = By.xpath(beforeAppIDXpath+i+AfterAppIDXpath);
                    flag = FindElement(driver, by, 1);
                    if(flag == true)
                    {
                        formTenderID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();
                        if(formTenderID.equalsIgnoreCase("Form Name 2"))
                        {
                            beforeActionLinkID = beforeAppIDXpath+i+"]/tbody/tr[";                        
                            afterActionLinkID = "]/td[3]/a[contains(@href,'TenderTableDashboard.jsp')]";
                            for(int j=1;j<=5;j++)
                            {
                                fromDashBoardLinkID = beforeActionLinkID+j+afterActionLinkID;
                                by = By.xpath(fromDashBoardLinkID);
                                flag = FindElement(driver, by, 1);
                                if(flag == true)
                                {
                                    submitButton(driver, fromDashBoardLinkID, wait);
                                    printUrl(driver);
                                    submitButton(driver, "//a[contains(text(),'Fill up the Tables')]", wait);
                                    printUrl(driver);

                                    genearateXpath = "//*[@id='frmTableCreation']/table[2]/tbody/tr/td[contains(text(),'Discount Form')]";
                                    by = By.xpath(genearateXpath);
                                    discountFrom = FindElement(driver, by, 1);

                                    if(discountFrom == true)
                                    {
                                        submitButton(driver, "//*[@id='sucolumnbBtnCreateEdit']", wait);
                                        driver.switchTo().alert().accept();                    
                                        submitButton(driver, "//a[contains(text(),'Tender Document')]", wait);
                                    }
                                    else
                                    {
                                        submitButton(driver, "//a[contains(text(),'Add Row')]", wait);

                                        docFiilUp(driver, wait);
                                        submitButton(driver, "//*[@id='sucolumnbBtnCreateEdit']", wait);
                                        driver.switchTo().alert().accept();

                                        submitButton(driver, "//a[contains(text(),'Tender Document')]", wait);
                                        printUrl(driver);
                                    }




                                }
                            }
                        }
                    }
                    //System.out.println(linkAppID);
                }


                submitButton(driver, "//a[contains(@href,'Notice.jsp')]", wait); //notice tab

                submitButton(driver, "//a[contains(text(),'Add Currency')]", wait); //add currency link

                selectDropdown(driver, wait, "//*[@id='ddlCurrency']", 3);  // American Dollar

                submitButton(driver, "//*[@id='btnAddCurrency']", wait); //add currency 

                submitButton(driver, "//a[contains(text(),'Go Back To Dashboard')]", wait);

                submitButton(driver, "//a[contains(text(),'Add Currency Rate')]", wait);

                driver.findElement(By.xpath("//*[@id='currencyRate_12']")).clear();
                driver.findElement(By.xpath("//*[@id='currencyRate_12']")).sendKeys("85.0000");
                //JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("$('#currencyRate_12').trigger('blur')");

                submitButton(driver, "//*[@id='btnsubmit']", wait);

                driver.switchTo().alert().accept();


                submitButton(driver, "//a[contains(@href,'AddPckLotEstCost.jsp')]", wait);

                //Official Cost Estimate
                driver.findElement(By.xpath("//*[@id='taka_0']")).clear();
                driver.findElement(By.xpath("//*[@id='taka_0']")).sendKeys("10");
                jse.executeScript("$('#taka_0').trigger('blur')");

                submitButton(driver, "//*[@id='submit']", wait);



                //Tender Committee Details

                submitButton(driver, "//*[@id='tcTab']", wait);

                submitButton(driver, "//a[contains(@href,'TenderCommFormation.jsp')]", wait);


                driver.findElement(By.xpath("//*[@id='txtcommitteeName']")).sendKeys("TC");

                clickTenderPopUp(driver, "//*[@id='addmem']");


                Boolean tcMemberDone = false;
                String hopaName = "";
                String procurementRole="";
                List<WebElement>rows = driver.findElements(By.xpath("//*[@id='pe1']/table/tbody/tr"));
                //allRows = table.findElements(By.tagName("tr")); 

                beforeXpath = "//*[@id='pe1']/table/tbody/tr[";
                afterXpath = "]/td[4]";
                String roleNameXpath ="]/td[2]";

                String clickLink = "";
                //*[@id='pe1']/table/tbody/tr[2]/td[4]
                //*[@id='pe1']/table/tbody/tr
                int memeberCount = 0;
                int tcMemberCount = 0;
                for(int i=2;i<=rows.size();i++)
                {
                    procurementRole = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();

                    if(memeberCount < 5)
                    {   
                        if(procurementRole.equalsIgnoreCase("HOPA") || procurementRole.equalsIgnoreCase("TC"))       
                        {
                            if(procurementRole.equalsIgnoreCase("HOPA"))
                            {
                                hopaName = driver.findElement(By.xpath(beforeXpath+i+roleNameXpath)).getText();
                            }
                            if(procurementRole.equalsIgnoreCase("TC"))
                            {
                                tcMemberCount++;
                            }

                            String s = beforeXpath+i+"]/td/label/input";
                            System.out.println(procurementRole);

                            clickLink = beforeXpath+i+"]/td/label/input";
                            memeberCount++;

                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink)));     
                            driver.findElement(By.xpath(clickLink)).click();

                        }
                    }
                    else
                    {
                        break;
                    }

                }
                if(memeberCount < 5 )
                {
                    for(int i=2;i<=rows.size();i++)
                    {
                        procurementRole = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();

                        if(memeberCount < 5)
                        {   
                            if(procurementRole.equalsIgnoreCase("TOC"))       
                            {
                                String s = beforeXpath+i+"]/td/label/input";
                                System.out.println(procurementRole);

                                clickLink = beforeXpath+i+"]/td/label/input";
                                memeberCount++;

                                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink)));     
                                driver.findElement(By.xpath(clickLink)).click();

                            }
                        }
                        else if(memeberCount == 5)
                        {
                            tcMemberDone = true;
                            break;
                        }

                    }
                }

                if(tcMemberDone != true)
                {
                    for(int i=2;i<=rows.size();i++)
                    {
                        procurementRole = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();

                        if(memeberCount < 5)
                        {   
                            if(procurementRole.equalsIgnoreCase("TEC"))       
                            {
                                String s = beforeXpath+i+"]/td/label/input";
                                System.out.println(procurementRole);

                                clickLink = beforeXpath+i+"]/td/label/input";
                                memeberCount++;

                                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink)));     
                                driver.findElement(By.xpath(clickLink)).click();

                            }
                        }
                        else
                        {
                            break;
                        }

                    }
                }



                submitButton(driver, "//button[1]", wait);

                //*[@id="members"]/tbody/tr[3]/td[1]

                rows = driver.findElements(By.xpath("//*[@id='members']/tbody/tr"));

                beforeXpath = "//*[@id=\"members\"]/tbody/tr[";
                afterXpath = "]/td[2]";
                roleNameXpath ="]/td[1]";
                for(int i=1;i<=rows.size();i++)
                {
                    procurementRole = driver.findElement(By.xpath(beforeXpath+i+roleNameXpath)).getText();

                    if(procurementRole.equalsIgnoreCase(hopaName))       
                    {
                        //String s = beforeXpath+i+"]/td/label/input";
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 0);  

                    }
                    else if(i == 2)
                    {
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 1); 
                    }
                    else
                    {

                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 2);  
                    }
                }

                submitButton(driver, "//*[@id='btnSubmit']", wait);

                //Notify TC Memebers
                submitButton(driver, "//a[contains(text(),'Notify Committee Members')]", wait);
                driver.findElement(By.xpath("//*[@id='txtaRemarks']")).sendKeys("TC");
                submitButton(driver, "//*[@id='btnPublish']", wait);


                //Tender Committee Process
                submitButton(driver, "//a[contains(@href,'OpenComm.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'OpenCommFormation.jsp')]", wait);
                driver.findElement(By.xpath("//*[@id='txtcommitteeName']")).sendKeys("TOC");
                submitButton(driver, "//*[@id='addmem']", wait);



                Boolean tocMemberDone = false;

                rows = driver.findElements(By.xpath("//*[@id='pe1']/table/tbody/tr"));
                //allRows = table.findElements(By.tagName("tr")); 

                beforeXpath = "//*[@id='pe1']/table/tbody/tr[";
                afterXpath = "]/td[4]";
                roleNameXpath ="]/td[2]";

                clickLink = "";
                int tocMemberCount = 0;
                memeberCount = 0;
                for(int i=2;i<=rows.size();i++)
                {
                    procurementRole = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();

                    if(memeberCount < 2)
                    {   
                        if(procurementRole.equalsIgnoreCase("HOPA") || procurementRole.equalsIgnoreCase("TOC"))       
                        {
                            if(procurementRole.equalsIgnoreCase("HOPA"))
                            {
                                hopaName = driver.findElement(By.xpath(beforeXpath+i+roleNameXpath)).getText();
                            }
                            if(procurementRole.equalsIgnoreCase("TOC"))
                            {
                                tocMemberCount++;
                            }

                            String s = beforeXpath+i+"]/td/label/input";
                            System.out.println(procurementRole);

                            clickLink = beforeXpath+i+"]/td/label/input";
                            memeberCount++;

                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink)));     
                            driver.findElement(By.xpath(clickLink)).click();

                        }
                    }
                    else
                    {
                        break;
                    }

                }
                
                submitButton(driver, "//button[1]", wait);

                rows = driver.findElements(By.xpath("//*[@id='members']/tbody/tr"));

                beforeXpath = "//*[@id='members']/tbody/tr[";
                afterXpath = "]/td[2]";
                roleNameXpath ="]/td[1]";
                for(int i=1;i<=rows.size();i++)
                {
                    procurementRole = driver.findElement(By.xpath(beforeXpath+i+roleNameXpath)).getText();

                    if(procurementRole.equalsIgnoreCase(hopaName))       
                    {
                        //String s = beforeXpath+i+"]/td/label/input";
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 0);  

                    }
                    else
                    {
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 2); 
                    }
                }

                submitButton(driver, "//*[@id='btnSubmit']", wait);

                //Process file in Workflow
                submitButton(driver, "//a[contains(@href,'CreateWorkflow.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'FileProcessing.jsp')]", wait);

                editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                chkEditor(driver, wait, editorFramePath);

                dropDownPath = "//*[@id=\"txtAction\"]";

                selectDropdown(driver, wait, dropDownPath, 1);
                submitButton(driver, "//*[@id='tbnAdd']", wait);

                //Evaluation Process

                submitButton(driver, "//a[contains(@href,'EvalComm.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'CommFormation.jsp')]", wait);
                driver.findElement(By.xpath("//*[@id='txtcommitteeName']")).sendKeys("TEC");
                submitButton(driver, "//*[@id='addmem']", wait);

                Boolean tecMemberDone = false;
                tocMemberCount = 0;
                rows = driver.findElements(By.xpath("//*[@id='pe1']/table/tbody/tr"));
                //allRows = table.findElements(By.tagName("tr")); 

                beforeXpath = "//*[@id='pe1']/table/tbody/tr[";
                afterXpath = "]/td[4]";
                roleNameXpath ="]/td[2]";
                String paName = "";

                clickLink = "";
                memeberCount = 0;
            
                for(int i=2;i<=rows.size();i++)
                {
                    procurementRole = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();

                    if(memeberCount < 3)
                    {   
                        if(procurementRole.equalsIgnoreCase("PA") || procurementRole.equalsIgnoreCase("TEC"))       
                        {
                            if(procurementRole.equalsIgnoreCase("PA"))
                            {
                                paName = driver.findElement(By.xpath(beforeXpath+i+roleNameXpath)).getText();
                            }
                            if(procurementRole.equalsIgnoreCase("TEC"))
                            {
                                tocMemberCount++;
                            }
                            String s = beforeXpath+i+"]/td/label/input";
                            System.out.println(procurementRole);

                            clickLink = beforeXpath+i+"]/td/label/input";
                            memeberCount++;

                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink)));     
                            driver.findElement(By.xpath(clickLink)).click();
                        }
                    }
                    else
                    {
                        break;
                    }
                }

                submitButton(driver, "//button[1]", wait);

                rows = driver.findElements(By.xpath("//*[@id='members']/tbody/tr"));

                beforeXpath = "//*[@id='members']/tbody/tr[";
                afterXpath = "]/td[2]";
                roleNameXpath ="]/td[1]";
                for(int i=1;i<=rows.size();i++)
                {
                    procurementRole = driver.findElement(By.xpath(beforeXpath+i+roleNameXpath)).getText();

                    if(procurementRole.equalsIgnoreCase(paName))       
                    {
                        //String s = beforeXpath+i+"]/td/label/input";
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 0);  

                    }
                    else if (i == 2)
                    {
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 1); 
                    }
                    else if(i == 3)
                    {
                        System.out.println(procurementRole);

                        clickLink = "//*[@id='cmbMemRole"+(i-1)+"']";

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickLink))); 
                        selectDropdown(driver, wait, clickLink, 2); 
                    }
                }


                submitButton(driver, "//*[@id='btnSubmit']", wait);

                //Process file in Workflow
                //submitButton(driver, "//a[contains(@href,'CommFormation.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'CreateWorkflow.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'FileProcessing.jsp')]", wait);


                editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                chkEditor(driver, wait, editorFramePath);

                dropDownPath = "//*[@id=\"txtAction\"]";

                selectDropdown(driver, wait, dropDownPath, 1);
                submitButton(driver, "//*[@id='tbnAdd']", wait);

                //Whole Workflow

                submitButton(driver, "//a[contains(@href,'TenderDocPrep.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'CreateGrandSummary.jsp')]", wait);
                //*[@id="saveoredit"]
                submitButton(driver, "//*[@id='saveoredit']", wait);

                //a[contains(@href,'TenderDocPrep.jsp')]
                submitButton(driver, "//a[contains(@href,'TenderDocPrep.jsp')]", wait);

                submitButton(driver, "//a[contains(@href,'Notice.jsp')]", wait);

                submitButton(driver, "//a[contains(@href,'PEEncHash.jsp')]", wait);


                driver.findElement(By.xpath("//a[contains(@href,'Logout.jsp')]")).click();

                email = driver.findElement(By.id("txtEmailId"));
                email.clear();			

                password = driver.findElement(By.name("password"));
                password.clear();

                email.sendKeys("hoparotdormowhs@gmail.com");					
                password.sendKeys("egp12345");

                login = driver.findElement(By.id("btnLogin"));
                login.submit();

                jqueryGridPath = "//*[@id='list']";

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jqueryGridPath)));

                String ID = tenderId+" (Tender ID)";    

                fileProcessingLink = "";

                beforeXpath = "//*[@id='list']/tbody/tr[";
                afterXpath = "]/td/a";

                beforeAppIDXpath = "//*[@id='list']/tbody/tr[";
                AfterAppIDXpath = "]/td[4]";

                allRows = driver.findElements(By.xpath("//*[@id='list']/tbody/tr"));
                linkAppID = "";

                Boolean rowCount = false;
            
            
                for(int i=1;i<=allRows.size();i++)
                {
                    by = By.xpath(beforeAppIDXpath+i+AfterAppIDXpath);
                    rowCount = FindElement(driver, by, 1);
                    if(rowCount == true)
                    {
                        linkAppID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();

                        if(linkAppID.equalsIgnoreCase(ID))
                        {
                            String s = beforeAppIDXpath+i+AfterAppIDXpath;
                            System.out.println(linkAppID);

                            fileProcessingLink = beforeAppIDXpath+i+"]/td/a[contains(@href,'FileProcessing.jsp')]";
                            by = By.xpath(fileProcessingLink);
                            flag = FindElement(driver, by, 1);

                            if(flag == true)
                            {   
                                driver.findElement(By.xpath(fileProcessingLink)).click();
                                editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                                chkEditor(driver, wait, editorFramePath);

                                dropDownPath = "//*[@id='txtAction']";

                                selectDropdown(driver, wait, dropDownPath, 2);

                                button = "//*[@id='tbnAdd']";

                                submitButton(driver, button);
                                menuPath = "//*[@id='headTabWorkFlow']";
                                dropDownMenuPath = "//ul/li/a[contains(text(),'Pending task')]";

                                dropDownMenuLink(driver, wait, menuPath, dropDownMenuPath, builder);

                                i=0;
                                allRows = driver.findElements(By.xpath("//*[@id='list']/tbody/tr"));

                            }

                        }
                    }
                }

                driver.findElement(By.xpath("//a[contains(@href,'Logout.jsp')]")).click();

                email = driver.findElement(By.id("txtEmailId"));
                email.clear();			

                password = driver.findElement(By.name("password"));
                password.clear();

                email.sendKeys("pauserrotdormowhs@gmail.com");					
                password.sendKeys("egp12345");


                login = driver.findElement(By.id("btnLogin"));
                login.submit();

                jse = (JavascriptExecutor) driver;

                menuPath = "//*[@id='headTabTender']";
                dropDownMenuPath = "//a[contains(text(),'My Tender')]";

                dropDownMenuLink(driver, wait, menuPath, dropDownMenuPath, builder);
                submitButton(driver, "//a[contains(text(),'Under Preparation')]", wait);

                String tenderID = tenderId+",\nTestSelenium"+tenderId;    
                String linktenderID = "";

                dashboardLink = "";

                table = driver.findElement(By.id("resultTable")); 
                allRows = table.findElements(By.tagName("tr"));
                beforeAppIDXpath = "//*[@id='resultTable']/tbody/tr[";
                AfterAppIDXpath = "]/td[2]";

                for(int i=1;i<allRows.size();i++)
                {
                    linktenderID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();
                    if(linktenderID.equalsIgnoreCase(tenderID))
                    {
                        String s = beforeAppIDXpath+i+AfterAppIDXpath;
                        System.out.println(linktenderID);
                        dashboardLink = beforeAppIDXpath+i+"]/td[7]/a[contains(@href,'TenderDashboard.jsp')]";
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboardLink)));     
                        driver.findElement(By.xpath(dashboardLink)).click();
                        break;
                    }
                }

                submitButton(driver, "//a[contains(@href,'OpenComm.jsp')]", wait);
                submitButton(driver, "//a[contains(text(),'Notify Committee Members')]", wait); //notice tab
                driver.findElement(By.xpath("//*[@id='txtaRemarks']")).sendKeys("Notify");
                submitButton(driver, "//*[@id='btnPublish']", wait);
                submitButton(driver, "//a[contains(@href,'EvalComm.jsp')]", wait);
                submitButton(driver, "//a[contains(text(),'Notify Committee Members')]", wait);
                driver.findElement(By.xpath("//*[@id='txtaRemarks']")).sendKeys("Notify");
                submitButton(driver, "//*[@id='btnPublish']", wait);
                submitButton(driver, "//a[contains(@href,'Notice.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'PEEncHash.jsp')]", wait);

                allRows = driver.findElements(By.xpath("//*[@id='frmEnc']/table/tbody/tr"));

                beforeXpath = "//*[@id='frmEnc']/table/tbody/tr[";
                afterXpath = "]/td/input";
                Boolean selected = false;

                for(int i=1;i<=allRows.size();i++)
                {
                    dashboardLink = beforeXpath+i+afterXpath;
                    by = By.xpath(beforeXpath+i+afterXpath);
                    rowCount = FindElement(driver, by, 1);
                    if(rowCount == true)
                    {
                        System.out.println(dashboardLink);
                        System.out.println("Tick method "+i);
                        
                        selectCheckBox(driver, wait,dashboardLink);
                    }
                }
                
                
                submitButton(driver, "//*[@id='hdnsubmit']", wait);
                submitButton(driver, "//a[contains(@href,'CreateWorkflow.jsp')]", wait);
                submitButton(driver, "//a[contains(@href,'FileProcessing.jsp')]", wait);

                editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                chkEditor(driver, wait, editorFramePath);

                dropDownPath = "//*[@id='txtAction']";

                selectDropdown(driver, wait, dropDownPath, 1);
                button = "//*[@id='tbnAdd']";
                submitButton(driver, button);
                
                driver.findElement(By.xpath("//a[contains(@href,'Logout.jsp')]")).click();

                
                //HOPA TENDER APPROVE
                
                email = driver.findElement(By.id("txtEmailId"));
                email.clear();			

                password = driver.findElement(By.name("password"));
                password.clear();

                email.sendKeys("hoparotdormowhs@gmail.com");					
                password.sendKeys("egp12345");

                login = driver.findElement(By.id("btnLogin"));
                login.submit();

                jqueryGridPath = "//*[@id='list']";

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jqueryGridPath)));

                ID = tenderId+" (Tender ID)";    

                fileProcessingLink = "";

                beforeXpath = "//*[@id='list']/tbody/tr[";
                afterXpath = "]/td/a";

                beforeAppIDXpath = "//*[@id='list']/tbody/tr[";
                AfterAppIDXpath = "]/td[4]";

                allRows = driver.findElements(By.xpath("//*[@id='list']/tbody/tr"));
                linkAppID = "";

                rowCount = false;
            
            
                for(int i=1;i<=allRows.size();i++)
                {
                    by = By.xpath(beforeAppIDXpath+i+AfterAppIDXpath);
                    rowCount = FindElement(driver, by, 1);
                    if(rowCount == true)
                    {
                        linkAppID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();

                        if(linkAppID.equalsIgnoreCase(ID))
                        {
                            String s = beforeAppIDXpath+i+AfterAppIDXpath;
                            System.out.println(linkAppID);

                            fileProcessingLink = beforeAppIDXpath+i+"]/td/a[contains(@href,'FileProcessing.jsp')]";
                            by = By.xpath(fileProcessingLink);
                            flag = FindElement(driver, by, 1);

                            if(flag == true)
                            {   
                                driver.findElement(By.xpath(fileProcessingLink)).click();
                                editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                                chkEditor(driver, wait, editorFramePath);

                                dropDownPath = "//*[@id='txtAction']";

                                selectDropdown(driver, wait, dropDownPath, 2);

                                button = "//*[@id='tbnAdd']";

                                submitButton(driver, button);
                                break;

                            }

                        }
                    }
                }
                
                System.out.println(tenderID+" is on Set to Live\n Change Date by Entering the eGPDateChange.jsp");
                
                
                //PA SEE TENDER IS on LIVE or NOT
                
                driver.findElement(By.xpath("//a[contains(@href,'Logout.jsp')]")).click();

                email = driver.findElement(By.id("txtEmailId"));
                email.clear();			

                password = driver.findElement(By.name("password"));
                password.clear();

                email.sendKeys("pauserrotdormowhs@gmail.com");					
                password.sendKeys("egp12345");


                login = driver.findElement(By.id("btnLogin"));
                login.submit();

                jse = (JavascriptExecutor) driver;

                menuPath = "//*[@id='headTabTender']";
                dropDownMenuPath = "//a[contains(text(),'My Tender')]";

                dropDownMenuLink(driver, wait, menuPath, dropDownMenuPath, builder);
                submitButton(driver, "//a[contains(text(),'Under Preparation')]", wait);

                tenderID = tenderId+",\nTestSelenium"+tenderId;    
                linktenderID = "";

                dashboardLink = "";

                table = driver.findElement(By.id("resultTable")); 
                allRows = table.findElements(By.tagName("tr"));
                beforeAppIDXpath = "//*[@id='resultTable']/tbody/tr[";
                AfterAppIDXpath = "]/td[2]";

                for(int i=1;i<allRows.size();i++)
                {
                    linktenderID = driver.findElement(By.xpath(beforeAppIDXpath+i+AfterAppIDXpath)).getText();
                    if(linktenderID.equalsIgnoreCase(tenderID))
                    {
                        String s = beforeAppIDXpath+i+AfterAppIDXpath;
                        //System.out.println(linktenderID);
                        dashboardLink = beforeAppIDXpath+i+"]/td[7]/a[contains(@href,'TenderDashboard.jsp')]";
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboardLink)));     
                        driver.findElement(By.xpath(dashboardLink)).click();
                        break;
                    }
                }
                
                
            }        
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static void selectCheckBox(WebDriver driver, WebDriverWait wait, String xpath) throws InterruptedException
    {
        wait = new WebDriverWait(driver, 15);
        
        //WebElement weUnchecked = driver.findElement(By.xpath(xpath));
        WebElement elementChkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        
        if(!elementChkBox.isSelected()) 
        {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", elementChkBox);
        }
        
        /*if(weUnchecked.isEnabled())
        {
            weUnchecked.click();
            Thread.sleep(200);
        }
        else
        {
            //wait = new WebDriverWait(driver, 10);
            //Thread.sleep(3000);
            //weUnchecked.click();
            //Thread.sleep(3000);
            //wait = new WebDriverWait(driver, 10);
        }
        
        WebElement element = driver.findElement(By.xpath(xpath));

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        */
        
    }
    
    
    public static void docFiilUp(WebDriver driver, WebDriverWait wait) throws InterruptedException
    {
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='FormMatrix']/tbody/tr"));
        
        String genearateXpath="";
        
        String beforeXpath = "//*[@id='FormMatrix']/tbody/tr[";
        String middleXpath = "]/td[";
        String lastXpath = "]/input";
        
        String textAreaXpath = "]/textarea";
        
        By by;
        Boolean flag1 = false, flag2= false;
        
        int row =1;
        
        String description = "Computer";
        String fillDocUpID = "";
      
        for(int i=2;i<=rows.size();i++)
        {
            Thread.sleep(2000);
            for(int j=3;j<=8;j++)
            {
                genearateXpath = beforeXpath+i+middleXpath+j+lastXpath;
                by = By.xpath(beforeXpath+i+middleXpath+j+lastXpath);
                flag1 = FindElement(driver, by, 1);
                if(flag1 == true)
                {
                    if(j==3)
                    {
                        driver.findElement(By.xpath(genearateXpath)).sendKeys(Integer.toString(row));
                    }
                    if(j == 5)
                    {
                        driver.findElement(By.xpath(genearateXpath)).sendKeys("Lot");
                    }
                    if(j == 6)
                    {
                        driver.findElement(By.xpath(genearateXpath)).sendKeys("50");
                    }
                    if(j == 7)
                    {
                        driver.findElement(By.xpath(genearateXpath)).sendKeys("PA Office");
                    }
                    if(j == 8)
                    {
                        driver.findElement(By.xpath(genearateXpath)).sendKeys("10");
                    }
                }
                else
                {
                    genearateXpath = beforeXpath+i+middleXpath+j+textAreaXpath;
                    by = By.xpath(beforeXpath+i+middleXpath+j+textAreaXpath);
                    flag2 = FindElement(driver, by, 1);
                    if(flag2 == true)
                    {
                        driver.findElement(By.xpath(genearateXpath)).sendKeys(description);
                    }
                }
                    
            }
            
            row++;
            description = "Router";
            
           
        }
        
        
        
    }
    
    
    
    public static String getDate(WebDriver driver, String dateID, int yearInc)
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dt);;
        cl.add(Calendar.YEAR, yearInc);
        dt=cl.getTime();

        String date = df.format(dt);

        System.out.println("the date today is " + date);
        
        WebElement element = driver.findElement(By.id(dateID));
        
        selectDateByJs(driver,element,date);
        
        return date;
    }
    
    public static String getDate(WebDriver driver, String dateID, String parameterID)
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dt = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dt);;
        int dateInc = 0;
        if(parameterID.equalsIgnoreCase("publication"))
        {
            dateInc = 1;
        }
        else if(parameterID.equalsIgnoreCase("CloseOpen"))
        {
            dateInc = 40;
        }
        else if(parameterID.equalsIgnoreCase("bidsecurity"))
        {
            dateInc = 31;
        }
        else if(parameterID.equalsIgnoreCase("download"))
        {
            dateInc = 14;
        }
        
        
        cl.add(Calendar.DAY_OF_YEAR, dateInc);
        dt=cl.getTime();

        String date = df.format(dt);

        System.out.println(parameterID+" date is " + date);
        
        WebElement element = driver.findElement(By.id(dateID));
        
        selectDateByJs(driver,element,date);
        
        return date;
    }
    
    
    
    
    
    public static String getDate(WebDriver driver, String dateID, int dateIncreament, String ParameterID, String ClosingOpeningDate)
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dt = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dt);;
        cl.add(Calendar.DAY_OF_YEAR, dateIncreament);
        dt=cl.getTime();

        String date = df.format(dt);

        System.out.println("the date today is " + date);
        
        WebElement element = driver.findElement(By.id(dateID));
        
        selectDateByJs(driver,element,date);
        
        return date;
    }
    
    public static String grabUrlAppId(String url)
    {
        int firstIndex = url.indexOf("ID=");
        int lastIndex = url.indexOf("&msg");
        String appID = "";
        for(int i=firstIndex+3;i<lastIndex;i++)
        {
            appID = appID + url.charAt(i);
        }
        System.out.println(appID);
        return appID;
    }
    
    
    
    public static String grabUrlTenderId(String url)
    {
        
        int firstIndex = url.indexOf('=');
       
        String tenderId = "";
        
        for(int i=firstIndex+1;i<url.length();i++)
        {
            tenderId = tenderId + url.charAt(i);
        }
        System.out.println(tenderId);
        return tenderId;
    }
    
    
    public static void submitButton(WebDriver driver, String editorFramePath)
    {
        driver.findElement(By.xpath("//*[@id='tbnAdd']")).click();
        
    }
    
    
    public static void selectDropdown(WebDriver driver, WebDriverWait wait,String dropDownPath, int selectIndex)
    {
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDownPath)));
        Select dropDownValueSelect = new Select(driver.findElement(By.xpath(dropDownPath)));
        dropDownValueSelect.selectByIndex(selectIndex);
        
    }
    
    
    public static void submitButton(WebDriver driver, String linkPath, WebDriverWait wait)
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkPath)));
        driver.findElement(By.xpath(linkPath)).click();
        
    }
    
    public static void dropDownMenuLink(WebDriver driver, WebDriverWait wait,String menuPath, String dropDownMenuPath, Actions builder)
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(menuPath)));  // locating the main menu
        WebElement menu = driver.findElement(By.xpath(menuPath));
        builder.moveToElement(menu).build().perform();
                
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDownMenuPath))); 
        WebElement menuOption = driver.findElement(By.xpath(dropDownMenuPath));
        builder.moveToElement(menuOption).click().build().perform();
        
    }
    
    
    
    
    public static void selectDateByJs(WebDriver driver,WebElement element, String dateVal)
    {
        JavascriptExecutor js =((JavascriptExecutor)driver);
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
    }
    
    
    public static void chkEditor(WebDriver driver,WebDriverWait wait, String editorFramePath, String content)
    {
        //String editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(editorFramePath)));
                
        WebElement editorFrame = driver.findElement(By.xpath(editorFramePath));

        driver.switchTo().frame(editorFrame);

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear(); 
        body.sendKeys(content);
                
        driver.switchTo().defaultContent();
    }
    
    
    
    public static void chkEditor(WebDriver driver,WebDriverWait wait, String editorFramePath)
    {
        //String editorFramePath = "//iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
                
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(editorFramePath)));
                
        WebElement editorFrame = driver.findElement(By.xpath(editorFramePath));

        driver.switchTo().frame(editorFrame);

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear(); 
        body.sendKeys("some text");
                
        driver.switchTo().defaultContent();
    }
    
    public static void printUrl(WebDriver driver)
    {
        String currentUrl = driver.getCurrentUrl();
    
        System.out.println(currentUrl);
    }
    
    public static Boolean FindElement(WebDriver driver, By by, int timeoutInSeconds)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until( ExpectedConditions.presenceOfElementLocated(by) ); //throws a timeout exception if element not present after waiting <timeoutInSeconds> seconds
            
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public static void clickTenderPopUp(WebDriver driver, String confirmPath)
    {
        try 
        {
            Thread.sleep(1000);
            //element = driver.findElement(By.xpath("//*[@id='popup_container']"));            
        
            WebElement element = driver.findElement(By.xpath(confirmPath));
            
            element.click();
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(EgpSeleniumGoods.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    
    
    
}