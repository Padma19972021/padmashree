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
    //page.waitForURL('**/ap/signin');
    await page.hover('//button[@aria-label="Expand Account and Lists"]');
    await page.locator('[class*="signin"]').click();
    
    const expectedLinks =[
        'Conditions of Use',
        'Privacy Notice',
        'Create a free business account'
    ];
   const links=await page.$$('a');
   console.log("Total links are :"+links.length);

   const actualLinks:string[]=[];

   for (let i = 0; i < links.length; i++){
        const linkText=(await links[i]!.innerText()).trim();// added non null assertion ! just to make sure its not undefined
        actualLinks.push(linkText);

   }
   for(const text of expectedLinks){
    console.log(actualLinks.includes(text) ? `Link found: ${text}` : `Link not found: ${text}`); 
   }
   expect(actualLinks).toEqual(expect.arrayContaining(expectedLinks));
    const emailId:Locator=await page.locator('#ap_email_login');
    emailId.fill('abc.com');
    const isVisible=await page.getByText('Create a free business account').waitFor({state:'visible',timeout:5000}).then(()=>true).catch(()=>false);
    console.log("Element Visible" + isVisible);
    expect(isVisible).toBe(true);
    await page.screenshot({path: 'signInPage.png'});
    //  await browser.close();
    //  await page.close();

     //await new Promise(()=>{}); //prevent your script from existing;

});
/*
test('collect all links from login page', async({page})=>{
await page.goto("https://www.amazon.in/ap/signin");
   // 

    const expectedLinks =[
        'Conditions of Use',
        'Privacy Notice',
        'Create a free business account'
    ];
   const links=await page.$$('a');
   console.log("Total links are :"+links.length);

   const actualLinks:string[]=[];

   for (let i = 0; i < links.length; i++){
        const linkText=(await links[i]!.innerText()).trim();// added non null assertion ! just to make sure its not undefined
        actualLinks.push(linkText);

   }
   for(const text of expectedLinks){
    console.log(actualLinks.includes(text) ? `Link found: ${text}` : `Link not found: ${text}`); 
   }
   expect(actualLinks).toEqual(expect.arrayContaining(expectedLinks));

});
*/