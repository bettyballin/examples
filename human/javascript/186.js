// Assuming you have jQuery included in your HTML file
// and 'data' is an object with a 'message' property

var data = { message: "Hello, World!" };

$('#messages').append($("<div>", {
    text: data.message
}));