import { useState } from "react";
import "./App.css";
import Products from "./components/Products";
import Receipt from "./components/Receipt";
import { products } from "./data";

function App() {

  const [balance, setBalance] = useState(100000000000);
  const [basket, setBasket] = useState(products);
  const [count, setCount] = useState(0);
  const [totalPrice, setTotalPrice] = useState(0);

  const updateBalance = (newBalance) => {
    setBalance(newBalance);
  };

  function updateBasket(id, state) {
    const newBasket = structuredClone(basket);
    if (state === "buy") {
      newBasket[id].quantity += 1;
      setBasket(newBasket);
      setCount(count + 1);
      setTotalPrice(totalPrice + newBasket[id].price);
    } else {
      newBasket[id].quantity -= 1;
      setBasket(newBasket);
      setCount(count - 1);
      setTotalPrice(totalPrice - newBasket[id].price)
    }
  }

  return (
    <>
      <div >
        <div className="container">
          <div className="header">
          <img alt="Image of Bill Gates" src="https://neal.fun/spend/billgates.jpg" class="header-img" />
          <p>Spend Bill Gates' Money</p>
          </div>
        <h1 className="money">${balance}</h1>
        <div className='card'>
          {basket.map((card) => {
            return (
              <Products
                key={card.name}
                id={card.id}
                name={card.name}
                price={card.price}
                image={card.image}
                balance={balance}
                updateBalance={updateBalance}
                updateBasket={updateBasket}
              />
            );
          })}
        </div>
        {count > 0 && (
          <div className="receipt">
            <div className='receiptName'>Your Receipt</div>
            {basket.map((item) => {
              if (item.quantity > 0) {
                return (
                  <Receipt
                    key={item.id}
                    name={item.name}
                    price={item.price}
                    quantity={item.quantity}
                  />
                );
              }
            })}
            <hr className='receiptLine' />
            <div className='total'>
              <div>TOTAL</div>
              <div>${totalPrice}</div>
              <br />
              <br />
            </div>
          </div>

        )}
        </div>
      </div>
    </>
  )
}

export default App;