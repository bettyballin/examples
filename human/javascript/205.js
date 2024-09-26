class WebClient {
  constructor(color) {
    this.color = color;
  }

  shouldOverrideUrlLoading(view, url) {
    view.loadUrl(url);
    return true;
  }

  onPageFinished(view, url) {
    const command = `javascript:document.body.style.background = '${this.color}';`;
    view.loadUrl(command);
  }
}