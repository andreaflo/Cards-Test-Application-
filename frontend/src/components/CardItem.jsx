// Rimosso "type Props", non valido in JS standard
export default function CardItem({ card }) {
    // Destructuring dei dati dall'oggetto card
    const { name, description, imageUrl } = card;

    return (
        <div className="card">
            <img src={imageUrl} alt={name} />
            <h3>{name}</h3>
            <p>{description}</p>
        </div>
    );
}
