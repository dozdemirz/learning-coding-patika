import React from "react";

function Trainer() {
  return (
    <div>
      <section className="trainers blueish-background" id="trainers">
        <div className="container">
          <h1 className="sections-title">OUR BEST TRAINERS</h1>
          <div className="yellow-line" />
          <div className="solo-mid-content">
            <h3>
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsam
              qui repellat ipsum corrupti. Velit cum, eum quisquam consequuntur
              hic nesciunt?
            </h3>
          </div>
          <div className="trainers-img-container section-img-box">
            <div className="trainers-img-box">
              <img
                className="trainers-img "
                src="images/trainer1.jpg"
                alt="trainer1"
              />
              <div className="trainer-info">
                <h2>Trainer1</h2>
                <p>Trainer1</p>
              </div>
            </div>
            <div className="trainers-img-box">
              <img
                className="trainers-img"
                src="images/trainer2.jpg"
                alt="trainer2"
              />
              <div className="trainer-info">
                <h2>Trainer2</h2>
                <p>Trainer2</p>
              </div>
            </div>
            <div className="trainers-img-box">
              <img
                className="trainers-img"
                src="images/trainer3.jpg"
                alt="trainer3"
              />
              <div className="trainer-info">
                <h2>Jane Doe</h2>
                <p>Cardio Trainer</p>
              </div>
            </div>
          </div>
        </div>
      </section>
      {/* Purchase Section */}
      <section className="purchase white-background" id="purchase">
        <div className="container">
          <h1 className="sections-title">PURCHASE FROM US</h1>
          <div className="yellow-line" />
          <div className="solo-mid-content">
            <h3>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt,
              facilis? Delectus aut dolorum earum architecto, in eaque quos
              voluptate est.
            </h3>
          </div>
          <div className="purchase-img-container section-img-box">
            <div className="purchase-img-box">
              <img
                className="purchase-img"
                src="images/purchase1.jpg"
                alt="purchase1"
              />
              <div className="purchase-info-box">
                <h2>Kettlebell / 5kg </h2>
                <h3>
                  <span className="crossed-out">89,99$</span> / 59,99$
                </h3>
                <div className="adding-cart-section">
                  <img
                    className="purchase-cart"
                    src="images/purchase_cart.png"
                    alt="purchase"
                  />
                  <h3 className="add-to-cart">Add to Card</h3>
                </div>
              </div>
            </div>
            <div className="purchase-img-box">
              <img
                className="purchase-img"
                src="images/purchase2.jpg"
                alt="purchase1"
              />
              <div className="purchase-info-box">
                <h2>Treadmill</h2>
                <h3>
                  <span className="crossed-out">899,99$</span> / 599,99$
                </h3>
                <div className="adding-cart-section">
                  <img
                    className="purchase-cart"
                    src="images/purchase_cart.png"
                    alt="purchase"
                  />
                  <h3 className="add-to-cart">Add to Card</h3>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Trainer;
