
import {useEffect,useState} from 'react';
import {getCards} from '../api/cardApi';
import CardItem from '../components/CardItem.jsx';

export default function CardList(){
 const[cards,setCards]=useState([]);
 useEffect(()=>{getCards().then(r=>setCards(r.data));},[]);
 return <>{
 <div className="card-grid-wrapper">
   <div className="card-grid">
     {cards.map((c) => (
       <div className="card" key={c.id}>
         <img src={c.imageUrl} alt={c.name} />
         <h3>{c.name}</h3>
         <p>{c.description}</p>
         <button>Dettagli</button>
       </div>
     ))
 }
 </div>
 </div>
 }</>;
}
