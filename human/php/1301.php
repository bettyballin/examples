<?php
$db_host = 'your_host';
$db_username = 'your_username';
$db_password = 'your_password';
$db_name = 'your_database';

$conn = new mysqli($db_host, $db_username, $db_password, $db_name);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$cus_id = 123; // replace with your desired id

$query = "
DELETE 
  c,
  d,
  s,
  i,
  m,
  sa,
  se 
FROM
  tbl_customer c 
  LEFT JOIN tbl_additional_details d 
    ON (c.cus_id = d.customer_id) 
  LEFT JOIN tbl_amc_supervisor s 
    ON (c.cus_id = s.customer_id) 
  LEFT JOIN tbl_current_issues i 
    ON (c.cus_id = i.cr_customer_id) 
  LEFT JOIN tbl_pickmachine m 
    ON (c.cus_id = m.customer_id) 
  LEFT JOIN tbl_sales sa 
    ON (c.cus_id = sa.customer_id) 
  LEFT JOIN tbl_service se 
    ON (c.cus_id = se.customer_id) 
WHERE c.cus_id = ?
";

$stmt = $conn->prepare($query);
$stmt->bind_param("i", $cus_id);
$stmt->execute();

$stmt->close();
$conn->close();
?>