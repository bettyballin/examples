// Save data
let obj = {token: "your_token_here"};
chrome.storage.local.set(obj, function() {
  console.log("Token saved");
});

// Get the token back
chrome.storage.local.get(["token"], function(result) {
  console.log("Value currently is " + result.token);
});