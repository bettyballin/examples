import mysql.connector

# assuming you have a mysql connection established
cnx = mysql.connector.connect(
    user='username',
    password='password',
    host='127.0.0.1',
    database='database_name'
)

# assuming you have a cursor object 'c' and a form object 'form'
c = cnx.cursor()

c.execute("INSERT INTO quest_list(quest_title, quest_difficulty, quest_post)\
          VALUES (%s, %s, %s)", (form.quest_title, form.quest_difficulty, form.quest_post))

cnx.commit()
cnx.close()