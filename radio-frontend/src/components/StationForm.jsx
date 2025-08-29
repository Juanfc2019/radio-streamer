import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from 'axios';

const API_URL = 'https://localhost:8080/api/stations';

function StationForm(){
    const [station, setStation] = useState({name: '', streamUrl: '', genre: '', country: ''});
    const {id} = useParams();
    const navigate = useNavigate();
    const isEditing = Boolean(id);

    useEffect(() => {
        if (isEditing){
            axios.get(`${API_URL}/${id}`)
            .then(response => setStation(response.data))
            .catch(error => console.error('Error fetching station:', error));
        }
    }, [id, isEditing]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setStation(prev => ({ ...prev, [name]: value }));
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const request = isEditing 
            ? axios.put(`${API_URL}/${id}`, station) 
            : axios.post(API_URL, station);
        
        request
            .then(() => navigate('/stations'))
            .catch(error => console.error('Error saving station:', error));
    }

    return(
        <>
        <form onSubmit={handleSubmit}>
            <h2>{isEditing ? 'Editar' : 'Añadir'} Estación</h2>
            <input name="name" value={station.name} onChange={handleChange} placeholder="Nombre" required/>
            <input name="streamUrl" value={station.streamUrl} onChange={handleChange} placeholder="URL del Stream" required/>
            <input name="genre" value={station.genre} onChange={handleChange} placeholder="Género" required/>
            <input name="country" value={station.country} onChange={handleChange} placeholder="País" required/>
            <button type="submit">Guardar</button>
            <button type="button" onClick={() => navigate('/')}>Cancelar</button>
        </form>
        </>
    );
}

export default StationForm;