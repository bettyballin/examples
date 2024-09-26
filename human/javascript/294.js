// Content script
window.addEventListener("PassToBackground", function(evt) {
  chrome.runtime.sendMessage(evt.detail);
}, false);

// Page context
var message = { foo: "bar" }; // define your message here
var event = new CustomEvent("PassToBackground", {detail: message});
window.dispatchEvent(event);