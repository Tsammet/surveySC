function guardarEncuestaActualizar() {
    const id = document.getElementById('idResponseOptionActualizar').value;
    const optionValue = document.getElementById('optionValueActualizar').value;
    const commentResponse = document.getElementById('commentResponseActualizar').value;
    const optionText = document.getElementById('optionTextActualizar').value;
    const questionId = document.getElementById('questionIdActualizar').value;
    const jwtToken = localStorage.getItem("jwtToken")
    console.log("SURVER CREATION JWTOKEN "+jwtToken)    

    fetch('http://localhost:8080/responseoptionapi', { // Usando PUT para actualización
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwtToken  

        },
        body: JSON.stringify({
            id : id,
            option_value : optionValue,
            commentResponse: commentResponse,
            optionText: optionText,
            questionId: questionId,
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
        alert('Opción de respuesta actualizada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar la opción de respuesta.');
    });
}