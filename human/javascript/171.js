// Create a new HTML document and add the script
var html = '<html><head><script>' +
  'if (top.location !== self.location){' +
  '  top.location = self.document.location;' +
  '}' +
  '</script></head><body></body></html>';

// Create a new window and load the HTML document
var win = window.open('', '', 'width=500,height=500');
win.document.write(html);
win.document.close();