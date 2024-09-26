<?php
$token = bin2hex(random_bytes(32));
?>

<form method="POST" action="/submit">
  <input type="hidden" name="_csrf_token" value="<?php echo htmlspecialchars($token); ?>">
  <!-- other form fields -->
  <input type="text" name="example" placeholder="Example field">
  <input type="submit" value="Submit">
</form>