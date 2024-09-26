// Define a sample response object with a redirectTo property
const resp = {
  redirectTo: '/path/to/redirect'
};

if (resp && resp.redirectTo) {
  const redirectUrl = new URL(resp.redirectTo, window.location.origin);
  if (redirectUrl.protocol === 'http:' || redirectUrl.protocol === 'https:') {
    // Use a console.log statement instead of updating window.location.href
    console.log(`Redirecting to: ${redirectUrl.toString()}`);
  } else {
    console.log('Invalid redirect URL');
  }
}