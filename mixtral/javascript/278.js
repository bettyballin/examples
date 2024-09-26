if(window.trustedTypes && window.TrustedTypePolicy){
    const scriptURL = new window.TrustedTypePolicyFactory().createScriptURL;
}

// Usage
const url = "https://example.com/script.js";
const script = document.createElement('script');
script.src = scriptURL(url);
document.body.appendChild(script);