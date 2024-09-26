function init_download(url) {
  console.log(`Download initialized: ${url}`);
}

document.body.innerHTML = `
  <a href="//www.example.com/your_download" onclick="init_download(this.href);return false" target="_blank">Test</a>
`;