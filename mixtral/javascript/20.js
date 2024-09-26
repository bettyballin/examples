<!DOCTYPE html>
<html>
<head>
  <title>Counter</title>
</head>
<body>
  <button id="button">Click me!</button>
  <p id="counter">0</p>
  <script>
    'use strict';
    let a = 0;
    document.getElementById('button').addEventListener("click", function() {
      document.getElementById('counter').innerHTML = ++a;
    });

    // or use arrow functions

    const buttonClickHandler = () => {
      const counterElement = document.getElementById('counter');

      if (counterElement) {
        a++;
        counterElement.textContent = a;
      }
    };

    document.getElementById("button").addEventListener("click", buttonClickHandler);
  </script>
</body>
</html>