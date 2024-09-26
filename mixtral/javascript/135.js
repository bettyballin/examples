var xhttp = new XMLHttpRequest();
xhttp.open('POST', 'log/generate_code');
xhttp.setRequestHeader("Content-type", "application/json");

// Send request
xhttp.send(JSON.stringify({}));

// Handle response
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var uniqueCode = JSON.parse(this.responseText).unique_code;

        // Use the code in your next AJAX call
        var xhttp2 = new XMLHttpRequest();
        xhttp2.open('POST', 'log/');
        xhttp2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        var params = `uniqueCode=${encodeURIComponent(uniqueCode)}`;

        // Send request
        xhttp2.send(params);
    }
};