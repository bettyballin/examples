<?php
$myVar = 'Hello, World!';
?>

<div onclick="myFun('something', '<?php echo $myVar; ?>')">Click me!</div>

<script>
  function myFun(param1, param2) {
    alert(param1 + ' ' + param2);
  }
</script>