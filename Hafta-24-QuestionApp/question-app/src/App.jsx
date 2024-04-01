import React, { useState, useEffect } from "react";
import "./App.css";
import questions from "./questions";

function App() {
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [correctAnswers, setCorrectAnswers] = useState(0);
  const [wrongAnswers, setWrongAnswers] = useState(0);
  const [emptyAnswers, setEmptyAnswers] = useState(0);
  const [secondsLeft, setSecondsLeft] = useState(30);
  const [showOptions, setShowOptions] = useState(false);
  const [showResults, setShowResults] = useState(false);
  const [answerStatus, setAnswerStatus] = useState(new Array(10).fill(null));

  useEffect(() => {
    const timer = setInterval(() => {
      if (secondsLeft > 0 && !showResults) {
        setSecondsLeft((prevSeconds) => prevSeconds - 1);

        // 10 saniye sonra
        if (secondsLeft === 20) {
          setShowOptions(true);
        }
      } else {
        if (currentQuestionIndex < questions.length - 1 && !showResults) {
          setCurrentQuestionIndex((prevIndex) => prevIndex + 1);
        } else {
          setShowResults(true);
          clearInterval(timer);
        }
        setSecondsLeft(30);
        setShowOptions(false);
      }
    }, 1000);

    return () => clearInterval(timer);
  }, [
    currentQuestionIndex,
    correctAnswers,
    wrongAnswers,
    emptyAnswers,
    secondsLeft,
    showResults,
  ]);

  const handleAnswer = (isCorrect) => {
    const updatedStatus = [...answerStatus];
    if (updatedStatus[currentQuestionIndex] === null) {
      if (isCorrect) {
        setCorrectAnswers((prevCount) => prevCount + 1);
      } else {
        setWrongAnswers((prevCount) => prevCount + 1);
      }
      updatedStatus[currentQuestionIndex] = isCorrect;
      setAnswerStatus(updatedStatus);
    }
    if (currentQuestionIndex < questions.length - 1 && !showResults) {
      setCurrentQuestionIndex((prevIndex) => prevIndex + 1);
    } else {
      setShowResults(true);
    }
    setSecondsLeft(30);
    setShowOptions(false);
  };

  const handleSkip = () => {
    const updatedStatus = [...answerStatus];
    if (updatedStatus[currentQuestionIndex] === null) {
      setEmptyAnswers((prevCount) => prevCount + 1); // Boş cevap sayısını arttır
      updatedStatus[currentQuestionIndex] = null;
      setAnswerStatus(updatedStatus);
    }
    if (currentQuestionIndex < questions.length - 1 && !showResults) {
      setCurrentQuestionIndex((prevIndex) => prevIndex + 1);
    } else {
      setShowResults(true);
    }
    setSecondsLeft(30);
    setShowOptions(false);
  };

  const handleRetry = () => {
    setCurrentQuestionIndex(0);
    setCorrectAnswers(0);
    setWrongAnswers(0);
    setEmptyAnswers(0);
    setSecondsLeft(30);
    setShowResults(false);
    setShowOptions(false);
    setAnswerStatus(new Array(10).fill(null));
  };

  const timerBarWidth = (secondsLeft / 30) * 100 + "%";

  return (
    <div className="app-container">
      <div className="header">
        <h1 className="title">QUESTION APP</h1>
      </div>
      {showResults ? (
        <div className="result-container">
          <h2>Test Sonuçları</h2>
          <p>Doğru Cevaplar: {correctAnswers}</p>
          <p>Yanlış Cevaplar: {wrongAnswers}</p>
          <p>Boş Cevaplar: {emptyAnswers}</p>
          <button className="retry-button" onClick={handleRetry}>
            Tekrar Dene
          </button>
          <div className="answer-indicators">
            {answerStatus.map((status, index) => (
              <div
                key={index}
                className="answer-indicator"
                style={{
                  backgroundColor:
                    status === null
                      ? "rgb(231, 231, 102)"
                      : status
                      ? "rgb(75, 177, 75)"
                      : "rgb(182, 41, 41)",
                }}
              >
                {index + 1}
                <div className="answer-info">
                  <p>Cevabınız: {questions[index].options[status]}</p>
                  <p>Doğru Cevap: {questions[index].answer}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      ) : (
        <div>
          <div className="question-number">Soru {currentQuestionIndex + 1}</div>
          <div className="img-container">
            <img
              className="question-img"
              src={`src/assets/${questions[currentQuestionIndex].media}`}
              alt=""
            />
          </div>
          <div className="text-container">
            <div className="question-text">
              {questions[currentQuestionIndex].question}
            </div>
          </div>
          {showOptions ? (
            <div className="options-container">
              {questions[currentQuestionIndex].options.map((option, index) => (
                <div
                  key={index}
                  className="option"
                  onClick={() =>
                    handleAnswer(
                      option === questions[currentQuestionIndex].answer
                    )
                  }
                >
                  {option}
                </div>
              ))}
            </div>
          ) : null}
          <div className="footer">
            {!showResults && (
              <div className="timer-bar-container">
                <div
                  className="timer-bar"
                  style={{ width: timerBarWidth }}
                ></div>
                <div className="time-left">{secondsLeft} sn kaldı</div>
              </div>
            )}
            <button className="skip-button" onClick={handleSkip}>
              Soruyu Atla
            </button>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
