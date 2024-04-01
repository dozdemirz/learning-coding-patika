import { useState } from 'react'

function Card(props) {
    const [quantity, setQuantity] = useState(0);

    const buy = () => {
        props.updateBalance(x => x - props.price)
        setQuantity(quantity + 1);
        props.updateBasket(props.id, "buy");
    }

    const sell = () => {
        props.updateBalance(x => x + props.price)
        setQuantity(quantity - 1);
        props.updateBasket(props.id, "sell");
    }

    return (
        <>
            <div className='card-container'>
                <img src={props.image} alt="" />
                <div className='item-info'>
                    <div className='item-name'>{props.name}</div>
                    <div className='item-price'>${props.price}</div>
                </div>
                <div className='item-controls'>
                    <button disabled={!quantity} className='item-sell' onClick={sell}>SELL</button>
                    <input className='input' type="text" value={quantity} />
                    <button disabled={props.price > props.balance} className='item-buy' onClick={buy}>BUY</button>
                </div>
            </div>
        </>
    )
}

export default Card  