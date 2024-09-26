batch_size = 50
for i in range(0, len(rows_to_insert), batch_size):
    errors = BQclient.insert_rows(table_id, rows_to_insert[i : i + batch_size])

if not errors:
     print("New rows have been added.")
else:
     print("Encountered errors while inserting rows: {}".format(errors))