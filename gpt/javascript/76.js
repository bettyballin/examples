
// Assume `userInput` is the raw HTML you got from the user.
var userInput = '<script>alert("malicious code");</script> I am safe HTML!';

// Use Caja to sanitize the user input.
// Note: the
