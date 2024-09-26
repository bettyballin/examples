(function () {
  'use strict';
  var word = document.getElementsByClassName('sc-1nck79x-5 jPETsr')[0];
  var bdy = document.getElementsByClassName('sc-r1ec2z-1 evBYsl')[0];
  var defl =
    'https://learnersdictionary.com/definition/' + encodeURIComponent(word.innerHTML);
  var fr = document.createElement('iframe');
  fr.height = '500px';
  fr.src = defl;
  fr.style.maxWidth = '90%';
  bdy.appendChild(fr);
})();