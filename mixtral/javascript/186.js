const expiryDate = new Date(Date.now() + 86400000); // expires in 1 day
const domain = "example.com";

document.cookie = "cookiename=value; expires=" + expiryDate.toUTCString() + "; path=/; domain=" + domain + "; Secure";