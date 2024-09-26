const returnUrl = sessionStorage.getItem('returnUrl') ?
    decodeURIComponent(sessionStorage.getItem('returnUrl')) : '/';
window.location.href = returnUrl;