// Question.jsx
import React, { useState, useEffect } from "react";

const Question = ({ question, options, answer, media, onAnswer }) => {
  const [selectedOption, setSelectedOption] = useState(null);
  const [showOptions, setShowOptions] = useState(false);

  
  return (
    <div className="question-box">
      <img className="question-img" src={media} alt="" />
      <h1 className="question">{question}</h1>
      {showOptions && (
        <ul className="options">
          {options.map((option, index) => (
            <li
              key={index}
              className={`option ${
                selectedOption === option ? "selected" : ""
              }`}
              onClick={() => handleOptionClick(option)}
            >
              {option}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Question;
