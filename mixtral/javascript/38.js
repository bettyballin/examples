$.ajax({
    url: 'https://jsonplaceholder.typicode.com/todos/1',
    type: 'GET',
    dataType: 'json',
    xhrFields: {
        withCredentials: true
    },
    success: function(data) {
        console.log('success');
        console.log(data);
    }
});