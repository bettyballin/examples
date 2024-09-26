<?php
$epoch_time = 1643723400; // example epoch time
try {
    if (time() - $epoch_time > 5 * 60) {
        throw new Exception("Message expired");
    }
    echo "Message not expired";
} catch (Exception $e) {
    echo $e->getMessage();
}
?>