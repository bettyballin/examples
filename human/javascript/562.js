chrome.browserAction.onClicked.addListener(tab => {
    chrome.tabs.executeScript(tab, {code:
        `var theButton = document.querySelector("button");
         if (theButton) theButton.click();`});
});