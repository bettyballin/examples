<?php
$user_entered_variable = 10; // example value
?>

<script>
  var inputNumber = <?php echo intval($user_entered_variable); ?>;
  console.log(inputNumber);
</script>