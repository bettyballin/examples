Here is the code in JavaScript:


const http = require('http');
const https = require('https');
const url = require('url');

class ProxyHandler {
  constructor(username, password, domain) {
    this.username = username;
    this.password = password;
    this.domain = domain;
  }

  processRequest(req, res) {
    try {
      const uri = req.url.substring(req.url.indexOf('?') + 1);

      if (uri.startsWith('ping')) {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<html><body>Hello ProxyHandler</body></html>');
        return;
      }

      res.writeHead(200, { 'Content-Type': 'text/plain' });

      let data = '';
      req.on('data', chunk => {
        data += chunk;
      });
      req.on('end', () => {
        const options = {
          hostname: url.parse(uri).hostname,
          path: url.parse(uri).path,
          method: 'POST',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': `NTLM ${this.createCredientialCached(uri, this.username, this.password, this.domain)}`
          }
        };

        const proxyReq = https.request(options, proxyRes => {
          let response = '';
          proxyRes.on('data', chunk => {
            response += chunk;
          });
          proxyRes.on('end', () => {
            res.end(response);
          });
        });

        proxyReq.write(data);
        proxyReq.end();
      });
    } catch (e) {
      res.end(this.getJSON('', e));
    }
  }

  createCredientialCached(uri, username, password, domain) {
    const auth = 'NTLM ' + Buffer.from(`${domain}\\${username}:${password}`, 'utf8').toString('base64');
    return auth;
  }

  getJSON(id, error) {
    const json = JSON.stringify({ id, error: error ? error.toString() : '' });
    return json;
  }
}

const server = http.createServer((req, res) => {
  const proxyHandler = new ProxyHandler('svcMyServiceAccount', 'password', 'mydomain');
  proxyHandler.processRequest(req, res);
});

server.listen(8080, () => {
  console.log('Server running on port 8080');
});