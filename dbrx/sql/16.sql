CREATE OR REPLACE FUNCTION before_user_insert()
RETURNS TRIGGER AS $$
BEGIN
  SET LOCAL jwt.claims.role TO 'admin';
  RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION after_user_insert()
RETURNS TRIGGER AS $$
DECLARE
  user_id uuid := (SELECT id FROM "user" WHERE email = NEW.email);
BEGIN
  IF user_id IS NULL THEN
    RAISE EXCEPTION 'User not found: %', NEW.email;
  END IF;

  SET LOCAL jwt.claims.userId TO user_id;
  RETURN NULL; -- No need to return anything since it's an AFTER trigger.
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER before_insert
BEFORE INSERT ON "user"
FOR EACH ROW
EXECUTE PROCEDURE before_user_insert();

CREATE TRIGGER after_insert
AFTER INSERT ON "user"
FOR EACH ROW
EXECUTE PROCEDURE after_user_insert();