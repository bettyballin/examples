var expiryDate = new Date();
expiryDate.setDate(expiryDate.getDate() + 30); // Set expiration date to 30 days from now
var domain = "example.com"; // Replace with your domain

document.cookie = "cookiename=value; expires=" + expiryDate.toUTCString() + "; path=/; domain=" + domain + "; Secure";