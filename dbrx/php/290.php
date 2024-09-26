<?php
$input_date = '2022-02-28'; // example input date
list($year, $month, $day) = explode('-', $input_date);
if (!checkdate((int)$month, (int)$day, (int)$year)) {
    echo "Invalid date format";
} else {
    echo "Valid date format";
}
?>