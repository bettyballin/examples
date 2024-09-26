function downloadEncryptedImage(filename, encryptedBase64) {
  const element = document.createElement('a');

  // Set the file name and extension
  filename += '.png';

  // Create a data URL with base64 encoded image
  let mimeType = 'image/png';

  if (encryptedBase64) {
    element.setAttribute(
      'href',
      `data:${mimeType};base64,` + encryptedBase64
    );

    // Set the download attribute to trigger a file save
    element.download = filename;

    document.body.appendChild(element);

    // Trigger click event
    element.click();

    // Remove anchor tag from body
    setTimeout(() => {
      document.body.removeChild(element);
    }, 100);

  } else {
    console.error('Encrypted base64 is empty');
  }
}

// Test the function
downloadEncryptedImage('test', 'your_base64_encoded_string_here');