<?php
$m_message_date = '2023-03-01';
$m_message_time = '12:00:00';
$m_message_last_value = 'Hello, World!';

$m_arr_sql_query_parameters = 
    array(':message_date' => $m_message_date,
            ':message_time' => $m_message_time,
            ':message_last_value' => $m_message_last_value);

print_r($m_arr_sql_query_parameters);
?>