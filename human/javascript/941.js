// ==UserScript==
// @name         Merise
// @match        https://app.memrise.com/aprender/*
// @grant        GM_addElement
// ==/UserScript==

(function() {
  var word = document.getElementsByClassName('sc-1nck79x-5 jPETsr')[0].textContent;
  var bdy = document.getElementsByClassName('sc-r1ec2z-1 evBYsl')[0];
  GM_addElement(bdy, 'iframe', {
    src: 'https://learnersdictionary.com/definition/' + encodeURIComponent(word),
    style: 'width: 90%; height: 500px;',
  });
})();