
function pdo_agregar($tabla, $datos) {
    global $pdo;

    // Start building the prepared statement
    $columnas = implode(', ', array_keys($datos));
    $placeholders = implode(', ', array_fill(0, count($datos), '?')); // Use '?' placeholders for values

    $sentencia = $pdo->prepare("INSERT INTO $tabla ($columnas) VALUES ($placeholders)");

    // Bind the values to the placeholders
    $i = 1; // Placeholder positions start at 1
    foreach ($datos as $valor) {
        $sentencia->bindValue($i, $valor); // Bind each value to its respective placeholder
        $i++;
    }

    // Execute the statement and return true or false based on success
    if ($sentencia->execute()) {
        return true;
    } else {
        return false;
    }
