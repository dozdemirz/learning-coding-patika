import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function StarShips() {
  const [starShips, setStarShips] = useState([]);
  const [filteredStarShips, setFilteredStarShips] = useState("");
  const [selectedShip, setSelectedShip] = useState(null);
  const [isVisible, setIsVisible] = useState(true);
  const [newShipData, setNewShipData] = useState({
    name: "",
    model: "",
    hyperdrive_rating: "",
    manufacturer: "",
    length: "",
    max_atmosphering_speed: "",
    crew: "",
  });

  const filtered = starShips.filter((starShip) => {
    return (
      (starShip.name &&
        starShip.name
          .toLowerCase()
          .includes(filteredStarShips.toLowerCase())) ||
      (starShip.model &&
        starShip.model.toLowerCase().includes(filteredStarShips.toLowerCase()))
    );
  });

  useEffect(() => {
    axios("https://swapi.dev/api/starships/")
      .then((res) => setStarShips(res.data.results))
      .catch((error) => console.error("Error fetching starships:", error));
  }, []);

  const handleDetailsClick = (ship) => {
    setSelectedShip(ship);
    setIsVisible(false);
  };

  const handleCloseDetails = () => {
    setSelectedShip(null);
    setIsVisible(true);
  };

  const handleAddShip = () => {
    const newShip = {
      name: newShipData.name || "Unknown",
      model: newShipData.model || "Unknown",
      hyperdrive_rating: newShipData.hyperdrive_rating || "Unknown",
      manufacturer: newShipData.manufacturer || "Unknown",
      length: newShipData.length || "Unknown",
      max_atmosphering_speed: newShipData.max_atmosphering_speed || "Unknown",
      crew: newShipData.crew || "Unknown",
    };

    setStarShips((prevShips) => [...prevShips, newShip]);

    setNewShipData({
      name: "",
      model: "",
      hyperdrive_rating: "",
      manufacturer: "",
      length: "",
      max_atmosphering_speed: "",
      crew: "",
    });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewShipData((prevData) => ({ ...prevData, [name]: value }));
  };

  return (
    <div>
      <img src="https://pngimg.com/uploads/star_wars_logo/star_wars_logo_PNG42.png" alt="" className="logo"/>

      {isVisible && (
        <input
          placeholder="Filter by Name & Model..."
          value={filteredStarShips}
          onChange={(e) => setFilteredStarShips(e.target.value)}
          className="search"
        />
      )}

      {isVisible && (
        <div className="card-container">
          {filtered.map((starShip) => (
            <div key={starShip.name} className="card">
              <img
                src="https://img.redbull.com/images/q_auto,f_auto/redbullcom/2017/09/20/0bba35af-bf8c-4296-8cbd-1e4ccedfcc6a/star-wars-spaceships-millennium-falcon"
                alt={starShip.name}
                className="ship-image"
              />
              <h2>{starShip.name}</h2>
              <p>
                <span>Model:</span> {starShip.model}
              </p>
              <p>
                <span> Hyperdrive Rating:</span> {starShip.hyperdrive_rating}
              </p>
              <button
                className="details"
                onClick={() => handleDetailsClick(starShip)}
              >
                Details
              </button>
            </div>
          ))}
        </div>
      )}

      {selectedShip && (
        <div className="details-overlay">
          <div className="details-card">
            <img
              src="https://img.redbull.com/images/q_auto,f_auto/redbullcom/2017/09/20/0bba35af-bf8c-4296-8cbd-1e4ccedfcc6a/star-wars-spaceships-millennium-falcon"
              alt={selectedShip.name}
              className="ship-image"
            />
            <h2>{selectedShip.name}</h2>
            <p>
              <span>Model:</span> {selectedShip.model}
            </p>
            <p>
              <span>Hyperdrive Rating:</span> {selectedShip.hyperdrive_rating}
            </p>
            <p>
              <span>Manufacturer:</span> {selectedShip.manufacturer}
            </p>
            <p>
              <span>Length:</span> {selectedShip.length}
            </p>
            <p>
              <span>Max Atmosphering Speed:</span>
              {selectedShip.max_atmosphering_speed}
            </p>
            <p>
              <span> Crew:</span> {selectedShip.crew}
            </p>
            <button className="close" onClick={handleCloseDetails}>
              Close
            </button>
          </div>
        </div>
      )}

      <hr />
    </div>
  );
}

export default StarShips;