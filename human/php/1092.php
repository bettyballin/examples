<?php
  $current = json_encode(get_current_page_url(), JSON_HEX_TAG);
?>

<script>
  var current = <?php echo $current; ?>;
  var pageUrl = current + '?' + form_data;
</script>