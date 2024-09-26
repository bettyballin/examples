// NOTE: Inserting external scripts should be avoided if possible!
// Do not use this method if your extension can completely function
// without external scripts!

// Even if you have to load an external script, make sure that it is loaded over
// https:, NEVER over http: ! If you insert scripts from http:-URLs, your users'
// security can be compromised by MITM attacks.

var x = new XMLHttpRequest();
x.open('GET', 'https://example.com/script.js');
x.onload = function() {
    var s = document.createElement('script');
    s.textContent = x.responseText;
    (document.head || document.documentElement).appendChild(s);
};
x.onerror = function() {
    // Failed to load. Fallback to loading an (old version of your) script
    // that is bundled with your extension. It must be listed in the
    // "web_accessible_resources" section in your manifest file.
    var s = document.createElement('script');
    s.src = chrome.runtime.getURL('script.js');
    (document.head || document.documentElement).appendChild(s);
};
x.send();

// Added this line to execute the code
document.addEventListener("DOMContentLoaded", function () {
  x.send();
});