
CREATE POLICY read_event
ON event
FOR SELECT
USING (
    event.host_id = current_user_id() -- Assuming current_user_id() returns the current user's id
    OR event.privacy = 0 -- Public
    OR (
        event.privacy = 1
        AND (
            EXISTS (
                SELECT 1
                FROM friendship
                WHERE
                    (friendship.user_id = current_user_id() AND friendship.friend_id = event.host_id)
                    OR (friendship.friend_id = current_user_id() AND friendship.user_id = event.host_id)
            )
            OR EXISTS (
                SELECT 1
                FROM invitation
                WHERE invitation.user_id = current_user_id() AND invitation.event_uuid = event.uuid
            )
        )
    )
);

