php
<?php 
    $userInput = "example input";
    $data = array('a' => htmlspecialchars($userInput));
?>

<script>
var jsonData = <?php echo (json_encode($data) !== false ? json_encode($data) : '{}'); ?>;
console.log(jsonData);
</script>