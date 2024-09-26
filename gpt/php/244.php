
    $id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);
    if ($id === false) {
        // Handle the error: input is not a valid integer
    }
    
