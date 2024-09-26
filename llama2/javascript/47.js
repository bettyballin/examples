chrome.runtime.sendMessage({ action: 'doSomething' }, function(response) {
  console.log('Response from extension:', response);
});