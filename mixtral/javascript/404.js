import { fetch } from 'react-native-ssl-pinning';

async function fetchData() {
  try {
    const response = await fetch('https://example.com', {
      method: "GET"
    });

    // Handle the response
    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

fetchData();