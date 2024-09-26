$(document).ready(function() {
  $('#invalid2').on('click', function(e){
      alert('click\nevent.target: ' + e.target.id);
      console.log(e);
  });

  $('#invalid1').on('click', function(){
      $('#invalid2').trigger({
          type: 'click',
          target: {id: 'Fake'}
      });
  });
});


html
<!DOCTYPE html>
<html>
<head>
  <title>Trigger Event</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <button id="invalid1">Trigger Event</button>
  <button id="invalid2">Click Me</button>
  <script>/* above js code */</script>
</body>
</html>