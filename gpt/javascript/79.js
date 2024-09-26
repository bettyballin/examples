
function isCrossDomainIframe(iframe) {
  try {
    // In some browsers, accessing the contentDocument property will throw an error
    var doc = iframe.contentDocument || iframe.contentWindow.document;
    // If no error was thrown, we should have access to the document
    return false;
  } catch (e) {
    // An error was thrown, which means the document is from a different domain
    return true;
  }
}

// Example usage with the first iframe on the page
var iframe = document.getElementsByTagName('iframe')[0];
if (isCrossDomainIframe(iframe)) {
  console.log("The iframe is cross-domain.");
} else {
  console.log("The iframe is not cross-domain.");
}
