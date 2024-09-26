c.execute("INSERT INTO quest_list (quest_title, quest_difficulty, quest_post) \
  VALUES (%s, %s, %s)", (form.quest_title.data, form.quest_difficulty.data, form.quest_post.data))

or 

c.execute("INSERT INTO quest_list (quest_title, quest_difficulty, quest_post) \
  VALUES (%s, %s, %s)", (request.form['quest_title'], request.form['quest_difficulty'], request.form['quest_post']))