
pm.sendRequest({
    url: 'http://localhost:8084/oauth/token',
    method: 'POST',
    headers: {
        'Authorization': 'Basic Y2xpZW50OnBhc3N3b3Jk',
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: {
        mode: 'urlencoded',
        urlencoded: [
            { key: 'username', value: 'admin' },
            { key: 'password', value: 'secret' },
            { key: 'grant_type', value: 'password' }
        ]
    }
}, (err, res) => {
    if (err) {
        console.error('Request
