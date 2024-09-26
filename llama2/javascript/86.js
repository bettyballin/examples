const http = require('http');
const httpProxy = require('http-proxy');

const targetUrl = 'https://example.com'; // Replace with the URL of the website you want to scrape

const proxy = httpProxy.createProxyServer({
  target: targetUrl,
  changeOrigin: true,
  pathRewrite: { '^/proxy': '' }
});

http.createServer((req, res) => {
  proxy.web(req, res);
}).listen(5050, () => {
  console.log('Proxy server listening on port 5050');
});