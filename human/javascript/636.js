function convertText(text) {
  return text.toUpperCase().replace(/[^A-Z]/g, '').replace(/[A-Z]/g, function(a) {
    return String.fromCharCode(a.charCodeAt(0) + 1);
  });
}

console.log(convertText("Hello, World!"));