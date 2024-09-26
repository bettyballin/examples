var script = document.createElement('script');
var scriptContent = 'console.log("Hello, World!");';
script.src = "data:text/javascript;charset=utf-8," + encodeURIComponent(scriptContent);
document.head.appendChild(script);