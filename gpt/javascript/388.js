
window.addEventListener('message', event => {
    const message = event.data; // The JSON data sent from the extension

    switch (message.command) {
        case 'loadData':
            const jsonData = message.data;
            // Now jsonData contains your JSON data and you can use it as needed
            break;
    }
});

