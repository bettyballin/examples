
c.execute("INSERT INTO quest_list (quest_title, quest_difficulty, quest_post) VALUES (%s, %s, %s)", 
          (form.quest_title, form.quest_difficulty, form.quest_post))

