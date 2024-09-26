import type { NextApiRequest, NextApiResponse } from 'next';
import axios from 'axios';

export default async function handler(req: NextApiRequest, res: NextApiResponse) {
  const apiKey = process.env.FLICKR_API_KEY;

  if (!apiKey || req.method !== "GET") return res.status(401).json({ error: 'Unauthorized' });

  try {
    // Fetch data from the API
    const response = await axios(`https://www.flickr.com/services/rest?api_key=${apiKey}&method=flickr.photos.search&user_id=${req.query.userid}&tags=${req.query.tags}`);

    res.status(200).json({ data: response.data });
  } catch (error) {
    console.log('Error fetching Flickr photos:', error);

    return res.status(503).send("Failed to load flicker images");
  }
}