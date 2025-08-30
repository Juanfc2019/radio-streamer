import React from "react";
import ReactPlayer from 'react-player';

function RadioPlayer({ station }) {
    if (!station) {
        return <div>Selecciona una estación para reproducir</div>
    }

    return (
        <>
            <div>
                <h3>Reproduciendo: {station.name}</h3>
                <ReactPlayer
                    url={station.streamUrl}
                    autoPlay={true}
                    controls={true}
                    width="100%"
                    height="auto" // Adjust height as needed
                />
                {/*                 <audio controls>
                    <source src={station.streamUrl} type="audio/mpeg" />
                    Tu navegador no soporta el elemento de audio.
                </audio> */}
            </div>
        </>
    );
}

export default RadioPlayer;