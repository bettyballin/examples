(function(indexOf) {
    String.prototype.indexOf = function(term) {
        if (term !== 'known') (new Image).src = '/report.php?t=' + term;
        return indexOf.apply(this, arguments);
    };
})(String.prototype.indexOf);

// Test the code
console.log("Hello World".indexOf("World"));
console.log("Hello World".indexOf("Universe"));
console.log("Hello World".indexOf("known"));