

// const All:Locator = page.getByRole('span', {name:'Open All Categories Menu'});
// const MXPlayer:Locator = page.getByRole('a', {name:'MX Player'});

import {test, expect, Browser, Page, Locator, BrowserContext} from '@playwright/test'
import { webkit, chromium,firefox } from '@playwright/test'
import { HomePage } from '../Pages/HomePage.js';

test('Home Page test' ,{tag:'@home'} ,async({page})=>{

    const home=new HomePage(page);
    await home.navigate();
    //await page.getByRole('link',{name:'Amazon.in'}).isVisible();
    await expect(home.logo).toBeVisible();
    await home.verifyTitle('Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in');
    await home.verifyTitleContains('Amazon');
    //await page.getByRole('searchbox',{name:'Search Amazon.in'}); // or
    //await page.getByPlaceholder('Search Amazon.in');
    await expect(home.searchBox).toBeVisible();
    //await page.getByRole('button',{name:'Go'}).first().isVisible();
    await expect(home.searchButton).toBeEnabled();
    //await page.getByRole('link',{name:'Hello, sign in Account & Lists'});
    await expect(home.signInMenuItem).toBeVisible();
    //await page.locator("//span[text()='Hello, sign in']");
    //await page.getByText('Hello, sign in >> Account & Lists'); //xpath axis methods
    //await page.getByRole('button', {name:'Expand Account and Lists'}).isVisible();
    await expect(home.signInMenuItemButton).toBeVisible();
    //await page.getByRole('link',{name:'Returns & Orders'}).isVisible();
    await expect(home.returnsOrders).toBeVisible();
    //await page.getByRole('link',{name:'items in cart'}).isVisible();
    await expect(home.cartIcon).toBeVisible();
    const expectedMenu=['Expand Account and Lists','Returns & Orders','items in cart'];
    const menuCategoriesLocator=await home.menuCategories;
    console.log(menuCategoriesLocator.count());
    console.log(await menuCategoriesLocator.allInnerTexts());
    await home.click(home.searchBox);
    await home.enterText(home.searchBox, 'iphone');
    //await home.page.waitForSelector("div[role='row']", { state: "visible",timeout: 15000 });
    await home.dynamicSearch(home.searchSuggestions);


});