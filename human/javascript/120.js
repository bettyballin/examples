function canAccessIFrame(iframe) {
  try {
    var document = iframe.contentDocument || iframe.contentWindow.document;
    return document !== null;
  } catch (e) {
    return false;
  }
}

var accessAllowed = canAccessIFrame(document.getElementsByTagName('iframe')[0]);
console.log(accessAllowed);