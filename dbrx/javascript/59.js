const whitelist = {
  // assuming some urls are whitelisted
  "https://example.com": true,
  "https://google.com": true
};

const url = "https://example.com";
const msg = "Hello, world!";

function send(url, msg) {
  console.log(`Sending message to ${url}: ${msg}`);
}

if (whitelist.hasOwnProperty(url)) send(url, msg);