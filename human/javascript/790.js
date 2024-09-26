(() => {
  const XHR = XMLHttpRequest;
  Object.freeze(XHR);

  // use XHR here ...
  const xhr = new XHR();
  xhr.open('GET', 'https://example.com', true);
  xhr.onload = function() {
    if (xhr.status === 200) {
      console.log(xhr.responseText);
    }
  };
  xhr.send();
})();