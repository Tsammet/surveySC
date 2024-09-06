function guardarEncuestaActualizar() {
    const id = document.getElementById('idPreguntaActualizar').value;
    const idCapitulo = document.getElementById('idCapituloActualizar').value;
    const numeroPregunta = document.getElementById('numeroPreguntaActualizar').value;
    const responseType = document.getElementById('responseType').value;
    const textoPregunta = document.getElementById('textoPreguntaActualizar').value;
    const comentarioPregunta = document.getElementById('comentarioPreguntaActualizar').value;
    const jwtToken = localStorage.getItem("jwtToken")
    console.log("SURVER CREATION JWTOKEN "+jwtToken)    


    fetch('http://localhost:8080/questionapi', { // Usando PUT para actualización
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwtToken  

        },
        body: JSON.stringify({
            id : id,
            chapterId : idCapitulo,
            questionNumber: numeroPregunta,
            responseType: responseType,
            questionText: textoPregunta,
            commentQuestion: comentarioPregunta,
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
        alert('Pregunta actualizada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar la pregunta.');
    });
}