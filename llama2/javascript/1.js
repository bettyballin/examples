var serviceUrl = "http://myservicedomain";
var payload = "Some content";

// Create a script tag with a unique name
var scriptId = "jsonp_script_" + Math.floor(Math.random() * 1000);
var scriptTag = document.createElement("script");
scriptTag.type = "text/javascript";
scriptTag.id = scriptId;
scriptTag.src = serviceUrl + "?callback=jsonp_callback_" + scriptId;

// Add the script tag to the page
document.body.appendChild(scriptTag);

// Define the callback function
window["jsonp_callback_" + scriptId] = function(data) {
    console.log(data);
    // Do something with the data
}

// Remove the script tag after 1 second
setTimeout(function() {
    document.body.removeChild(scriptTag);
}, 1000);