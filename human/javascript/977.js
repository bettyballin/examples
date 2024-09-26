const TokenService = {
  getToken: () => 'your_token_here' // replace with your token service implementation
};

class YourClass {
  constructor() {
    this.fileUrl = './your_file_url_here'; // replace with your file URL
    this.frameEl = {
      nativeElement: {
        contentWindow: null,
        contentDocument: null,
        attr: (key, value) => {
          this.frameEl.nativeElement[key] = value;
        }
      }
    };
  }

  loadFile() {
    const token = TokenService.getToken();
    var headers = [['Content-Security-Policy', 'script-src data:']];
    if (token) {
      headers = headers.concat([['Authorization', token]]);
    }
    const xhr = new XMLHttpRequest();
    xhr.open('GET', this.fileUrl.toString().replace('./', document.baseURI))
    xhr.responseType = 'document';
    xhr.onreadystatechange = ev => {
      if (xhr.readyState === xhr.DONE) {
        if (xhr.status === 200) {
          var content = this.frameEl.nativeElement.contentWindow ||
            this.frameEl.nativeElement.contentDocument.document ||
            this.frameEl.nativeElement.contentDocument;
          content.document.open();
          content.document.write(xhr.response.documentElement.innerHTML);
          content.document.close();
        } else {
          this.frameEl.nativeElement.attr('srcdoc', '<html><head></head><body>Error loading data.</body></html>');
        }
      }
    }
    headers.forEach(function(header) {
      xhr.setRequestHeader(header[0], header[1]);
    });
    xhr.send();
  }
}

const yourInstance = new YourClass();
yourInstance.loadFile();