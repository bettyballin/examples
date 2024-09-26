<html>
  <body>
    <textarea></textarea>
    <input type="checkbox">
    <input type="button" value="[1, 2, 3]">
    <input type="button" value="({})['foo'] = 'bar'">
    <script>
      var capture = function() {
        var ta = document.querySelector('textarea')
        ta.innerHTML = '';
        ta.appendChild(document.createTextNode("Captured: "+JSON.stringify(arguments)));
        return arguments;
      }
      var original = Array;

      var toggle = document.body.querySelector('input[type="checkbox"]');
      var toggleCapture = function() {
        var isOn = toggle.checked;
        window.Array = isOn ? capture : original;
        if (isOn) {
          Object.defineProperty(Object.prototype, 'foo', {set: capture});    
        } else {
          delete Object.prototype.foo;
        }
      };
      toggle.addEventListener('click', toggleCapture);
      toggleCapture();

      [].forEach.call(document.body.querySelectorAll('input[type="button"]'), function(el) {
        el.addEventListener('click', function() {
          document.querySelector('textarea').innerHTML = 'Safe.';
          eval(this.value);
        });
      });
    </script>
  </body>
</html>