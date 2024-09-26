CREATE OR REPLACE FUNCTION is_authorized(userid INT) RETURNS BOOLEAN AS $$
    SELECT EXISTS(
        SELECT 1
        FROM (
            VALUES
                -- user is host
                ((SELECT event.host_id WHERE uuid = $1), 'is_host'),
                -- privacy level
                ((SELECT 
                    CASE 
                        WHEN public THEN 1 
                        ELSE NULL 
                    END,
                    CASE 
                        WHEN friends AND EXISTS(
                            SELECT * FROM friendship
                            WHERE (user_id=$1 OR friend_id=$1)
                        ) THEN 2
                        ELSE NULL
                    END
                ), 'privacy'),
                -- user is invited
                ((SELECT invitation.event_uuid
                    FROM invitation
                   WHERE event_uuid = $1 AND user_id = $1), 'is_invited')
        ) AS t(val, type)
       WHERE val IS NOT NULL
    );
$$ LANGUAGE SQL STABLE SECURITY DEFINER SET search_path=public;

CREATE POLICY read_event ON event FOR SELECT USING (
    is_authorized((SELECT current_setting('jwt.claims.userid'::text))::INT)
);