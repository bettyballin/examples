
    // Server-side
    $api_key = 'secret_key';
    $received_hash = $_GET['hash'];
    $timestamp = $_GET['timestamp'];
    $nonce = $_GET['nonce'];

    // Ensure the timestamp is within an acceptable time range (e.g., ±5 minutes)
    if (
