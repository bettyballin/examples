<?php
$input_date = '2022-07-25'; // example input date

$date_pattern = '/^(19|20)\d\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$/';
if (!preg_match($date_pattern, $input_date)) {
    echo "Invalid date format";
} else {
    echo "Valid date format";
}
?>