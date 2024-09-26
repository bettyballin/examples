const url = 'https://jenkins_server.com/api';

// Fetch with Credentials
fetch(url, {
  method: "GET",
  mode: "cors",
  cache: "no-cache",
  credentials: "include"
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error(error));