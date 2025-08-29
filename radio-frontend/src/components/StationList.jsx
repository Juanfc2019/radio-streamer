import React from "react";
import { useNavigate } from "react-router-dom";

function StationList({ stations, onPlay, onDelete}) {
    const navigate = useNavigate();

    return (
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Género</th>
                    <th>País</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                {stations.map((station) => (
                    <tr key={station.id}>
                        <td>{station.name}</td>
                        <td>{station.genre}</td>
                        <td>{station.country}</td>
                        <td>
                            <button onClick={() => onPlay(station)}>Reproducir</button>
                            <button onClick={() => navigate(`/edit/${station.id}`)}>Editar</button>
                            <button onClick={() => onDelete(station.id)}>Eliminar</button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default StationList;