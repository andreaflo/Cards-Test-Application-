
type Props = {
 card: Card
}

 export default function CardItem({ id, name, description, imageUrl }) {
   return (
     <div className="card">
       <img src={imageUrl} alt={name} />
       <h3>{name}</h3>
       <p>{description}</p>
     </div>
   );
 }

