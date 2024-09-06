function guardarEncuestaActualizar() {
    const id = document.getElementById('idEncuestaActualizar').value;
    const nombre = document.getElementById('nombreEncuestaActualizar').value;
    const descripcion = document.getElementById('descripcionEncuestaActualizar').value;
    const jwtToken = localStorage.getItem("jwtToken")
    console.log("SURVER CREATION JWTOKEN "+jwtToken)    

    fetch('http://localhost:8080/surveyapi', { // Usando PUT para actualización
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwtToken  

        },
        body: JSON.stringify({
            id: id,
            name : nombre,
            description : descripcion
        }),
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => {
                throw new Error('Network response was not ok: ' + text);
            });
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        alert('Encuesta actualizada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar la encuesta.');
    });
}