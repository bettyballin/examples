function downloadImage(filename, dataUrl) {
  let element = document.createElement('a');
  element.setAttribute('href', dataUrl);
  element.setAttribute('download', filename);
  element.style.display = 'none';
  document.body.appendChild(element);
  element.click();
  document.body.removeChild(element);
}

// Assuming you have fileReader and CryptoJS defined
let fileReader = new FileReader();
let password = 'your_password'; // Replace with your password

fileReader.onload = function (fileLoadedEvent) {
  let base64value = fileLoadedEvent.target.result;
  let encrypt = CryptoJS.AES.encrypt(base64value, password).toString();

  // Convert the encrypted data back to a Blob and then create an object URL.
  const blob = new Blob([CryptoJS.enc.Base64.parse(encrypt)], { type: 'image/jpeg' }); 
  const urlCreator = window.URL || window.webkitURL;
  const imageUrl = urlCreator.createObjectURL(blob);

  downloadImage('encrypted_image.jpg', imageUrl); 
};

// Example usage
let fileInput = document.createElement('input');
fileInput.type = 'file';
fileInput.onchange = function(event) {
  fileReader.readAsDataURL(event.target.files[0]);
};
document.body.appendChild(fileInput);