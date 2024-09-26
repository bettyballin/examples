const urlParams = new URLSearchParams(window.location.search);

// Get individual parameters
let affiliateParam = encodeURIComponent(urlParams.get('affiliate'));

console.log(`Affiliate ID is ${affiliateParam}`);

// Or to get the entire query string
const encodedQueryString = encodeURIComponent(window.location.search);

console.log(`Encoded query string is ${encodedQueryString}`);