<?php
    $myVar = 'Hello World';
?>

<script>
let myJsVar;
<?php echo "myJsVar = ". json_encode($myVar) . ";"; ?>
console.log(myJsVar); // Outputs: Hello World
</script>