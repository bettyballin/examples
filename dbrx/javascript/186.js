const dataProvider = {
    getList: (resource, params) => {
        return fetch('https://example.com/api/' + resource, { 
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (!response.ok && response.status === 401) {
                window.location.href = '/login';
            }
            return response.json();
        });
    }
};

// Test the dataProvider
dataProvider.getList('users', {})
    .then(data => console.log(data))
    .catch(error => console.error(error));