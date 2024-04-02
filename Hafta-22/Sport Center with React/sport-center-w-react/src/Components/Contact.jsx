import React from "react";

function Contact() {
  return (
    <section className="contact-us white-background" id="contact-us">
      <div className="container">
        <h1 className="sections-title">CONTACT US</h1>
        <div className="yellow-line" />
        <div className="solo-mid-content">
          <h3>
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Possimus
            ipsa ea minima, nesciunt perspiciatis accusamus debitis cupiditate
            autem sunt eveniet?
          </h3>
        </div>
        <div className="contact-us-container half-container">
          <div className="left-half">
            <div className="info-box">
              <div className="mobile-number">
                <h2>Mobile Number</h2>
                <h3>+135 773 321 4442</h3>
              </div>
              <div className="email-address">
                <h2>Email Address</h2>
                <h3>demo@demo.com</h3>
              </div>
            </div>
            <div className="message-box">
              <h1>Make An Appoinment</h1>
              <div className="fr1-box">
                <input
                  className=" contact-boxes"
                  type="text"
                  id="name"
                  name="name"
                  placeholder="Your Name"
                />
              </div>
              <div className="fr1-box">
                <input
                  className=" contact-boxes"
                  type="text"
                  id="email"
                  name="email"
                  placeholder="Your Email"
                />
              </div>
              <div className="fr2-box">
                <input
                  className=" contact-boxes fr2"
                  type="text"
                  id="message"
                  name="message"
                  placeholder="Your Message"
                />
              </div>
            </div>
          </div>
          <div className="right-half map-container">
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3074160.7247336176!2d72.10663427767852!3d41.19757353558106!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6fc19cb959b1a04d%3A0x8f6754680707122e!2sTuvalu!5e0!3m2!1str!2str!4v1706906079583!5m2!1str!2str"
              width={600}
              height={450}
              style={{ border: 0 }}
              allowFullScreen
              loading="lazy"
              referrerPolicy="no-referrer-when-downgrade"
            />
          </div>
        </div>
      </div>
    </section>
  );
}

export default Contact;
