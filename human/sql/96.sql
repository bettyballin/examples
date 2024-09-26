CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  failed_login_attempts INTEGER DEFAULT 0,
  last_login_attempt TIMESTAMP
);

CREATE OR REPLACE FUNCTION authenticate_user(
  p_username VARCHAR(50),
  p_password VARCHAR(255)
)
RETURNS BOOLEAN AS $$
DECLARE
  v_user users;
  v_wait_time INTEGER;
BEGIN
  SELECT * INTO v_user
  FROM users
  WHERE username = p_username;

  IF v_user IS NULL THEN
    RETURN FALSE;
  END IF;

  IF v_user.password = p_password THEN
    UPDATE users
    SET failed_login_attempts = 0,
        last_login_attempt = NOW()
    WHERE id = v_user.id;
    RETURN TRUE;
  ELSE
    UPDATE users
    SET failed_login_attempts = failed_login_attempts + 1,
        last_login_attempt = NOW()
    WHERE id = v_user.id;

    v_wait_time = v_user.failed_login_attempts * 2;

    PERFORM pg_sleep(v_wait_time);

    RETURN FALSE;
  END IF;
END;
$$ LANGUAGE plpgsql;

-- Example usage:
SELECT authenticate_user('test_user', 'wrong_password');
SELECT authenticate_user('test_user', 'wrong_password');
SELECT authenticate_user('test_user', 'wrong_password');