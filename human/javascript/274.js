window.addEventListener('message', event => {
    // IMPORTANT: check the origin of the data!
    if (event.origin === 'https://your-first-site.example') {
        // The data was sent from your site.
        // Data sent with postMessage is stored in event.data:
        console.log(event.data);
    } else {
        // The data was NOT sent from your site!
        // Be careful! Do not use it. This else branch is
        // here just for clarity, you usually shouldn't need it.
        return;
    }
});

// For testing purposes, you can use the following code to send a message to the current window
window.postMessage("Hello, world!", "https://your-first-site.example");