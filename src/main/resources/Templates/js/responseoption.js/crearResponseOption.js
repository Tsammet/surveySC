function guardarEncuestaCrear() {
    const optionValue = document.getElementById('optionValue').value;
    const commentResponse = document.getElementById('commentResponse').value;
    const optionText = document.getElementById('optionText').value;
    const questionId = document.getElementById('questionId').value;

    fetch('http://localhost:8080/responseoptionapi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            option_value : optionValue,
            commentResponse: commentResponse,
            optionText: optionText,
            questionId: questionId,
        }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        alert('Opción de respuesta creada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al crear la opción de respuesta.');
    });
}