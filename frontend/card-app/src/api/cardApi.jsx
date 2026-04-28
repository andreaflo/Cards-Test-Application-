
import axios from 'axios';

export const getCards = () =>
  axios.get('http://localhost:8080/api/cards/all');
