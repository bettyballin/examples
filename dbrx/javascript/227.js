const csp = "default-src 'self'; connect-src http://example.com;";
const meta = document.createElement("meta");
meta.httpEquiv = "Content-Security-Policy";
document.head.appendChild(meta);
meta.content = csp;