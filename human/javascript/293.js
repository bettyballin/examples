var extensionID = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
var data = {}; // Define the data to be sent

if(chrome && chrome.runtime && chrome.runtime.sendMessage) {
  // There is an extension that declared this page in externally_connectable
  chrome.runtime.sendMessage(extensionID, data);
} else {
  // Either this is not Chrome, or no extension wants to listen
  console.log("Either this is not Chrome, or no extension wants to listen");
}