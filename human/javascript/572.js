const responseHeaders = new Headers({
  'Content-Security-Policy': "worker-src 'self' https://.../"
});

self.addEventListener('fetch', (event) => {
  event.respondWith(fetch(event.request, { headers: responseHeaders }));
});