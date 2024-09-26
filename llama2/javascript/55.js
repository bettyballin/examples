Here is the executable code:


// manifest.json
{
  "name": "My Extension",
  "version": "1.0",
  "manifest_version": 2,
  "content_scripts": [
    {
      "matches": ["<all_urls>"],
      "js": ["app.js"]
    }
  ],
  "background": {
    "scripts": ["background.js"]
  }
}

// app.js
function injectScript() {
  // Get the iframe element
  var iframe = document.querySelector("iframe");

  // Inject the script into the iframe
  var script = iframe.ownerDocument.createElement("script");
  script.src = chrome.runtime.getURL('injectedScript.js');
  iframe.contentWindow.document.body.appendChild(script);
}

injectScript();

// background.js
chrome.runtime.onMessage.addListener(function(request, sender, sendResponse) {
  if (request.action === 'injected') {
    console.log('Script injected!');
  }
});

// injectedScript.js
console.log('Injected script running!');
chrome.runtime.sendMessage({ action: 'injected' });