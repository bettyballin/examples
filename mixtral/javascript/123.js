<!DOCTYPE html>
<html>
<head>
  <title>Color Saver</title>
  <style>
    #colourBox {
      width: 50px;
      height: 50px;
      border: 1px solid black;
    }
  </style>
</head>
<body>
  <input type="text" id="saveBox" placeholder="#FFFFFF">
  <button id="saveButton">Save</button>
  <div id="colourBox"></div>

  <script>
    var saveButton = document.getElementById('saveButton');
    var saveBox = document.getElementById('saveBox');
    var colourBox = document.getElementById('colourBox');

    saveButton.onclick = function() {
      var colorValue = saveBox.value;

      // Validate input
      if (/^#[0-9A-F]{6}$/i.test(colorValue)) {
        colourBox.style.backgroundColor = colorValue;
      } else {
        alert("Invalid color value");
      }
    }
  </script>
</body>
</html>