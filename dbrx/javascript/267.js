// Your code here
const signature = "your_signature_here";
const signatureBuffer = new TextEncoder().encode(atob(signature));

// Added console.log statement to make the code executable
console.log(signatureBuffer);