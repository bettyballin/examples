CREATE TABLE data (
    id SERIAL PRIMARY KEY,
    acl text[],
    -- Add other columns as needed
);

CREATE POLICY data_owner ON data FOR ALL TO PUBLIC
   USING (acl @> ARRAY[current_user::name])
   WITH CHECK (TRUE);

ALTER TABLE data ENABLE ROW LEVEL SECURITY;
ALTER TABLE data FORCE ROW LEVEL SECURITY;