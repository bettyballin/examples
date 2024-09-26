CREATE OR REPLACE FUNCTION before_user_insert() RETURNS TRIGGER AS
$$BEGIN
   PERFORM set_config('jwt.claims.userId', NEW.id::text, TRUE);
   RETURN NEW;
END;$$ LANGUAGE plpgsql;

CREATE TRIGGER set_user_id_on_insert BEFORE INSERT ON "user"
FOR EACH ROW EXECUTE FUNCTION before_user_insert();