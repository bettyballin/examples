function b(e, t) {
     var r = document.createElement("script");

     // Set the 'nonce' attribute to match CSP header
     if (r.textContent !== undefined && typeof window['NONCE_VALUE'] === "string")
         r.setAttribute('nonce', window['NONCE_VALUE']);

     // ... rest of your code
}