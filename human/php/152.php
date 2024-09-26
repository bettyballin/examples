<?php
$subject = filter_input(INPUT_POST, "subject", FILTER_UNSAFE_RAW,
    FILTER_FLAG_STRIP_LOW);
if ($subject === false) { 
    echo "Error: Subject not given or not scalar.";
} else {
    echo "Subject: $subject";
}
?>
<form method="post">
    <input type="text" name="subject">
    <input type="submit">
</form>