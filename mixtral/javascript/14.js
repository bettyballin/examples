const fetch = require('node-fetch');

async function getGoogleKeys() {
  const response = await fetch("https://www.googleapis.com/oauth2/v3/certs");

  if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);

  return await response.json();
}

// Execute the function
getGoogleKeys().then((data) => console.log(data)).catch((error) => console.error(error));