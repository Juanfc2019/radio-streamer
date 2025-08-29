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
            playing={true}
            controls={true}
            width="100%"
            height="50px"
            config={{
                file:  {
                    forceAudio: true,
                }
            }}
            />
        </div>
        </>
    );
}

export default RadioPlayer;