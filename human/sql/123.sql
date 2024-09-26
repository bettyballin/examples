CREATE OR REPLACE FUNCTION private.filter_document(p_search_text text)
RETURNS SETOF public.document AS
$$
    SELECT * FROM public.document WHERE (
        to_tsvector(
            'english',
            content || ' ' || COALESCE(title, '')
        ) @@ plainto_tsquery('english', p_search_text)
    )
$$
LANGUAGE SQL STABLE SECURITY DEFINER;

CREATE OR REPLACE FUNCTION public.filter_document(p_search_text text)
RETURNS SETOF public.document AS
$$
    SELECT filtered_d.* FROM private.filter_document(p_search_text) AS filtered_d
        INNER JOIN public.document AS d ON (d.id = filtered_d.id)
$$
LANGUAGE SQL STABLE;