(() => {
  const {chrome} = window;
  delete window.chrome;

  // Your content script here
  chrome.runtime.sendMessage({ action: 'hello' }, (response) => {
    console.log(response);
  });

  // Rest of your content script...
})();