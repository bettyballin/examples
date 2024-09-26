<?php
  $name = isset($_POST['name']) ? htmlspecialchars(trim($_POST['name'])) : '';
?>
<form method="post">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name" value="<?php echo $name; ?>"><br>
  <input type="submit" value="Submit">
</form>