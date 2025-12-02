import test from "node:test";
import {Page, Locator, expect} from '@playwright/test';

export class BasePage{
    protected page: Page;

    constructor(page:Page){
        this.page=page;
    }

    async click(element: Locator | string){
        if(typeof element==='string'){
            await this.page.locator(element).click();
        }
        else{
            await element.click();
        }
    }
    async enterText(element: Locator|string, text:string){
        if(typeof element==='string'){
            await this.page.fill(element,text);
        }
        else{
            await element.fill(text);
        }
    }
    // Validate page title (exact match)
    async verifyTitle(expectedTitle:string){
        const actualTitle=this.page.title();
        console.log("Actual title is " + actualTitle);
        console.log("Expected Title is " + expectedTitle);
        await expect(this.page).toHaveTitle(expectedTitle);
    }
    // Validate page title contains text
    async verifyTitleContains(text:string){
        expect(this.page).toHaveTitle(new RegExp(text));
        //await expect(this.page).toHaveTitle(new RegExp(text, 'i'));
    }
    // Validate page title (exact match)
    async verifyURL(expectedURL:string){    
        const actualURl=this.page.url();
        console.log("Actual Url is " +actualURl);
        console.log("Expected Url is " + expectedURL);
        expect(this.page).toHaveURL(expectedURL);

    }

// Validate page title contains text
    async verifyUrlContains(text:string){
        expect(this.page).toHaveURL(new RegExp(text));
    }

    async verifyVisible(element: Locator| string){
        if(typeof element==='string'){
        await expect(this.page.locator(element)).toBeVisible();

    }
    else{
        await expect(element).toBeVisible();
    }
}
    async getText(element:Locator){
       await element.textContent();
    }
    async hardWait(seconds:number){
    await this.page.waitForTimeout(seconds*1000);
    }
}