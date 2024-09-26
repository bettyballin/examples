SELECT *
FROM data
WHERE EXISTS (
  SELECT data_id
  FROM user_data
  WHERE user_data.data_id = data.id
    AND role = CURRENT_USER
);