// In http://example.com/page.html:
fetch('http://another.origin.example.com/data.json', {
  method: 'GET',
  mode: 'cors'
}).then(function(response) {
  return response.text();
}).then(function(data) {
  console.log('received data:', data);
});