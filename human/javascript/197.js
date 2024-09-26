// Create a new HTML document
var html = document.createElement('html');

// Create a new document cookie
document.cookie = "test=hello";

// Define the alert function
function alert(message) {
  console.log(message);
}

// Your code here
alert("Your query string was hello");
alert(document.cookie+"");