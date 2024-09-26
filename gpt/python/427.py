
for row in tableRows:
    try:
        subdomain = row.find_all('td')[4].text
        subdomain = subdomain.replace("*.", "")  # Make sure the indentation is consistent
        if subdomain not in self.foundURLsList:
            self.foundURLsList.append(subdomain)
    except Exception as e:
        pass

