CREATE OR REPLACE FUNCTION cerberus() RETURNS trigger
   LANGUAGE plpgsql AS
$$BEGIN
   IF NEW.forbiddencol IS DISTINCT FROM OLD.forbiddencol
      AND current_user = 'luser'
   THEN
      RAISE EXCEPTION '"luser" must not update "forbiddencol"';
   END IF;
   RETURN NEW;
END;$$;

CREATE TRIGGER cerberus BEFORE UPDATE OF forbiddencol ON mytable
   FOR EACH ROW EXECUTE PROCEDURE cerberus();