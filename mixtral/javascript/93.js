const urlParams = new URLSearchParams(window.location.search);
document.write(`test=${urlParams.get('test')}`)
// or
document.write(`test=${encodeURIComponent(urlParams.get('test'))}`)