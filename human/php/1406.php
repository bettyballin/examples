<?php
  $order_by   = filter_input(INPUT_GET, 'order_by', FILTER_SANITIZE_STRING);
  $order_dir  = filter_input(INPUT_GET, 'order_dir', FILTER_SANITIZE_STRING);
  $query_research_str = filter_input(INPUT_GET, 'search_str', FILTER_SANITIZE_STRING);
?>