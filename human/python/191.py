import locale

lang = None

if lang is None:
    # if lang is not specified, default language is used
    def_locale = locale.getdefaultlocale()
    langCounty = def_locale[0]   # en_UK
    if langCounty is not None:
        lang = langCounty[:2]  # en

print(lang)