function canAccessIFrame(iframe) {
    var html = null;
    try { 
      // deal with older browsers
      var doc = iframe.contentDocument || iframe.contentWindow.document;
      html = doc.body.innerHTML;
    } catch(err){
      // do nothing
    }

    return(html !== null);
}

// Example usage:
var iframe = document.createElement('iframe');
iframe.src = 'https://example.com';
document.body.appendChild(iframe);

console.log(canAccessIFrame(iframe));  // Output: false (due to same-origin policy)

iframe.src = 'javascript:"<html><body>Hello, World!</body></html>"';
console.log(canAccessIFrame(iframe));  // Output: true