import { useState } from 'react'

function Receipt(props) {
    return (
        <div className="receiptContainer">
            <div>{props.name}</div>
            <div>x{props.quantity}</div>
            <div className='receiptPrice'>${props.price}</div>
        </div>
    );
}

export default Receipt