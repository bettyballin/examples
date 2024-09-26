var apiKey = 'YOUR_API_KEY';
var url = 'YOUR_URL';
var nonce = 'YOUR_NONCE';

var httpOptions = {
  'method': 'post',
  'headers': {
    'API-Key': apiKey
  },
  'payload': UrlFetchApp.getRequest(url, {
    "ContentType": "application/x-www-form-urlencoded",
    'method': 'POST'
  }).set('nonce', nonce).toString()
};