const CryptoJS = require('crypto-js');

const payload = 'eyJpdiI6ImFhMzAxYmQwYjE0ODNiZTQ3ZGIzNGZkYWMzYzZjZGNmIiwiZW5jcnlwdGVkRGF0YSI6IjYzNDUwYjdmNTBmM2I3Y2MyN2UwYmQ5MjlmMjRkNTZmZTFkY2Y4M2I3YjM3MjYxZDE4ZmJkMTc2YWUzZjU2ZTZiYmE3ZjcxNmQ0MWFlNGIxYWEwMTY3NjI4OTEyNjAwYjYwMzc5MmJhNmI4MWRjZTk4ZTQ2NDkxYjNjOGNhYmU5NDVjOWQ1ZDM4MzUzNGY5NWIwNDljYTM1Y2VlZjA2YTMyOTRkNzY2YjVjZDE3MTlmYjAxMTgzZjkyNWNhODFiM2UwOTM2NTUyNzVjYWU2M2JlMTE0Y2JjYTU0NmNiMjc2ODY0N2ZkYzc2YjRkYzJiMDk3ZjExMDQzNDI2OGE1ZGY3ZDVkZjYwYTVkZjZlMzg0NWIyMzYzNWIxNTVhYTRiZjU5MzU0OTFkYjY3ZWZjYjZhMjM4YTVkNDg5YzAxMDExMGU1NGE5ODc0MDE1MjQxZjJmZmY4ZDNhNmM1OWI5MjhhMzFlYWI4ZjA3M2ZlZGFlMjIxZWVjNWY4ZWM5MDRmMyJ9';
const key = 'fpK92jhnf914Kahqkecnml96l4apmgOf';

function decrypt(b64payload, key) {
  const decodedData = Buffer.from(b64payload, "base64").toString("utf8");
  const { iv, encryptedData } = JSON.parse(decodedData);

  return CryptoJS.AES.decrypt(encryptedData, CryptoJS.enc.Utf8.parse(key), {
    iv: CryptoJS.enc.Hex.parse(iv),
    mode: CryptoJS.mode.CBC,
    format: CryptoJS.format.Hex,
  }).toString(CryptoJS.enc.Utf8);
}

console.log(decrypt(payload, key));