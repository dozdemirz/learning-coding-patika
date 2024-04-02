import React from "react";

function Review() {
  return (
    <section className="review blueish-background" id="review">
      <div className="container">
        <h1 className="sections-title">REVIEW CLIENT</h1>
        <div className="yellow-line" />
        <div className="solo-mid-content">
          <h3>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos
            quibusdam unde sequi dolorem inventore deserunt fugit harum ipsa,
            dolor impedit.
          </h3>
        </div>
        <div className="review-container half-container">
          <div className="left-half">
            <div className="review-img-box">
              <img className="review-img" src="images/client1.jpg" alt="CFO" />
              <div className="img-text">
                <h3 className="review-manager">Diet Expert </h3>
                <h3 className="review-manager-title">CFO</h3>
              </div>
            </div>
            <div className="review-text-box">
              <h3 className="review-text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde
                soluta tempore porro culpa sunt mollitia ratione repudiandae
                fuga corporis. Cupiditate, nesciunt velit odit debitis rerum
                blanditiis molestias, odio, cumque distinctio saepe adipisci
                reprehenderit vitae laudantium tempore ipsum autem iusto
                numquam.
              </h3>
            </div>
          </div>
          <div className="right-half">
            <div className="review-img-box">
              <img className="review-img" src="images/client2.jpg" alt="CEO" />
              <div className="img-text">
                <h3 className="review-manager">Cardio Trainer </h3>
                <h3 className="review-manager-title">CEO</h3>
              </div>
            </div>
            <div className="review-text-box">
              <h3 className="review-text">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Excepturi recusandae beatae tempora officia eius aut doloremque
                porro commodi et necessitatibus possimus sequi sed in iusto
                facere vero labore quod quaerat, minima odit explicabo,
                doloribus tenetur? Expedita corporis modi eligendi? Facilis
                animi ex consequuntur quaerat nesciunt nihil repellat. Illum,
                laboriosam enim.
              </h3>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Review;
