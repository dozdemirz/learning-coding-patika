import React from "react";

function Navbar() {
  return (
    <header className="navbar" id="navbar">
      <div className="container">
        <div className="navbar-div">
          <div className="navbar-logo">
            <img className="logo" src="images/logo.png" alt="top-logo" />
          </div>
          <div className="menu">
            <a href="">Home</a>
            <a href="#classes">Classes</a>
            <a href="#trainers">Trainer</a>
            <a href="#review">Review</a>
            <a href="#contact-us">Contact</a>
            <a className="join-us" href="">
              JOIN US
            </a>
          </div>
          <div className="mobile-menu-icon">
            <div className="bar" />
            <div className="bar" />
            <div className="bar" />
          </div>
        </div>
      </div>
    </header>
  );
}

export default Navbar;
