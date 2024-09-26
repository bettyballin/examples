const getMd5 = async (fileObject) => {
  let md5 = "";
  const reader = new FileReader();
  return new Promise((resolve, reject) => {
    reader.onloadend = () => {
      try {
        if (reader.result instanceof ArrayBuffer) {
          const hash = CryptoJS.MD5(CryptoJS.lib.WordArray.create(reader.result));
          resolve(hash.toString());
        } else {
          throw new Error("FileReader result is not an instance of ArrayBuffer");
        }
      } catch (err) {
        console.log("Error occurred getMd5:", err);
        reject(err);
      }
    };
    reader.readAsArrayBuffer(fileObject);
  });
};