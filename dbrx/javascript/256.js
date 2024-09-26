// ==UserScript==
// @name         Merise
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       k1
// @match        https://app.memrise.com/aprender/*
// @icon         data:image/png;base64VBORw0KGg...
// @grant        none
// ==/UserScript==

(function () {
  var script = document.createElement('script');
  script.src = 'https://yourwebsite.com/memrise.js';
  script.type = 'text/javascript';
  document.body.appendChild(script);
})();