const getMd5 = async (fileObject) => {
   let md5 = "";

   try {
     const fileBlob = await fetch(URL.createObjectURL(fileObject)).then((res) => res.arrayBuffer());

     // Convert the Array Buffer to WordArray
     var wordArray = CryptoJS.lib.WordArray.create(new Uint8Array(fileBlob));

     const hash = CryptoJS.MD5(wordArray);

     md5 = hash.toString();
   } catch (err) {
      console.log("Error occurred getMd5:", err);
    }

  return md5;
};

// Example usage:
const fileInput = document.getElementById('fileInput');
fileInput.addEventListener('change', async (e) => {
  const fileObject = e.target.files[0];
  const md5Hash = await getMd5(fileObject);
  console.log('MD5 Hash:', md5Hash);
});