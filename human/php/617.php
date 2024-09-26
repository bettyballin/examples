<?php
  if(isset($_POST['submit'])) {
    $field1 = $_POST['field1'];
    $field2 = $_POST['field2'];
    // ... add more fields as needed
    echo "Field 1: $field1<br/>";
    echo "Field 2: $field2<br/>";
    // ... add more fields as needed
  }
?>

<form name="form1" id="form1" method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>">
  <input type="text" name="field1" value="" />
  <input type="text" name="field2" value="" />
  <!-- ... add more fields as needed -->
  <input type="submit" name="submit" value="Submit" />
</form>