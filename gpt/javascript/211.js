
function A() {
    var token = generateToken(); // Secure token generation
    return function B() {
        // B can access token, E cannot
        console.log('Token is secure within closure');
    };
}

var secureFunction = A();
secureFunction(); // Calls B with access to token

