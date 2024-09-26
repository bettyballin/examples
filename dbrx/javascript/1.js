// Example using Fetch API

const messageId = 123; // Replace with actual message ID

fetch('/api/read-message', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ messageId })
})
.then(response => response.json())
.then(data => console.log('Message read successfully'))
.catch(error => console.error('Error:', error));