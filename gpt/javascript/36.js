
var xhr = Titanium.Network.createHTTPClient({
    onload: function(e) {
        // Handle the response, save the file etc.
        var f = Ti.Filesystem.getFile(Ti.Filesystem.applicationDataDirectory, 'downloadedFile.xml');
        f.write(this.responseData);
        alert('Download Complete!');
    },
    onerror: function(e) {
        // Handle error
        alert('Error: ' + e.error);
    },
    timeout: 5000 // in milliseconds
});

// Use the HTTPS protocol
xhr.open('GET', 'https://yourserver.com/yourfile.xml');
xhr.send();

