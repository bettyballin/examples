
query = model.Sensor.__table__.insert().values(name=name)
await connection.execute(query)

