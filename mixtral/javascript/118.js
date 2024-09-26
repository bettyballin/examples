async function fetchData(username, password) {
  try {
    const response = await fetch('https://yourserver/api', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({username: username, password: password})
    });

    if (!response.ok) throw new Error(await response.text());
  } catch (error) {
    console.error(error);
  }
}

fetchData('your_username', 'your_password');