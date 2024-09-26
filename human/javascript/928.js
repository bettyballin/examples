document.addEventListener('DOMContentLoaded', (function () {

    let dataVariable;
    window.addEventListener('message', event => {
        const message = event.data; // The JSON data our extension sent
        switch (message.command) {
            case 'dajaJsonCommand':
                dataVariable = message.data;
                break;
        }
    });

})());