
-- Example PostgreSQL commands to set up a read-only user
CREATE ROLE sandbox_user WITH LOGIN PASSWORD 'secure_password';
GRANT CONNECT ON DATABASE your_database TO sandbox_user;
GRANT USAGE ON SCHEMA public TO sandbox_user;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO sandbox_user;

