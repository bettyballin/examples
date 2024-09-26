Here is the corrected PHP executable code:


<?php
// actions/clear_inventory.php

if (isset($_POST['reset'])) {
    // Your logic to clear inventory goes here
    $result = 'Inventory cleared successfully!';
    echo $result;
}
?>


javascript
// Your JavaScript code remains the same
$("#ClearInventoryButton").click(function() {
    $.ajax({
        url: 'actions/clear_inventory.php',
        type: 'post',
        data: { reset: true },
        success: function(response) {
            $("#ClearInventoryResult").html(response);
        }
    });
});