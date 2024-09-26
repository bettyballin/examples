
// Select the input element you want to observe
var input = document.querySelector('#myPasswordInput');

// Create a callback function to execute when mutations are observed
var callback = function(mutationsList, observer) {
    for(var mutation of mutationsList) {
        if (mutation.type == 'attributes' && mutation.attributeName === 'type') {
            var attributeValue = input.getAttribute('type');
            if (attributeValue !== 'password') {
                // Reset the type to 'password'
                input.setAttribute('type', 'password');
                console.warn('Attempt to change input type detected!');
            }
        }
    }
};

//
