import mysql.connector
from mysql.connector import Error

try:
    connection = mysql.connector.connect(host='your_host',
                                         database='your_database',
                                         user='your_user',
                                         password='your_password')

    cursor = connection.cursor()
    form = type('obj', (object,), {
        'quest_title': 'your_quest_title',
        'quest_difficulty': 'your_quest_difficulty',
        'quest_post': 'your_quest_post'
    })

    c = cursor
    c.execute("INSERT INTO quest_list (quest_title, quest_difficulty, quest_post) \
      VALUES (%s, %s, %s)", (form.quest_title, form.quest_difficulty, form.quest_post))

    connection.commit()
    print("Record inserted successfully")

except mysql.connector.Error as error:
    print("Failed to insert record: {}".format(error))

finally:
    if (connection.is_connected()):
        cursor.close()
        connection.close()
        print("MySQL connection is closed")