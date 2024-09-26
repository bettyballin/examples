const allowedDomains = ['yourdomain.com', 'anotheralloweddomain.net'];

if (!allowedDomains.includes(window.location.hostname)) {
  // Clearing all content from body element when not on the correct domain.
  document.body.innerHTML = '';
}