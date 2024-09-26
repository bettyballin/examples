fetch('/api/endpoint', {
    method: 'POST',
    headers: new Headers({
        // Include the CSRF token from server-side as a custom header
        "X-CSRF-TOKEN": csrfToken
    })
})
.then(response => response.json())
.catch(error => console.error(error));