CREATE TABLE workers
(
    worid   int,
    worname text,
    pgrole text[]
);

INSERT INTO workers 
VALUES 
  (1,'Jason','{group1}'),
  (2,'Roy','{group1,group2}'),
  (3,'Johny','{group1}');

CREATE POLICY policy_employee_user ON workers FOR ALL
TO PUBLIC 
   USING ( (select count(*) 
            from unnest(pgrole) r 
            where pg_has_role(current_user, r, 'MEMBER')) > 0 );

ALTER TABLE workers ENABLE ROW LEVEL SECURITY;