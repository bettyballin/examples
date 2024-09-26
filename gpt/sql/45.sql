
CREATE POLICY data_owner
ON data
FOR ALL
TO user
USING (EXISTS (
  SELECT 1
  FROM user_data
  WHERE user_data.data_id = data.id
  AND user_data.user_role = CURRENT_USER
));

