CREATE TABLE my_table (
    id SERIAL PRIMARY KEY,
    protected_col INTEGER
);

CREATE ROLE user_with_limited_access;

CREATE POLICY protect_protected_col ON my_table TO PUBLIC USING (
    current_user = 'user_with_limited_access' AND protected_col IS NULL OR NOT (protected_col IS DISTINCT FROM 0)
);