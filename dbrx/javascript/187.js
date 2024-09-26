const fetchData = (url, options) => {
    return fetch(url, options)
        .then(response => {
            if (!response.ok && response.status === 401) {
                // Redirect to login page or handle logout here
                window.location.href = '/login'; // example redirect
            }
            return response.json();
        });
};

const dataProvider = {
    getList: (resource, params) => fetchData('https://api.example.com/' + resource, {
        method: 'GET',
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': 'Bearer YOUR_API_TOKEN' // example auth header
        }),
        params: params
    })
};

// example usage:
dataProvider.getList('users', { page: 1, limit: 10 })
    .then(data => console.log(data))
    .catch(error => console.error(error));