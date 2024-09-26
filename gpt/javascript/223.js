
(function() {
    var originalInnerHTML = Object.getOwnPropertyDescriptor(Element.prototype, 'innerHTML');

    Object.defineProperty(Element.prototype, 'innerHTML', {
        set: function(value) {
            var newValue = my_function(value);
            originalInnerHTML.set.call(this, newValue); // Call the original setter function
        },
        get: function() {
            return originalInnerHTML.get.call(this); // Call the original getter function
        }
    });
})();

function my_function(value) {
    // Modify the value here as needed
    return value.replace(/something/, 'something else');
}

