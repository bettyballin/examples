const puppeteer = require('puppeteer');

async function inspectDOM(url) {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();

  // Navigate to the given URL
  await page.goto(url);

  // Extract and analyze DOM content
  let domContent = await page.content();

  console.log(`DOM Content: ${domContent}`);

  await browser.close();
}

// Replace 'https://example.com' with the URL you want to inspect
inspectDOM('https://example.com');