// Create a simple service worker script (sw.js)
// self is a reference to the service worker itself
self.addEventListener('install', function(event) {
    event.waitUntil(self.skipWaiting());
});

self.addEventListener('activate', function(event) {
    event.waitUntil(self.clients.claim());
});

// Your original code
navigator.serviceWorker.register('/sw.js').then(function(registration) {
    console.log('ServiceWorker registration successful with scope: ', registration.scope);
    // ... some other code
}).catch(function(error) {
    console.error('ServiceWorker registration failed:', error);
});