fetch('https://example.com/profile', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({ /* your data here */ }),

  credentials: 'include', 
})
.then(response => response.json())
.then(data => {
  console.log('Success:', data);
})
.catch(error => console.error('Error:', error));