// Set your credentials here
const YOUR_CLIENT_ID = 'your_client_id';
const YOUR_CLIENT_SECRET = 'your_client_secret';
const YOUR_USERNAME = 'your_username';
const YOUR_PASSWORD = 'your_password';

pm.sendRequest({
    url: 'http://localhost:8084/oauth/token',
    method: 'POST',
    header: {
        'Authorization': 'Bearer',
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    data: `grant_type=password&client_id=${YOUR_CLIENT_ID}&client_secret=${YOUR_CLIENT_SECRET}&username=${YOUR_USERNAME}&password=${YOUR_PASSWORD}`,
    response: function(response) {
        console.log(response);
        // Handle the response here
    }
});