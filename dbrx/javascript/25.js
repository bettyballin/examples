$.ajax({
    url: 'your_url',
    type: 'GET', // or POST
    xhrFields: {
        withCredentials: true
    },
    success: function(data) {
        console.log('success');
    }
});