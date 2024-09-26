self.addEventListener('install', (event) => {
  event.waitUntil(self.skipWaiting());
});

self.addEventListener('activate', (event) => {
  event.waitUntil(clients.claim());
});

self.addEventListener('fetch', (event) => {
  if (!/https?:\/\//.test(event.request.url)) { 
    console.warn(`Blocking non-secure request: ${event.request.url}`);
    event.respondWith(new Response('', { status: 400, statusText: 'Bad Request' }));
  }
});