// This code is not executable as it is a Content Security Policy (CSP) directive,
// not a JavaScript code. However, you can set it using the following JavaScript code:

const meta = document.createElement('meta');
meta.httpEquiv = 'Content-Security-Policy';
meta.content = "default-src 'self'; frame-src 'none'; object-src 'none';";
document.head.appendChild(meta);