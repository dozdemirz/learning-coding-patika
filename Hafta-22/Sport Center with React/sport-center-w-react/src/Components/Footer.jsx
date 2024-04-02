import React from "react";

function Footer() {
  return (
    <footer className="footer">
      <div className="container">
        <div className="footer-header">
          <div className="footer-img-container">
            <img src="images/logo.png" alt="logo" />
            <h3>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae,
              perspiciatis quis? Ex distinctio repudiandae quibusdam quas in.
              Recusandae, porro! Autem consequatur soluta ipsa, quas quae
              corrupti. Itaque velit facere accusantium.
            </h3>
          </div>
        </div>
        <div className="footer-links">
          <div className="information">
            <h1>Information</h1>
            <h3>About Us</h3>
            <h3>Classes</h3>
            <h3>Blog</h3>
            <h3>Contact</h3>
          </div>
          <div className="helpful">
            <h1>Helpful Links</h1>
            <h3>Services</h3>
            <h3>Supports</h3>
            <h3>Terms &amp; Condition</h3>
            <h3>Privacy Policy</h3>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
