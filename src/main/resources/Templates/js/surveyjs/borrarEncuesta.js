function guardarEncuestaEliminar() {
<<<<<<< HEAD
    const nombreEncuesta = document.getElementById('nombreEncuestaEliminar').value;
    const url = 'http://localhost:8080/surveyapi?surveyName=' + encodeURIComponent(nombreEncuesta);
    const jwtToken = localStorage.getItem("jwtToken")
    console.log("SURVER CREATION JWTOKEN "+jwtToken)    
=======
    const idEncuesta = document.getElementById('idEncuestaEliminar').value;
    const url = 'http://localhost:8080/surveyapi?surveyId=' + encodeURIComponent(idEncuesta);
>>>>>>> 3077f926251bf602786ad222e2a5f951c728423a

    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwtToken  

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
        alert('Encuesta eliminada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al eliminar la encuesta.');
    });
}