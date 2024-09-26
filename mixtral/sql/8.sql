CREATE POLICY data_owner
ON data
FOR ALL
TO "user"
USING (
  EXISTS(
    SELECT TRUE
    FROM LATERAL (
      SELECT *
      FROM user_data
      WHERE role = CURRENT_ROLE AND id = data.id
     ) AS subquery
   )
)
WITH CHECK (TRUE);