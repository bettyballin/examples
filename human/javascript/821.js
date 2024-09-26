Here is the executable JavaScript code:

var window = self;
var document = {};
self.importScripts("/Crypto.min.js");

onmessage = async function (args) {
  var obj = args.data;
  var reader = new FileReader();
  var hash = {};
  var chunkSize = 10485760;
  var largeFileTrigger = 1048576000;
  const chunksQuantity = Math.ceil(obj.File.size / chunkSize);
  const chunksQueue = new Array(chunksQuantity).fill().map((_, index) => index).reverse();
  var isLargeFile = obj.File.size > largeFileTrigger;
  var buffer = null;
  var progressiveArray = [];
  reader.onload = async function (evt) {
    if (isLargeFile) {
      progressiveArray.push(evt.currentTarget.result);
    } else {
      if (buffer == null) {
        buffer = evt.currentTarget.result;
      } else {
        var tmp = new Uint8Array(buffer.byteLength + evt.currentTarget.result.byteLength);
        tmp.set(new Uint8Array(buffer), 0);
        tmp.set(new Uint8Array(evt.currentTarget.result), buffer.byteLength);
        buffer = tmp;
      }
    }
    readNext();
  }

  var readNext = async function () {
    if (chunksQueue.length > 0) {
      const chunkId = chunksQueue.pop();
      const sentSize = chunkId * chunkSize;
      const chunk = obj.File.slice(sentSize, sentSize + chunkSize);
      reader.readAsArrayBuffer(chunk);
    } else {
      var hexHash = null;
      if (isLargeFile) {
        var sha = CryptoJS.algo.SHA512.create();
        for (var i = 0; i < progressiveArray.length; i++) {
          sha.update(arrayBufferToWordArray(progressiveArray[i]));
        }
        hexHash = sha.finalize().toString();
      } else {
        hexHash = await digestMessage(buffer);
      }

      SHA512 = hexHash.toUpperCase();
      buffer = null;
      progressiveArray = null;
      postMessage({ Hash: SHA512 });
    }
  }

  readNext();
}

async function digestMessage(file) {
  const hashBuffer = await crypto.subtle.digest('SHA-512', file);
  const hashArray = Array.from(new Uint8Array(hashBuffer));
  const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
  return hashHex;
}

function arrayBufferToWordArray(ab) {
  var i8a = new Uint8Array(ab);
  var a = [];
  for (var i = 0; i < i8a.length; i += 4) {
    a.push(i8a[i] << 24 | i8a[i + 1] << 16 | i8a[i + 2] << 8 | i8a[i + 3]);
  }
  return CryptoJS.lib.WordArray.create(a, i8a.length);
}