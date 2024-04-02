// src/App.js

import React from "react";
import "./App.css";
import Navbar from "./Components/Navbar";
import Classes from "./Components/Classes";
import HeaderContent from "./Components/HeaderContent";
import Boxes from "./Components/Boxes";
import Trainer from "./Components/Trainer";
import Review from "./Components/Review";
import Contact from "./Components/Contact";
import Footer from "./Components/Footer";

function App() {
  return (
    <div className="body">
      <Navbar />
      <HeaderContent />
      <Boxes />
      <Classes />
      <Trainer />
      <Review />
      <Contact />
      <Footer />
    </div>
  );
}

export default App;
