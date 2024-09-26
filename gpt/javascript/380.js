
import CryptoJS from "crypto-js";

const getMd5 = (fileObject) => {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    
    reader.onload = function(event) {
      const arrayBuffer = event.target.result;
      const wordArray = CryptoJS.lib.WordArray.create(arrayBuffer);
      const hash = CryptoJS.MD5(wordArray);
      const md5 = hash.toString(CryptoJS.enc.Hex);
      resolve(md5);
    };
    
    reader.onerror = function(err) {
      reject(err);
    };

    reader.readAsArrayBuffer(fileObject
