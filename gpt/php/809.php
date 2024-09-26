
<?php
$php_data = ['key1' => 'value1', 'key2' => 'value2'];
?>
<script>
    var js_data = <?php echo json_encode($php_data, JSON_HEX_TAG | JSON_HEX_AMP | JSON_HEX_APOS | JSON_HEX_QUOT); ?>;
    console.log(js_data);
</script>

