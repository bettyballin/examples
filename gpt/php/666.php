
if (is_string($_COOKIE['name'])) {
    // Proceed with your logic
    echo htmlspecialchars($_COOKIE['name']);
} else {
    // Handle the unexpected data appropriately
    // Possibly log this attempt and send an error message or take other security measures
}

