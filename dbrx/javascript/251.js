// Send a message to the webview.ts file.
window.parent.postMessage({ type: 'myMessage', data: '*' });