// cookie processing lookup table
function validateCookieName1(cookieValue) {
    // validation logic for cookieName1
    return true; // or false based on validation
}

function validateCookieName2(cookieValue) {
    // validation logic for cookieName2
    return true; // or false based on validation
}

const validateCookie = {
    cookieName1: validateCookieName1,
    cookieName2: validateCookieName2
};

// Test the code
console.log(validateCookie.cookieName1("some value")); // should print: true
console.log(validateCookie.cookieName2("some value")); // should print: true