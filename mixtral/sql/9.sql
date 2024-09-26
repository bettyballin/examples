SET enable_seqscan = OFF;

SELECT * 
FROM public.document 
WHERE (
     to_tsvector(
         'english', 
         content || ' ' || COALESCE(title, '')
     ) @@ plainto_tsquery('english', 'fulltext_search_documents.search_text')
);

SET enable_seqscan = ON;