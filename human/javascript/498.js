const dataToEncrypt = new TextEncoder('utf-8').encode('Hello, World!');

window.crypto.subtle.generateKey({ name: "AES-CBC", length: 128 }, false, ["encrypt", "decrypt"])
  .then(function (key) {
    var iv = window.crypto.getRandomValues(new Uint8Array(16))
    window.crypto.subtle.encrypt({ name: "AES-CBC", iv: iv }, key, dataToEncrypt)
      .then(function (encrypted) {
        console.log(new Uint8Array(encrypted));
      }).catch(function (err) {
        console.error(err);
      });
  }).catch(function (err) {
    console.error(err);
  });