const iframe = document.querySelector('iframe');
const link = iframe.contentDocument.createElement('a');
link.href = 'https://domain2.com/some-link';
link.target = '_parent';
link.onclick = function() {
  window.open(this.href, this.target, 'width=400,height=400');
};
iframe.contentDocument.body.appendChild(link);


html
<iframe src="iframe.html" frameborder="0" width="500" height="500"></iframe>