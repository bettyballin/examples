chrome.webRequest.onCompleted.addListener(function(details) {
  console.log(details);
}, {
  urls: ["<all_urls>"],
  types: ["main_frame"]
});