const handleRequest = async (requestFunction) => {
    try {
        const result = await requestFunction();

        return Promise.resolve(result);

    } catch (error) {

        if (error?.response?.status === 401 || error instanceof TypeError && !navigator.onLine){
            // Redirect to login or show a message

            window.location = '/login';

            return Promise.reject('Unauthorized');

        }

        throw new Error(error);
    }
};

const fetchGetList = async (resource, params) => {
    const response = await fetch(`https://api.example.com/${resource}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        params: JSON.stringify(params)
    });
    return response.json();
};

const dataProvider = {
    getList: (resource, params) => handleRequest(() => fetchGetList(resource, params))
    // ... other methods
};

// Test the code
dataProvider.getList('users', { id: 1, name: 'John Doe' })
    .then(data => console.log(data))
    .catch(error => console.error(error));