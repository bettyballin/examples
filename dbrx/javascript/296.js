import * as Network from 'expo-network';

const isValidCertificate = async (url) => {
  try {
    const certificateInfo = await Network.getCertificateInfoAsync(url);
    // Perform validation logic here based on the `certificateInfo` object.
    console.log(certificateInfo);
    return true; // Replace with actual validation logic
  } catch (error) {
    console.error(error);
    return false;
  }
};

// Example usage:
isValidCertificate('https://example.com')
  .then((isValid) => console.log(`Certificate is valid: ${isValid}`))
  .catch((error) => console.error('Error checking certificate:', error));