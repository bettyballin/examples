
unsafe_query = f"INSERT INTO sensors (name) VALUES ('{name}')"
await connection.execute(unsafe_query)

