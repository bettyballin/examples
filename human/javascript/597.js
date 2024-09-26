This is not JavaScript code, it appears to be Apache configuration directives. However, I can provide you with a JavaScript equivalent using Node.js, assuming you want to restrict access to PDF files based on the referer header:


const http = require('http');
const url = require('url');

http.createServer((req, res) => {
  const referer = req.headers.referer;
  const parsedUrl = url.parse(req.url);
  const isPdf = parsedUrl.pathname.endsWith('.pdf');

  if (isPdf && referer && referer.includes('domain.com')) {
    // serve the PDF file
    res.writeHead(200, {'Content-Type': 'application/pdf'});
    // assume the PDF file is in the same directory as the Node.js script
    const fs = require('fs');
    fs.createReadStream(parsedUrl.pathname.slice(1)).pipe(res);
  } else if (isPdf) {
    // deny access to the PDF file
    res.writeHead(403, {'Content-Type': 'text/plain'});
    res.end('Access denied');
  } else {
    // serve other files or handle other requests
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World');
  }
}).listen(8000, () => {
  console.log('Server running on port 8000');
});