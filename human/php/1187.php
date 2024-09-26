<?php
$myVar = 'some value';
?>

...your html content...
<script type="text/javascript">
    var myvar = <?= json_encode($myVar) ?>;
</script>
...