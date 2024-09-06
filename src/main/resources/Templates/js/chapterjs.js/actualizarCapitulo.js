function guardarEncuestaActualizar() {
    const id = document.getElementById('idCapituloActualizar').value;
    const idEncuesta = document.getElementById('idEncuestaActualizar').value;
    const numeroCapitulo = document.getElementById('numeroCapituloActualizar').value;
    const tituloCapitulo = document.getElementById('tituloCapituloActualizar').value;
    const jwtToken = localStorage.getItem("jwtToken")
    console.log("SURVER CREATION JWTOKEN "+jwtToken)    

    fetch('http://localhost:8080/chapterapi', { // Usando PUT para actualización
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwtToken  

        },
        body: JSON.stringify({
            id: id,
            surveyId : idEncuesta,
            chapterTitle : tituloCapitulo,
            chapterNumber : numeroCapitulo
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
        alert('Capitulo actualizado con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar el Capitulo.');
    });
}