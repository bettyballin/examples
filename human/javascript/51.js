<html>
  <body>
    <textarea></textarea>
    <input id="card1" type="text" placeholder="CARD1">
    <input id="card2" type="text" placeholder="CARD2">
    <button>Calculate</button>
    <p id="result"></p>

    <script>
      var textarea = document.getElementsByTagName('textarea')[0],
          placeholders = ['CARD1', 'CARD2'];

      document.getElementsByTagName('button')[0].onclick = function() {

          var value = textarea.value;

          // Strip placeholders
          var placeholderStripped = value.replace(new RegExp(placeholders.join('|'), 'g'), '');

          var safe = placeholderStripped.match(/^[\d\+\-\/\*\(\)]+$/);

          if (safe == null) {

              alert('Not a valid equation');
              return;

          }

          for (var i = 0, placeholdersLength = placeholders.length; i < placeholdersLength; i++) {
              value = value.replace(new RegExp(placeholders[i], 'g'), document.getElementById(placeholders[i].toLowerCase()).value);
          }

          document.getElementById('result').innerHTML = eval(value);

      }
    </script>
  </body>
</html>