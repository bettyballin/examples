function readEncryptedImage(file) {
  const reader = new FileReader();

  return new Promise((resolve, reject) => {
    // Read the file as data URL
    reader.readAsDataURL(file);

    reader.onloadend = () => resolve({
      base64: reader.result
    });

    reader.onerror = () => reject(reader.error);
  });
}

// Example usage:
const fileInput = document.getElementById('fileInput');

fileInput.addEventListener('change', (e) => {
  const file = fileInput.files[0];
  readEncryptedImage(file).then((result) => {
    console.log(result.base64);
  }).catch((error) => {
    console.error(error);
  });
});