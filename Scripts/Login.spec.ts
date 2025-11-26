import {test, expect, Browser, Page, Locator, BrowserContext} from '@playwright/test'
import { webkit, chromium,firefox } from '@playwright/test'

test('login test' , async()=>{
    const browser:Browser=await chromium.launch({headless:false});
    /* Browser Context flows for multiple browers
    const browserContext1 : BrowserContext=await browser.newContext();
     const page1: Page=await browserContext1.newPage();
     */
    const page:Page=await browser.newPage();
    await page.goto("https://www.amazon.in");
    await page.hover('//button[@aria-label="Expand Account and Lists"]');
    await page.locator('[class*="signin"]').click();
    const emailId:Locator=await page.locator('#ap_email_login');
    emailId.fill('abc.com');
    const isVisible=await page.getByText('Create a free business account').isVisible();
    console.log("Element Visible +isVisible");
    expect(isVisible).toBe(true);
    await page.screenshot({path: 'signInPage.png'});
     await browser.close();
     await page.close();

     //await new Promise(()=>{}); //prevent your script from existing;






});