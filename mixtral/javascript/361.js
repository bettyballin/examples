const { session } = require('electron');

let cspHeader = "Content-Security-Policy";

if (process.env.NODE_ENV === 'development' || process.env.ELECTRON_START_URL) {
  session.defaultSession.webRequest.onHeadersReceived((details, callback) => {
    delete details.responseHeaders[cspHeader];

    if (callback && typeof callback === "function") {
      return callback({ cancel: false, responseHeaders: details.responseHeaders });
    }
  });
}