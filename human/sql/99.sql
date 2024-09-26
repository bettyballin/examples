DECLARE 
  $m_arr_sql_query_parameters = 
    array(':message_date' => $m_message_data,
          ':message_time' => $m_message_data,
          ':message_last_value' => $m_message_data);

  $sql = "INSERT INTO table_name (message_date, message_time, message_last_value)
          VALUES (:message_date, :message_time, :message_last_value)";

  $stmt = $pdo->prepare($sql);
  $stmt->execute($m_arr_sql_query_parameters);