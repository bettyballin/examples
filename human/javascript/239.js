// Node.js equivalent of the provided PHP code
const fs = require('fs');
const path = require('path');
const http = require('http');

const file = 'path/to/your/file'; // replace with your file path
const filename = path.basename(file);
const fileSize = fs.statSync(file).size;

const headers = {
  'Content-Description': 'File Transfer',
  'Content-Type': 'application/octet-stream',
  'Content-Disposition': `attachment; filename="${filename}"`,
  'Content-Transfer-Encoding': 'binary',
  'Connection': 'Keep-Alive',
  'Expires': '0',
  'Cache-Control': 'must-revalidate, post-check=0, pre-check=0',
  'Pragma': 'public',
  'Content-Length': fileSize
};

http.createServer((req, res) => {
  res.writeHead(200, headers);
  fs.createReadStream(file).pipe(res);
}).listen(3000, () => {
  console.log('Server running on port 3000');
});