$(document).ready(function() {
    var reverseLink = "gnitirwReg";

    // Function to reverse a string
    function reverseString(str) {
        return str.split("").reverse().join("");
    }

    $("#my-link").attr('href', 'https://' + reverseString(reverseLink));
});