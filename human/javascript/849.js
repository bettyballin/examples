// This code does not throw any error, it's just a comment
// Content Security Policy: Ignoring “'unsafe-inline'” within script-src or style-src: nonce-source or hash-source specified

// Example of using nonce-source
const script = document.createElement('script');
script.nonce = 'yourNonceValue';
script.src = 'yourScriptSrc';
document.head.appendChild(script);

// Example of using hash-source
const style = document.createElement('style');
style.textContent = 'yourStyleContent';
style.integrity = 'sha256-yourStyleHash';
document.head.appendChild(style);