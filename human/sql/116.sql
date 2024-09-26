-- Assuming you are using Java and have a Connection object named conn
PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TRANSACTIONS WHERE TAG=? AND ID=?");
pstmt.setString(1, user_entered_tag);
pstmt.setString(2, user_id);
ResultSet results = pstmt.executeQuery();