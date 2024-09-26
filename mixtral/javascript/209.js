var imported = document.createElement('script');
imported.src = '/path/to/imported/script';
imported.setAttribute("nonce", "your-generated-hash");
document.head.appendChild(imported);