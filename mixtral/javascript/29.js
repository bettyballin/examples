let encodedEmail = encodeURIComponent("abc@gmail.com");
console.log(encodedEmail); // "abc%40gmail.com"

// To display the value correctly use decodeURIComponent()

let decodedEmail = decodeURIComponent(encodedEmail);
console.log(decodedEmail);  // abc@gmail.com