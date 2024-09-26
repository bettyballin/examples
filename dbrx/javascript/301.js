const returnUrl = sessionStorage.getItem('returnUrl') || '/';
window.location.href = encodeURI(returnUrl);