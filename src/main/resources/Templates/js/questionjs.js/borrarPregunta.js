function guardarEncuestaEliminar() {
    const idPregunta = document.getElementById('idPreguntaEliminar').value;
    const url = 'http://localhost:8080/questionapi?questionId=' + encodeURIComponent(idPregunta);

    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => {
                throw new Error('Network response was not ok: ' + text);
            });
        }
        return response.text(); // Cambia a .text() ya que la respuesta no es JSON
    })
    .then(data => {
        console.log('Success:', data);
        alert('Pregunta eliminada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al eliminar el capitlo.');
    });
}