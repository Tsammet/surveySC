function guardarEncuestaCrear() {
    const idCapitulo = document.getElementById('idCapitulo').value;
    const numeroPregunta = document.getElementById('numeroPregunta').value;
    const responseType = document.getElementById('responseType').value;
    const textoPregunta = document.getElementById('textoPregunta').value;
    const comentarioPregunta = document.getElementById('comentarioPregunta').value;

    fetch('http://localhost:8080/questionapi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            chapterId : idCapitulo,
            questionNumber: numeroPregunta,
            responseType: responseType,
            questionText: textoPregunta,
            commentQuestion: comentarioPregunta,
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
        alert('Pregunta creada con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al crear el capitulo.');
    });
}