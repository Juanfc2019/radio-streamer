import { useEffect, useState } from 'react'
import './App.css'
import RadioPlayer from './components/RadioPlayer.jsx';
import axios from 'axios';
import { Link } from 'react-router-dom';
import StationList from './components/StationList';

const API_URL = 'http://localhost:8080/api/stations';

function App() {
  const [message, setMessage] = useState('');
  const [stations, setStations] = useState([]);
  const [currentStation, setCurrentStation] = useState(null);

  const fetchMessage = () => {
      fetch('http://localhost:8080/api/hello')
      .then(response => response.json())
      .then(data => setMessage(data.message))
      .catch(error => console.error('Error al conectar con el backend:', error));
  };

  const fetchStations = () => {
    axios.get(API_URL)
      .then(response => setStations(response.data))
      .catch(error => console.error('Error fetching stations:', error));
  };

  useEffect(() => {
    fetchMessage();
    fetchStations();
  }, []);

    const handleDelete = (id) => {
    if (window.confirm('¿Estás seguro de que quieres eliminar esta estación?')) {
      axios.delete(`${API_URL}/${id}`)
        .then(() => fetchStations())
        .catch(error => console.error('Error deleting station:', error));
    }
  }

  return (
    <>
    <div className="App">
      <header>
        <h1>Proyecto de Radio Streamer</h1>
        <p>Mensaje del backend: <strong>{message}</strong></p>

        <Link to="/add">
          <button>Añadir Nueva Estación</button>
        </Link>
      </header>
      <main>
        <StationList stations={stations} onPlay={setCurrentStation} onDelete={handleDelete} />
      </main>
      <footer>
      <RadioPlayer station={currentStation} />
      </footer>
    </div>
    </>
  )
}

export default App
