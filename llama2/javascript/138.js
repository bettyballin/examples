const sCustomUrl = "https://example.com"; // replace with your custom URL
const url = new URL(sCustomUrl);
if (url.origin === window.location.origin) {
    window.open(url.href);
}