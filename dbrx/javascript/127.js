chrome.webRequest.onHeadersReceived.addListener(
  function(details) {
    let cspHeaderFound = false;
    const headers = details.responseHeaders;

    // Check if there is already CSP or X-Content-Security-Policy in the list.
    for (let i = 0; !cspHeaderFound && i < headers.length; ++i)
      cspHeaderFound =
        'content-security-policy' === headers[i].name.toLowerCase() ||
        'x-content-security-policy' === headers[i].name.toLowerCase();

    if (!cspHeaderFound) {
      // Add your custom CSP header.
      const newCSP = { name: "Content-Security-Policy", value: "default-src 'self';" };
      details.responseHeaders.push(newCSP);
      
      return { responseHeaders: details.responseHeaders };
    }
  },
  { urls: ["<all_urls>"] },
  ["blocking", "responseHeaders"]
);