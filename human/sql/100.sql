<?php
// assuming you have a database connection established

$m_message_date = '2022-01-01';
$m_message_time = '12:00:00';
$m_message_last_value = 'Hello World!';

$m_arr_sql_query_parameters = 
    array(':message_date' => $m_message_date,
            ':message_time' => $m_message_time,
            ':message_last_value' => $m_message_last_value);

$sql = "INSERT INTO your_table (message_date, message_time, message_last_value) 
        VALUES (:message_date, :message_time, :message_last_value)";

$stmt = $pdo->prepare($sql);
$stmt->execute($m_arr_sql_query_parameters);