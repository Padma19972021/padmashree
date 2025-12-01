import {expect, Locator, Page} from '@playwright/test';

export class HomePage{
    readonly page: Page;
    readonly logo: Locator;
      readonly searchBox: Locator;
  readonly searchButton: Locator;
  readonly signInMenuItem: Locator;
  readonly returnsOrders: Locator;
  readonly cartIcon: Locator;
  readonly signInMenuItemButton: Locator;
  readonly menuCategories: Locator;
  readonly searchSuggestions:Locator;


    constructor(page:Page){
        this.page=page;
        this.logo=this.page.getByRole('link',{name:'Amazon.in'});
    //await page.getByRole('searchbox',{name:'Search Amazon.in'}); // or
    this.searchBox=this.page.getByPlaceholder('Search Amazon.in');
    this.searchButton=page.getByRole('button',{name:'Go'}).first();
    
   // const signInMenuItem=page.locator("//span[text()='Hello, sign in']");
    //this.signInMenuItem=page.getByText('Hello, sign in >> Account & Lists'); //xpath axis methods
    this.signInMenuItem=page.getByRole('link',{name:'Hello, sign in Account & Lists'});
    
    
    this.signInMenuItemButton= page.getByRole('button', {name:'Expand Account and Lists'});
    this.returnsOrders= page.getByRole('link',{name:'Returns & Orders'});
    this.cartIcon= page.getByRole('link',{name:'items in cart'});
    this.menuCategories=page.locator('#nav-xshop ul li a');

    this.searchSuggestions=page.locator('div[role="row"]');
}
    async navigate()
    {
        await this.page.goto('https://amazon.in');
    }

    async click(element: Locator){
        await element.waitFor({state:'visible'});
        await element.click();
    }
    async search(element:Locator, key:any){
        await element.waitFor({state:'visible'});
        await element.fill(key);
    }
    async dynamicSearch(element: Locator){
        //const suggestionRows=await page.locator('div[role="row"]');
    await expect(this.searchSuggestions.first()).toBeVisible();
    const len=await this.searchSuggestions.count();
    console.log("suggestions length" +len);
    const suggestions =this.searchSuggestions.allInnerTexts();
    for (const ele of await suggestions){
        console.log(ele);
    }
    }
    async verifyTitle(expectedTitle:string){
        const actualTitle=await this.page.title();
        console.log(actualTitle);
        await expect(this.page).toHaveTitle(expectedTitle);
    }
}