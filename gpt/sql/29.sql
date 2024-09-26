
ALTER 
    DEFINER = CURRENT_USER
    SQL SECURITY INVOKER
    VIEW view_x AS
    (SELECT ... your original select statement here ...);

