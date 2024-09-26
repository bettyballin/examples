chrome.runtime.onInstalled.addListener(function() {
  chrome.tabs.executeScript({
    code: `
      document.addEventListener('click', function(event) {
        if (event.target.tagName === 'BUTTON') {
          event.stopPropagation();
          chrome.runtime.sendMessage({ action: 'buttonClicked' });
        }
      });
    `,
    runAt: 'document_end',
    matchAboutBlank: true
  });
});