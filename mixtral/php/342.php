<?php
function pdo_agregar($tabla, $datos) {
    global $pdo;

    // Prepare placeholders for columns and values
    $placeholders = implode(',', array_fill(0, count($datos), '?'));

    try {
        // Create a prepared statement with placeholders
        $sentencia = $pdo->prepare("INSERT INTO {$tabla} (".implode(', ', array_keys($datos)).") VALUES ({$placeholders})");

        $indice = 1;
        foreach ($datos as &$valor) {
            if (!is_int($valor))
                // Bind parameters individually
                $sentencia->bindParam($indice, $valor, PDO::PARAM_STR);
            else
                $sentencia->bindValue($indice, (int)$valor, PDO::PARAM_INT);
            $indice++;
        }

        // Execute the prepared statement
        if ($sentencia->execute()) {
            return true;
        } else {
            throw new Exception("Error executing query.");
        }
    } catch (Exception $e) {
        error_log($e->getMessage());

        return false;
    }

    // Close the statement and connection
    unset($sentencia);
}
?>