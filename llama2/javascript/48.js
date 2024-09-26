chrome.runtime.onMessage.addListener(function(request, sender, sendResponse) {
  if (request.action === 'doSomething') {
    // Perform some action here
    sendResponse({ result: 'Success' });
  }
});