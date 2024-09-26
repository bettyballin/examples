<?php
$data = array('key' => 'value'); // example data

?>

<script>
var data = <?= htmlspecialchars(json_encode($data, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT | JSON_UNESCAPED_SLASHES | JSON_HEX_TAG | JSON_HEX_AMP | JSON_HEX_APOS | JSON_HEX_QUOT), ENT_QUOTES, 'UTF-8') ?>;
</script>

<?php
// Or
echo "<div id='myDiv'>";
?>